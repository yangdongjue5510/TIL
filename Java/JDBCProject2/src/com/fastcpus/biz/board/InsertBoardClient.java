package com.fastcpus.biz.board;

import com.fastcpus.biz.board.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBoardClient {
    public static void main(String[] args) {
//        //JDBC 관련 변수 선언
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            conn = JDBCUtil.getConnection();
//            //JDBC 3단계 : Statement 생성 (고속버스)
//            stmt = conn.createStatement();
//            //JDBC 4단계 : SQL 전송 (승객전송)
//            String sql = "insert into board(seq, title, writer, content) " +
//                    "values ((select nvl(max(seq), 0) +1 from board), "+
//                    "'title', 'writer', 'content')";
//
//            int count = stmt.executeUpdate(sql);
//            System.out.println(count+"건 처리됐습니다.");
//        } catch(SQLException e){
//            e.printStackTrace();
//        } finally {
//            //JDBC 5단계 : Connection 종료
//            JDBCUtil.close(stmt, conn);
//        }

        BoardDAO boardDAO = new BoardDAO();
        BoardVO vo = new BoardVO();
        vo.setContent("내용");
        vo.setTitle("제목");
        vo.setWriter("작가");
        boardDAO.insertBoard(vo);
        boardDAO.getBoardList(vo);
    }
}
