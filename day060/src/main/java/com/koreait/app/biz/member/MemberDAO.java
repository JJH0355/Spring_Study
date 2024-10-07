package com.koreait.app.biz.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.koreait.app.biz.common.JDBCUtil;

@Repository
public class MemberDAO {
	private String SELECTALL = "SELECT * FROM MEMBER";
	private String SELECTONE = "SELECT * FROM MEMBER WHERE MID = ?";

	private final String INSERT = "INSERT INTO MEMBER(MID, PASSWORD, NAME, ROLE) VALUES(?, ?, ?, ?)";
	private final String UPDATE = "UPDATE MEMBER SET MID = ?, PASSWORD = ?, NAME = ?, ROLE = ? WHERE MID = ?";
	private final String DELETE = "DELETE FROM MEMBER WHERE MID = ?";


	public List<MemberDTO> selectAll(MemberDTO memberDTO) {
		ArrayList<MemberDTO> datas = new ArrayList<MemberDTO>();
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(SELECTALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) { 
				MemberDTO data = new MemberDTO();
				data.setMid(rs.getString("MID")); // MID
				data.setPassword(rs.getString("PASSWORD")); // 비밀번호
				data.setName(rs.getString("NAME")); // 이름
				data.setRole(rs.getString("ROLE")); // 권한
				//반환된 객체 리스트에 추가
				datas.add(data); 
			}
			rs.close();
			System.out.println("end");
		} catch (SQLException e) {
			System.err.println("log: Member selectAll SQLException fail");
			e.printStackTrace();
			datas.clear();//잔여데이터 삭제
		} catch (Exception e) {
			System.err.println("log: Member selectAll Exception fail");
			datas.clear();//잔여데이터 삭제
		} finally {
			//연결해제
			if(!JDBCUtil.disconnect(pstmt, conn)) {
				//연결해제 실패
				System.err.println("log: Member selectAll disconnect fail");
				datas.clear();//잔여데이터 삭제
			}
			System.out.println("log: Member selectAll end");
		}
		System.out.println("log: Member selectAll return datas");
		return datas;

	}

	public MemberDTO selectOne(MemberDTO memberDTO) {
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		MemberDTO data = null;
		try {
			pstmt = conn.prepareStatement(SELECTONE);
			pstmt.setString(1, memberDTO.getMid()); 	// mid
			//넘어온 값 확인 로그
			System.out.println("log: parameter getMid : "+memberDTO.getMid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { 
				data = new MemberDTO();
				data.setMid(rs.getString("MID")); // MID
				data.setPassword(rs.getString("PASSWORD")); // 비밀번호
				data.setName(rs.getString("NAME")); // 이름
				data.setRole(rs.getString("ROLE")); // 권한
				System.out.println("result exists");
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("log: Member selectOne SQLException fail");
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.err.println("log: Member selectOne Exception fail");
			return null;
		} finally {
			//연결해제
			if(!JDBCUtil.disconnect(pstmt, conn)) {
				//연결해제 실패
				System.err.println("log: Member selectOne disconnect fail");
				return null;
			}
			System.out.println("log: Member selectOne end");
		}
		System.out.println("log: Member selectOne return datas");
		return data;

	}

	public boolean insert(MemberDTO memberDTO) {
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, memberDTO.getMid());		// 아이디
			pstmt.setString(2, memberDTO.getPassword()); 	//비밀번호
			pstmt.setString(3, memberDTO.getName()); 		//이름
			pstmt.setString(4, memberDTO.getRole()); 	// 권한
			//넘어온 값 확인 로그
			System.out.println("log: MemberDAO.java getMid : "+memberDTO.getMid());
			System.out.println("log: MemberDAO.java getPassword : "+memberDTO.getPassword());
			System.out.println("log: MemberDAO.java getName : "+memberDTO.getName());
			System.out.println("log: MemberDAO.java getRole : "+memberDTO.getRole());

			if(pstmt.executeUpdate() <= 0) { 
				//쿼리는 정상적으로 실행됐으나 실패
				System.err.println("log: Member insert execute fail");
				return false;
			}
		} catch (SQLException e) {
			System.err.println("log: Member insert SQLException fail");
			return false;
		} catch (Exception e) {
			System.err.println("log: Member insert Exception fail");
			return false;
		} finally {
			//연결해제
			if(!JDBCUtil.disconnect(pstmt, conn)) {
				//연결해제 실패
				System.err.println("log: Member insert disconnect fail");
				return false;
			}
			System.out.println("log: Member insert end");
		}
		System.out.println("log: Member insert true");
		return true;

	}
	public boolean update(MemberDTO memberDTO) {
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		try {

			//개인정보수정(비밀번호 제외)
			System.out.println("log: Member update : UPDATE");
			pstmt.setString(1, memberDTO.getMid());		// 아이디
			pstmt.setString(2, memberDTO.getPassword()); 	//비밀번호
			pstmt.setString(3, memberDTO.getName()); 		//이름
			pstmt.setString(4, memberDTO.getRole()); 	// 권한
			//넘어온 값 확인 로그
			System.out.println("log: MemberDAO.java getMemberEmail : "+memberDTO.getMid());
			System.out.println("log: MemberDAO.java getMemberPassword : "+memberDTO.getPassword());
			System.out.println("log: MemberDAO.java getMemberName : "+memberDTO.getName());
			System.out.println("log: MemberDAO.java getMemberPhone : "+memberDTO.getRole());

			if(pstmt.executeUpdate() <= 0) { 
				//쿼리는 정상적으로 실행됐으나 실패
				System.err.println("log: Member update execute fail");
				return false;
			}
		} catch (SQLException e) {
			System.err.println("log: Member update SQLException fail");
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			System.err.println("log: Member update Exception fail");
			return false;
		} finally {
			//연결해제
			if(!JDBCUtil.disconnect(pstmt, conn)) {
				//연결해제 실패
				System.err.println("log: Member update disconnect fail");
				return false;
			}
			System.out.println("log: Member update end");
		}
		System.out.println("log: Member update true");
		return true;

	}
	public boolean delete(MemberDTO memberDTO) {
		Connection conn = JDBCUtil.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setString(1, memberDTO.getMid()); //멤버 번호
			//넘어온 값 확인 로그
			System.out.println("log: parameter getMid : "+memberDTO.getMid());
			if(pstmt.executeUpdate() <= 0) { 
				//쿼리는 정상적으로 실행됐으나 실패
				System.err.println("log: Member delete execute fail");
				return false;
			}
		} catch (SQLException e) {
			System.err.println("log: Member delete SQLException fail");
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			System.err.println("log: Member delete Exception fail");
			return false;
		} finally {
			//연결해제
			if(!JDBCUtil.disconnect(pstmt, conn)) {
				//연결해제 실패
				System.err.println("log: Member delete disconnect fail");
				return false;
			}
			System.out.println("log: Member delete end");
		}
		System.out.println("log: Member delete true");
		return true;

	}
} 