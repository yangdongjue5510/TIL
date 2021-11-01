import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/second.do")
public class SecondServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=EUC-KR");
        PrintWriter out = response.getWriter();

        String userName = (String)request.getAttribute("userName");
        out.println("<h1> "+userName+" SecondServlet 실행 결과 화면.</h1>");
        out.close();
    }
}
