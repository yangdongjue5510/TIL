import db.BoardDAO;
import db.BoardVO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertBoardServlet", value = "/insertBoard.do"
        )//로컬 파라미터 등록!
public class InsertBoardServlet extends HttpServlet {
    private String boardEncoding;

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        //init은 서블릿 엔진이 서블릿config를 생성하고 파라미터를 세팅한다. 그다음 init실행
//        //Servlet Config를 이용하면 로컬 파라미터 정보를 추출할 수 있다!!
//        boardEncoding = config.getInitParameter("encoding");
//    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
