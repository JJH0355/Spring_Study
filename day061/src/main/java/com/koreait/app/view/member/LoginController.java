package com.koreait.app.view.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.app.biz.member.MemberDAO;
import com.koreait.app.biz.member.MemberDTO;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController implements Controller{
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("	log : LoginController.java	시작");
		// 1. 사용자(클라이언트, 브라우저)가 보낸 파라미터에서 값 추출
		String mid = request.getParameter("mid");
		String password = request.getParameter("password");
		System.out.println("	log : LoginController.java	getParameter(\"mid\") : ["+mid+"]");
		System.out.println("	log : LoginController.java	getParameter(\"password\") : ["+password+"]");
		
		// 2. DB 연동
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMid(mid);
		memberDTO.setPassword(password);
		System.out.println("	log : LoginController.java	meberDTO.set 완료");
		System.out.println("	log : LoginController.java	meberDTO : "+ memberDTO);
		
		memberDTO = memberDAO.selectOne(memberDTO);
		System.out.println("	log : LoginController.java	DAO.selectOne 실행");
		System.out.println("	log : LoginController.java	meberDTO : "+ memberDTO);
		
		// 3. 페이지 이동 == 네비게이션
		// viewReslover가 .jsp를 알아서 붙여주므로 .jsp는 필요없음
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		// == String path = "login";
		
		// 로그인이 성공했다면
		if(memberDTO != null) {
			System.out.println("	log : LoginController.java	로그인 성공");
			mav.addObject("userName", memberDTO.getName());
			mav.setViewName("main.do");
			// == path = "main.do";
		}
		System.out.println("	log : LoginController.java	path : ["+ mav +"]");
		System.out.println("	log : LoginController.java	종료");
		return mav;
		
		// 페이지로 바로 이동할 때는 .jsp는 생략
		// 다른 action으로 이동할 때는 .do가 붙음 (FC를 찾아가야하기 때문에)
	}
}