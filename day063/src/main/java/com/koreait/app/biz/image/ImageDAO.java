package com.koreait.app.biz.image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDAO {
	private final String SELECTALL = "";
	private final String SELECTONE = "SELECT IMAGEID, PATH, B_NUM FROM IMAGE WHERE B_NUM=?";
	
	private final String INSERT = "INSERT INTO IMAGE (PATH,B_NUM) VALUES(?,?)";
	private final String UPDATE = "UPDATE IMAGE SET PATH=? WHERE IMAGEID = ?";
	private final String DELETE = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<ImageDTO> selectAll(ImageDTO imageDTO){
		return null;
	}
	public ImageDTO selectOne(ImageDTO imageDTO){
		System.out.println("ImageDAO 들어옴");
		Object[] args = {imageDTO.getb_Num()};
		
		try {
			imageDTO = jdbcTemplate.queryForObject(SELECTONE, args, new ImageRowMapper());			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		System.out.println("imageDTO : ["+ imageDTO+"]");
		
		return imageDTO;
	}
	
	public boolean insert(ImageDTO imageDTO){
		int result = jdbcTemplate.update(INSERT, imageDTO.getPath(), imageDTO.getb_Num());
		if(result <= 0) {
			return false;
		}
		return true;
	}
	public boolean update(ImageDTO imageDTO){
		System.out.println("imageDTO : ["+ imageDTO+"]");
		
		int result = jdbcTemplate.update(UPDATE, imageDTO.getPath(), imageDTO.getImageId());
		if(result <= 0) {
			System.out.println("update 실패");
			return false;
		}
		System.out.println("update 성공");
		return true;
	}
	public boolean delete(ImageDTO imageDTO){
		return false;
	}
}

class ImageRowMapper implements RowMapper<ImageDTO>{

	@Override
	public ImageDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ImageDTO data = new ImageDTO();
		data.setImageId(rs.getInt("IMAGEID"));
		data.setPath(rs.getString("PATH"));
		data.setb_Num(rs.getInt("B_NUM"));
		return data;
	}
	
}
