package com.koreait.app.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.app.biz.common.JDBCUtil;

@Repository
public class BoardDAO {
	private final String SELECTALL = "SELECT B_NUM, TITLE, WRITER, CONTENT FROM BOARD";
	private final String SELECTONE = "SELECT B_NUM, TITLE, WRITER, CONTENT FROM BOARD WHERE B_NUM = ?";
	
	private final String INSERT = "INSERT INTO BOARD(TITLE, WRITER, CONTENT) VALUES(?, ?, ?)";
	private final String UPDATE = "UPDATE BOARD SET TITLE = ?, WRITER = ?, CONTENT = ? WHERE B_NUM = ?";
	private final String DELETE = "DELETE FROM BOARD WHERE B_NUM = ?";
	
	
	public List<BoardDTO> selectAll(BoardDTO boardDTO){
		System.out.println("		log : BoardDAO.selectAll()		시작");
		List<BoardDTO> datas = new ArrayList<BoardDTO>();
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SELECTALL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO data = new BoardDTO();
				data.setbNum(rs.getInt("B_NUM"));
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
				data.setContent(rs.getString("CONTENT"));
			}
			System.out.println("		log : log : BoardDAO.selectAll()		datas : ["+ datas +"]");
		} catch (SQLException e) {
			System.out.println("		log : BoardDAO.selectAll()		SQLException fail");
			e.printStackTrace();
			datas.clear();//잔여데이터 삭제
		} finally {
			//연결해제
			if(!JDBCUtil.disconnect(pstmt, conn)) {
				//연결해제 실패
				System.out.println("		log : BoardDAO.selectAll()		disconnect fail");
				datas.clear();//잔여데이터 삭제
			}
			System.out.println("		log : BoardDAO.selectAll()		종료");
		}
		
		System.out.println("		log : BoardDAO.selectAll()		종료");
		return datas;
	}
	public BoardDTO selectOne(BoardDTO boardDTO) {
		System.out.println("		log : BoardDAO.selectOne()		시작");
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		BoardDTO data = null;
		
		try {
			pstmt = conn.prepareStatement(SELECTONE);
			
			// 조건 값 넣기
			System.out.println("		log : BoardDAO.selectOne()		getbNum : ["+boardDTO.getbNum()+"]");
			pstmt.setInt(1, boardDTO.getbNum());	// 게시글 번호
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				data = new BoardDTO();
				data.setbNum(rs.getInt("B_NUM"));
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
				data.setContent(rs.getString("CONTENT"));
				
				System.out.println("		log : BoardDAO.selectOne()		data : ["+ data +"]");
			}
		} catch (SQLException e) {
			System.out.println("		log : BoardDAO.selectOne()		SQLException fail");
			e.printStackTrace();
			return null;
		} finally {
			//연결해제
			if(!JDBCUtil.disconnect(pstmt, conn)) {
				//연결해제 실패
				System.out.println("		log : BoardDAO.selectOne()		disconnect fail");
				return null;
			}
			System.out.println("		log : BoardDAO.selectOne()		종료");
		}
		
		System.out.println("		log : BoardDAO.selectOne()		종료");
		return data;
	}
	
	public boolean insert(BoardDTO boardDTO) {
		System.out.println("		log : BoardDAO.insert()		시작");
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(INSERT);
			
			// 조건 값 넣기
			System.out.println("		log : BoardDAO.insert()		getTitle : ["+boardDTO.getTitle()+"]");
			System.out.println("		log : BoardDAO.insert()		getWriter : ["+boardDTO.getWriter()+"]");
			System.out.println("		log : BoardDAO.insert()		getContent : ["+boardDTO.getContent()+"]");
			pstmt.setString(1, boardDTO.getTitle());	// 제목
			pstmt.setString(2, boardDTO.getWriter());	// 작성자
			pstmt.setString(3, boardDTO.getContent());	// 내용

			if(pstmt.executeUpdate() <= 0) {
				System.out.println("		log : BoardDAO.insert()		execute fail");
				return false;
			}
		} catch (SQLException e) {
			System.out.println("		log : BoardDAO.insert()		SQLException fail");
			e.printStackTrace();
			return false;
		} finally {
			//연결해제
			if(!JDBCUtil.disconnect(pstmt, conn)) {
				//연결해제 실패
				System.out.println("		log : BoardDAO.insert()		disconnect fail");
				return false;
			}
			System.out.println("		log : BoardDAO.insert()		종료");
		}
		
		System.out.println("		log : BoardDAO.insert()		종료");
		return true;
	}
	public boolean update(BoardDTO boardDTO) {
		System.out.println("		log : BoardDAO.update()		시작");
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(INSERT);
			
			// 조건 값 넣기
			System.out.println("		log : BoardDAO.update()		getTitle : ["+boardDTO.getTitle()+"]");
			System.out.println("		log : BoardDAO.update()		getWriter : ["+boardDTO.getWriter()+"]");
			System.out.println("		log : BoardDAO.update()		getContent : ["+boardDTO.getContent()+"]");
			System.out.println("		log : BoardDAO.update()		getbNum : ["+boardDTO.getbNum()+"]");
			pstmt.setString(1, boardDTO.getTitle());	// 제목
			pstmt.setString(2, boardDTO.getWriter());	// 작성자
			pstmt.setString(3, boardDTO.getContent());	// 내용
			pstmt.setInt(4, boardDTO.getbNum());	// 게시글 번호

			if(pstmt.executeUpdate() <= 0) {
				System.out.println("		log : BoardDAO.update()		execute fail");
				return false;
			}
		} catch (SQLException e) {
			System.out.println("		log : BoardDAO.update()		SQLException fail");
			e.printStackTrace();
			return false;
		} finally {
			//연결해제
			if(!JDBCUtil.disconnect(pstmt, conn)) {
				//연결해제 실패
				System.out.println("		log : BoardDAO.update()		disconnect fail");
				return false;
			}
			System.out.println("		log : BoardDAO.update()		종료");
		}
		
		System.out.println("		log : BoardDAO.update()		종료");
		return true;
	}
	public boolean delete(BoardDTO boardDTO) {
		System.out.println("		log : BoardDAO.delete()		시작");
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(DELETE);
			
			// 조건 값 넣기
			System.out.println("		log : BoardDAO.delete()		getbNum() : ["+boardDTO.getbNum()+"]");
			pstmt.setInt(1, boardDTO.getbNum());	// 게시글 번호

			if(pstmt.executeUpdate() <= 0) {
				System.out.println("		log : BoardDAO.delete()		execute fail");
				return false;
			}
		} catch (SQLException e) {
			System.out.println("		log : BoardDAO.delete()		SQLException fail");
			e.printStackTrace();
			return false;
		} finally {
			//연결해제
			if(!JDBCUtil.disconnect(pstmt, conn)) {
				//연결해제 실패
				System.out.println("		log : BoardDAO.delete()		disconnect fail");
				return false;
			}
			System.out.println("		log : BoardDAO.delete()		종료");
		}
		
		System.out.println("		log : BoardDAO.delete()		종료");
		return true;
	}
}