package hello.servlet.basic.response;

import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //status - line
        resp.setStatus(HttpServletResponse.SC_OK);
        //response-header
        resp.setHeader("Content-Type", "text/plain;charset=utf-8");//charset을 넣어줘야 한글이 안깨짐
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//캐시를 완전히 무효화
        resp.setHeader("Progma", "no-cache");
        resp.setHeader("my-header", "hello");

        PrintWriter writer = resp.getWriter();
        writer.println("잘되나요??");

        content(resp);
        cookie(resp);
        redirect(resp);
    }

    //헤더의 편의 메서드
    private void content(HttpServletResponse resp){
        resp.setContentType("text/plain;");
        resp.setCharacterEncoding("utf-8");//이렇게 charset이 설정가능
        //resp.setContentLength(16); //바디 데이터의 길이 설정 . 생략시 자동생성
    }

    private void cookie(HttpServletResponse resp){
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초동안 유효
        resp.addCookie(cookie); //쿠키 집어넣기
    }
    private void redirect(HttpServletResponse resp) throws IOException {
        //status : 302
        //lacation : /basic/hello-form.html

        //resp.setStatus(HttpServletResponse.SC_FOUND);
        //resp.setHeader("Location", "/basic/hello-form.html");
        //다음 한줄로 같은 효과
        resp.sendRedirect("/basic/hello-form.html");

    }
}
