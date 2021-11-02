import db.BoardDAO;
import db.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertBoardServlet", value = "/insertBoard.do")
public class InsertBoardServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("EUC-KR");
        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");

        BoardVO vo = new BoardVO();
        vo.setTitle(title);
        vo.setWriter(writer);
        vo.setContent(content);
        if(title == "" || writer =="" || content == "") {
            response.sendRedirect("insertBoard.html");
            return;
        }
        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.insertBoard(vo);
        ServletUtil.forward(request, response, "/board.do/list");
        //response.sendRedirect("/ServletProject2_war_exploded/board.do/list");

    }
}
