package com.koreait.app.biz.board;

public class BoardDTO {
	private int b_Num;
	private String title;
	private String writer;
	private String content;
	
	private String searchCate;
	private String searchKeyword;
	
	
	public int getb_Num() {
		return b_Num;
	}
	public void setb_Num(int bNum) {
		this.b_Num = bNum;
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
	public String getSearchCate() {
		return searchCate;
	}
	public void setSearchCate(String searchCate) {
		this.searchCate = searchCate;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bNum=" + b_Num + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", searchCate=" + searchCate + ", searchKeyword=" + searchKeyword + "]";
	}
}