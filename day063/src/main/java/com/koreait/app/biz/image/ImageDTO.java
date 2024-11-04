package com.koreait.app.biz.image;

import org.springframework.web.multipart.MultipartFile;

public class ImageDTO {
	private int imageId;
	private String path;
	private int b_Num;
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
	public int getb_Num() {
		return b_Num;
	}
	public void setb_Num(int bNum) {
		this.b_Num = bNum;
	}
	@Override
	public String toString() {
		return "ImageDTO [imageId=" + imageId + ", path=" + path + ", bNum=" + b_Num + ", file=" + file + "]";
	}
}
