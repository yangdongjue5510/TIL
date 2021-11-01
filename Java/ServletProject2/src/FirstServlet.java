import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/first.do")
public class FirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request 객체를 통해 데이터 공유하기
        request.setAttribute("userName", "양동주");
        //포워딩 (url이 안바뀐다)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/second.do");
        dispatcher.forward(request, response);
        //리다이렉트
        //response.sendRedirect("second.do");
    }
}
