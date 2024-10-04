package hello.login.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //ServletRequest은 HttpServletRequest의 부모인데 기능이 많이 없기 때문에 다운캐스팅
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();

        String uuid = UUID.randomUUID().toString();

        try { // try 블록은  예외가 발생할 수 있는 코드를 포함합니다.
            log.info("REQUEST [{}][{}]", uuid, requestURI);
            chain.doFilter(request, response);  // 다음 필터 호출(필수, 다음 필터가 없으면 서블릿이 호출됨)
        } catch (Exception e) { // catch 블록 발생한 예외를 처리하는 코드입니다.
            throw e;
        } finally {// finally 블록 항상 실행되는 코드입니다. 예외 발생 여부와 상관없이 try-catch 블록이 끝난 후 반드시 실행
            log.info("RESPONSE [{}][{}]", uuid, requestURI);
        }
    }

    @Override
    public void destroy() {
        log.info("log filter destroy");
    }
}
