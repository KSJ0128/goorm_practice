package hello.login.web.session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class SessionInfoController {

    @GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session == null) {
            return "세션이 없습니다.";
        }

        //세션 데이터 출력
        session.getAttributeNames().asIterator()
                .forEachRemaining(name -> log.info("session name={}, value={}",
                        name, session.getAttribute(name)));

        // 세션의 고유 ID를 로그로 출력 (세션을 식별하는 유일한 값)
        log.info("sessionId={}", session.getId());

        // 세션의 최대 비활성화 시간을 로그로 출력 (초 단위)
        // 이 시간 동안 클라이언트가 요청하지 않으면 세션이 만료됨
        log.info("maxInactiveInterval={}", session.getMaxInactiveInterval());

        // 세션이 생성된 시간을 로그로 출력 (밀리초 단위 타임스탬프를 Date 객체로 변환)
        // 사람이 읽을 수 있는 형식으로 세션 생성 시각을 확인 가능
        log.info("creationTime={}", new Date(session.getCreationTime()));

        // 세션이 마지막으로 접근된 시간을 로그로 출력 (밀리초 단위 타임스탬프를 Date 객체로 변환)
        // 사람이 읽을 수 있는 형식으로 마지막 요청 시각을 확인 가능
        log.info("lastAccessedTime={}", new Date(session.getLastAccessedTime()));

        // 세션이 새로 생성된 것인지 여부를 로그로 출력 (true: 새로운 세션, false: 기존 세션)
        log.info("isNew={}", session.isNew());


        return "세션 출력";
    }
}
