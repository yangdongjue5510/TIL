package com.fastcpus.biz.board;

import com.fastcpus.biz.board.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class GetBoardClient {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
//        try{
//            conn = JDBCUtil.getConnection();
//
//            String sql = "select * from board where title = ?";
//
//
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, "updatedTitle");
//            rs = stmt.executeQuery();
//
//            //출력
//            while(rs.next()) {//커서 이동(첫줄은 데이터가 없는 헤더) 읽을 데이터가 있으면 true 없으면 false
//                System.out.print(rs.getInt("SEQ") + " : ");
//                System.out.print(rs.getString("TITLE") + " : ");
//                System.out.print(rs.getString("WRITER") + " : ");
//                System.out.print(rs.getString("CONTENT") + " : ");
//                System.out.print(rs.getDate("REQDATE") + " : ");
//                System.out.println(rs.getInt("CNT"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            JDBCUtil.close(rs, stmt, conn);
//        }
        BoardDAO boardDAO = new BoardDAO();
        BoardVO vo = new BoardVO();
        vo.setSeq(7);
        boardDAO.getBoard(vo);
        List<BoardVO> boardVOList = boardDAO.getBoardList(vo);
    }
}
