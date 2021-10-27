package com.fastcpus.biz.board;

import com.fastcpus.biz.board.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UpdateBoardClient {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
//        try{
//            conn = JDBCUtil.getConnection();
//
//            String sql = "UPDATE board SET title = ?, content = ? where seq = ?";
//
//            stmt = conn.prepareStatement(sql);
//
//            stmt.setString(1, "수정된 제목");
//            stmt.setString(2, "수정된 내용");
//            stmt.setInt(3, 3);
//            int count = stmt.executeUpdate();
//            System.out.println(count+"건 처리 되었습니다.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            JDBCUtil.close(stmt, conn);
//        }
        BoardDAO boardDAO = new BoardDAO();
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("title");
        boardVO.setContent("content");
        boardVO.setSeq(7);
        boardDAO.updateBoard(boardVO);
        boardDAO.getBoardList(boardVO);
    }
}
