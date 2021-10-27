package com.fastcpus.biz.board;

import com.fastcpus.biz.board.common.JDBCUtil;

import java.sql.*;

public class DeleteBoardClient {
    public static void main(String[] args) {
//        //JDBC 관련 변수 선언
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        try{
//            //JDBC 1단계 : 드라이버 로딩
//            conn = JDBCUtil.getConnection();
//            //JDBC 4단계 : SQL 전송 (승객전송) 동적일땐 먼저 쿼리문 선언해줘야.
//            String sql = "delete from board " +
//                         "where title = ?;";
//            //JDBC 3단계 : Statement 생성 (고속버스)
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, DynamicInsertBoardClient.scanner.nextLine());
//            int count = stmt.executeUpdate();
//            System.out.println(count+"건 처리됐습니다.");
//        } catch(SQLException e){
//            e.printStackTrace();
//        } finally {
//            //JDBC 5단계 : Connection 종료
//            JDBCUtil.close(stmt, conn);
//        }
        BoardDAO boardDAO = new BoardDAO();
        BoardVO vo = new BoardVO();
        vo.setSeq(7);
        boardDAO.deleteBoard(vo);
        boardDAO.getBoardList(vo);
    }
}
