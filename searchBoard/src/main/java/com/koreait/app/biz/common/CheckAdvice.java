package com.koreait.app.biz.common;

import jakarta.servlet.http.HttpSession;

public class CheckAdvice {

	public void checkLogin(HttpSession session) {
		System.out.println("chekLogin 코드 시작함");
		
		if(session.getAttribute("userID") != null) {
			System.out.println("로그아웃 상태입니다.");
		}
		else {
			System.out.println("로그인 상태입니다.");			
		}
	}
	
//	public void check(Object returnObj) {
//		// 반환값이 회원일 때 
//		if(returnObj instanceof MemberDTO) {
//			// 권한이 회원일 때
//			if(memberDTO.getRole().equals())
//		}
//	}
}
