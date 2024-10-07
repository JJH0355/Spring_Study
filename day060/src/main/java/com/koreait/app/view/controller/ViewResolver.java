package com.koreait.app.view.controller;

public class ViewResolver {
	// 의존 2개
	private String prefix;
	private String suffix;
	
	// setter을 통해 의존주입
	// DispatcherServlet에서 생성하면서 setter 주입을 한다.
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	// 현재 클래스 path의 접두어(./) 접미어(.jsp)를 붙여서 이동시킨다.
	public String getView(String path) {
		return this.prefix + path + this.suffix; 
	}

}
