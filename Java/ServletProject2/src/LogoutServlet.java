import com.sun.net.httpserver.HttpsServer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "LogoutServlet", value = "/logout.do")
public class LogoutServlet extends HttpServlet {
}
