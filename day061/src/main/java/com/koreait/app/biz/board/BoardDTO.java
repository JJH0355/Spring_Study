package com.koreait.app.biz.board;

public class BoardDTO {
	private int bNum;
	private String title;
	private String writer;
	private String content;
	
	
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BoardDTO [bNum=" + bNum + ", title=" + title + ", writer=" + writer + ", content=" + content + "]";
	}
}