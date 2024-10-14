package com.koreait.app.view.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.koreait.app.biz.member.MemberDAO;
import com.koreait.app.biz.member.MemberDTO;
import com.koreait.app.biz.member.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController{
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value ="/login.do", method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session, MemberDTO memberDTO) throws Exception {
		System.out.println("	log : LoginController.java	시작");
		// 1. 사용자(클라이언트, 브라우저)가 보낸 파라미터에서 값 추출
		String mid = request.getParameter("mid");
		String password = request.getParameter("password");
		System.out.println("	log : LoginController.java	getParameter(\"mid\") : ["+mid+"]");
		System.out.println("	log : LoginController.java	getParameter(\"password\") : ["+password+"]");
		
		// 2. DB 연동
		memberDTO.setMid(mid);
		memberDTO.setPassword(password);
		System.out.println("	log : LoginController.java	meberDTO.set 완료");
		System.out.println("	log : LoginController.java	meberDTO : "+ memberDTO);
		
		memberDTO = memberService.selectOne(memberDTO);
		System.out.println("	log : LoginController.java	DAO.selectOne 실행");
		System.out.println("	log : LoginController.java	meberDTO : "+ memberDTO);
		
		String viewName="redirect:login.do";
		
		// 로그인이 성공했다면
		if(memberDTO != null) {
			System.out.println("	log : LoginController.java	로그인 성공");
			session.setAttribute("userID", memberDTO.getMid());
			viewName = "redirect:main.do";
		}
		
		System.out.println("	log : LoginController.java	종료");
		return viewName;
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("userName");
		return "redirect:login.jsp";
	}
}