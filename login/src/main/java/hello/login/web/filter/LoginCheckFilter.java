package hello.login.web.filter;

import hello.login.web.SessionConst;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {

    private static final String[] whiteList = {"/", "/members/add", "/login", "/logout", "/css/*"};
    // CSS는 왜?
    // login 안됐다고 해서 CSS 호출이 안되면 안되닌까!

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {// try 블록은  예외가 발생할 수 있는 코드를 포함합니다.
            log.info("인증 체크 필터 시작 {}", requestURI);

            if (isLoginCheckPath(requestURI)) {
                log.info("인증 체크 로직 실행 {}", requestURI);
                HttpSession session = httpRequest.getSession(false);

                if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
                    log.info("미인증 사용자 요청 {}", requestURI);
                    //로그인으로 redirect
                    httpResponse.sendRedirect("/login?redirectURL=" + requestURI);  //로그인 후 다시 원래 페이지로 오기 위함
                    return;
                }
            }
            chain.doFilter(request, response);
        } catch (Exception e) {// catch 블록 발생한 예외를 처리하는 코드입니다.
            throw e;
        } finally {// finally 블록 항상 실행되는 코드입니다. 예외 발생 여부와 상관없이 try-catch 블록이 끝난 후 반드시 실행
            log.info("인증 체크 필터 종료 {}", requestURI);
        }
    }

    /**
     * 화이트 리스트의 경우 인증 체크 X
     * 요청 URI가 whiteList에 존재하지 않을 때 true 리턴 -> 필터 적용하기 위해
     * 로그인체크하는 경로인지 확인하는것이기 때문에 ! (부정)으로 함.
     */
    private boolean isLoginCheckPath(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whiteList, requestURI);
    }
}
