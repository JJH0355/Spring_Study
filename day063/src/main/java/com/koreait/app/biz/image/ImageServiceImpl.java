package com.koreait.app.biz.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ImageService")
public class ImageServiceImpl implements ImageService{
	@Autowired
	private ImageDAO imageDAO;
	
	@Override
	public List<ImageDTO> selectAll(ImageDTO imageDTO) {
		return this.imageDAO.selectAll(imageDTO);
	}

	@Override
	public ImageDTO selectOne(ImageDTO imageDTO) {
		System.out.println("imageService는 들어옴");
		return this.imageDAO.selectOne(imageDTO);
	}

	@Override
	public boolean insert(ImageDTO imageDTO) {
		return this.imageDAO.insert(imageDTO);
	}

	@Override
	public boolean update(ImageDTO imageDTO) {
		return this.imageDAO.update(imageDTO);
	}

	@Override
	public boolean delete(ImageDTO imageDTO) {
		// TODO Auto-generated method stub
		return this.imageDAO.delete(imageDTO);
	}

}
