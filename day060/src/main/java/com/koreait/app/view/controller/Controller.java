package com.koreait.app.view.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 기존의 Action
public interface Controller {
	// 경로를 반환하기 때문에 String 반환
	String excute(HttpServletRequest request, HttpServletResponse response);
}
// 메서드 오버라이딩 강제
// == 메서드 시그니쳐 강제