package com.koreait.app.biz.image;

import org.springframework.web.multipart.MultipartFile;

public class ImageDTO {
	private int imageId;
	private String path;
	private int bNum;
	private MultipartFile file;
	
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	@Override
	public String toString() {
		return "ImageDTO [imageId=" + imageId + ", path=" + path + ", bNum=" + bNum + ", file=" + file + "]";
	}
}
