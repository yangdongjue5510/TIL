package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //전체 파라미터 조회
        req.getParameterNames().asIterator().forEachRemaining(paraName -> System.out.println(paraName + "=" + req.getParameter(paraName)));
        System.out.println();

        //단일 파라미터 조회
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("age = " + age+ "username = "+username);
        System.out.println();

        //이름이 같은 복수 파라미터 (username = 양동주 & username = 홍길동)
        String[] usernames = req.getParameterValues("username");
        for(String username1 : usernames){
            System.out.println("username = " + username1);
        }

        resp.getWriter().write("ok");
    }
}
