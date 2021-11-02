import db.UsersDAO;
import db.UsersVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet is okay.");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        System.out.println("id : "+ id);
        System.out.println("pw : "+ password);

        UsersVO vo = new UsersVO();
        vo.setId(id);
        vo.setPassword(password);

        UsersDAO usersDAO = new UsersDAO();
        UsersVO user = usersDAO.getUser(vo);

        //화면 네비게이션
        if(user!= null) {
            request.setAttribute("userName", user.getName());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/board.do/list");
            requestDispatcher.forward(request, response);
        }else{
            ServletUtil.forward(request,response,"/login.html");
            //response.sendRedirect("login.html");
        }

//        response.setContentType("text/html;charset=EUC-KR");
//        PrintWriter out = response.getWriter();
//        if(user !=null){
//            out.println("<h1>로그인 성공<h1>");
//        } else{
//            out.println("<h1>로그인 실패<h1>");
//        }
//        out.close();
    }
}
