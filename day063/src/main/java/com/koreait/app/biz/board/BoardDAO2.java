package com.koreait.app.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


public class BoardDAO2 {
	// SELECTALL에서 가장 기본이 되는 쿼리문
	private final String SELECTALL = "SELECT B_NUM, TITLE, WRITER, CONTENT FROM BOARD WHERE 1=1";
	// 작성자 검색(일치할 때만 검색)
	private final String FILTER_WRITER = " AND WRITER = ?";
	private final String FILTER_CONTENT = " AND CONTENT LIKE CONCAT('%', ?, '%')";

	// SELECTONE 쿼리문
	private final String SELECTONE = "SELECT B_NUM, TITLE, WRITER, CONTENT FROM BOARD WHERE B_NUM = ?";

	// 정렬 쿼리문
	private final String NUM_ORDER_BY = " ORDER BY B_NUM";

	private final String INSERT = "INSERT INTO BOARD(TITLE, WRITER, CONTENT) VALUES(?, ?, ?)";
	private final String UPDATE = "UPDATE BOARD SET TITLE = ?, WRITER = ?, CONTENT = ? WHERE B_NUM = ?";
	private final String DELETE = "DELETE FROM BOARD WHERE B_NUM = ?";

	// JDBC 템플릿이 대신함
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<BoardDTO> selectAll(BoardDTO boardDTO) {
		// 쿼리문 합치기 용 변수
		String query = null;
		
		// 조건값을 담을 변수
		List<Object> queryValue = new ArrayList<Object>();

		// 전체 검색
		// 가장 기본이 되는 쿼리문 입력
		// 나중에 출력되는 조건이 변경될 시 if문을 통해 시작 값을 변경함
		query = SELECTALL;

		// 작가 검색
		// boardDTO에 카테고리 값이 존재하고, searchCate가 WRITER이라면
		if (boardDTO.getSearchCate() != null && boardDTO.getSearchCate().equals("WRITER")) {
			System.out.println("		log : BoardDAO.selectAll()		작성자 검색");
			// 작가 검색 조건 입력
			query = query+FILTER_WRITER;
			queryValue.add(boardDTO.getSearchKeyword());
		}

		// 내용 검색
		// boardDTO에 카테고리 값이 존재하고, searchCate가 CONTENT이라면
		else if (boardDTO.getSearchCate() != null && boardDTO.getSearchCate().equals("CONTENT")) {
			System.out.println("		log : BoardDAO.selectAll()		내용 검색");
			query = query+ FILTER_CONTENT;
			queryValue.add(boardDTO.getSearchKeyword());	
		}

		// ORDER BY 쿼리문 추가
		query = query + NUM_ORDER_BY;

		return jdbcTemplate.query(query, queryValue.toArray(), new BoardRowMapper());
	}

	public BoardDTO selectOne(BoardDTO boardDTO) {
		Object[] args = { boardDTO.getb_Num() };
		return jdbcTemplate.queryForObject(SELECTONE, args, new BoardRowMapper());
	}

	public boolean insert(BoardDTO boardDTO) {		
		int result = jdbcTemplate.update(INSERT, boardDTO.getTitle(), boardDTO.getWriter(), boardDTO.getContent());
		if (result <= 0) {
			return false;
		}
		return true;
	}

	public boolean update(BoardDTO boardDTO) {
		int result = jdbcTemplate.update(UPDATE, boardDTO.getTitle(), boardDTO.getWriter(), boardDTO.getContent(), boardDTO.getb_Num());
		if (result <= 0) {
			return false;
		}
		return true;
	}

	public boolean delete(BoardDTO boardDTO) {
		int result = jdbcTemplate.update(DELETE, boardDTO.getb_Num());
		if (result <= 0) {
			return false;
		}
		return true;
	}

	class BoardRowMapper implements RowMapper<BoardDTO> {

		@Override
		public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardDTO data = new BoardDTO();
			data.setb_Num(rs.getInt("B_NUM"));
			data.setTitle(rs.getString("TITLE"));
			data.setContent(rs.getString("CONTENT"));
			data.setWriter(rs.getString("WRITER"));
			return data;
		}
	}
}