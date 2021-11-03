import db.BoardDAO;
import db.BoardVO;
import jdk.jfr.DataAmount;
import lombok.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "BoardListServlet", value = "/board.do/list")
public class BoardListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchCondition = request.getParameter("searchCondition");
        String searchKeyword = request.getParameter("searchKeyword");
        BoardVO vo = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> boardVOList = boardDAO.getBoardList(vo);

        response.setContentType("text/html;charset=EUC-KR");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>");
        out.println("<title>글 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
        out.println("<h1>게시 글 목록</h1>");
        out.println("<h3>"+request.getAttribute("userName")+"님 로그인 환영합니다...<a href='logout_proc.jsp'>LOG-OUT</a></h3>");
        out.println("<!-- 검색 시작 -->");
        out.println("<form action='getBoardList.do' method='post'>");
        out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
        out.println("<tr>");
        out.println("<td align='right'>");
        out.println("<select name='searchCondition'>");
        out.println("<option value='TITLE'>제목</option>");
        out.println("<option value='CONTENT'>내용</option>");
        out.println("</select>");
        out.println("<input name='searchKeyword' type='text'/>");
        out.println("<input type='submit' value='검색'/>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("<!-- 검색 종료 -->");
        out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
        out.println("<tr>");
        out.println("<th bgcolor='orange' width='100'>번호</th>");
        out.println("<th bgcolor='orange' width='200'>제목</th>");
        out.println("<th bgcolor='orange' width='150'>작성자</th>");
        out.println("<th bgcolor='orange' width='150'>등록일</th>");
        out.println("<th bgcolor='orange' width='100'>조회수</th>");
        out.println("</tr>");

        for(BoardVO board : boardVOList) {
            out.println("<tr>");
            out.println("<td>" + board.getSeq() + "</td>");
            out.println("<td align='left'><a href='/ServletProject2_war_exploded/getBoard.do?seq="+board.getSeq()+"'>" + board.getTitle() + "</a></td>");
            out.println("<td>" + board.getWriter() + "</td>");
            out.println("<td>" + board.getRegDate() + "</td>");
            out.println("<td>" + board.getCnt() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<br>");
        out.println("<a href='/ServletProject2_war_exploded/insertBoard.html'>새글 등록</a>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
