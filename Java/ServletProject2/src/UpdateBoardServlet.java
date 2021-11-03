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

@WebServlet(name ="UpdateBoardServlet", value = "/updateBoard.do")
public class UpdateBoardServlet extends HttpServlet {
    private String boardEncoding;

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        //init은 서블릿 엔진이 서블릿config를 생성하고 파라미터를 세팅한다. 그다음 init실행
//        //Servlet Config를 이용하면 로컬 파라미터 정보를 추출할 수 있다!!
//        boardEncoding = config.getInitParameter("encoding");
//    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletContext context = getServletContext();
//        boardEncoding = context.getInitParameter("encoding");
//        String kr = "EUC-KR";
//        request.setCharacterEncoding("EUC-KR");
        String seq = request.getParameter("seq");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));
        vo.setTitle(title);
        vo.setContent(content);

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.updateBoard(vo);

        ServletUtil.forward(request, response, "board.do/list");
        //response.sendRedirect("board.do/list");
    }
}
