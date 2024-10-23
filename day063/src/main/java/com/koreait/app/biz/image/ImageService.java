package com.koreait.app.biz.image;

import java.util.List;

public interface ImageService {
	public List<ImageDTO> selectAll(ImageDTO imageDTO);
	public ImageDTO selectOne(ImageDTO imageDTO);
	public boolean insert(ImageDTO imageDTO);
	public boolean update(ImageDTO imageDTO);
	public boolean delete(ImageDTO imageDTO);
}
