package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV3handlerAdapter;
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV4handlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {
    private final Map<String, Object> hanlderMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> hanlderAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerMappingAdapter();
    }

    private void initHandlerMappingAdapter() {
        hanlderAdapters.add(new ControllerV3handlerAdapter());
        hanlderAdapters.add(new ControllerV4handlerAdapter());
    }

    private void initHandlerMappingMap() {
        // v3
        hanlderMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        hanlderMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        hanlderMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        // v4
        hanlderMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        hanlderMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        hanlderMappingMap .put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object hanlder = getHandler(req);

        if (hanlder == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(hanlder);

        ModelView mv = adapter.handle(req, resp, hanlder);

        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(), req, resp);
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + "/jsp");
    }

    private MyHandlerAdapter getHandlerAdapter(Object hanlder) {

        for (MyHandlerAdapter adapter : hanlderAdapters) {
            if (adapter.supports(hanlder));
                return adapter;
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다.\n");
    }

    private Object getHandler(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        return hanlderMappingMap.get(requestURI);
    }
}
