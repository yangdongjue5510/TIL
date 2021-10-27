package com.fastcpus.biz.board;

import com.fastcpus.biz.board.common.JDBCUtil;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class DynamicInsertBoardClient {
//    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try{
//            conn = JDBCUtil.getConnection();
//            String sql = "insert into board(seq, title, writer, content) " +
//                    "values ((select nvl(max(seq), 0) +1 from board), "+
//                    "?, ?, ?)";
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, scanner.nextLine());
//            stmt.setString(2, scanner.nextLine());
//            stmt.setString(3, scanner.nextLine());
//            int count = stmt.executeUpdate();
//            System.out.println(count+"건 처리됐습니다.");
//        }catch(SQLException e){
//            e.printStackTrace();
//        } finally {
//            JDBCUtil.close(stmt, conn);
//        }

        BoardDAO boardDAO = new BoardDAO();
        BoardVO vo = new BoardVO();
        vo.setTitle("title");
        vo.setWriter("writer");
        vo.setContent("content");
        boardDAO.insertBoard(vo);
        List<BoardVO> boardVOList = boardDAO.getBoardList(vo);
    }
}
