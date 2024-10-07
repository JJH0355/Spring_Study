package com.koreait.app.view.member;

import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.app.biz.member.MemberDAO;
import com.koreait.app.biz.member.MemberDTO;
import com.koreait.app.view.controller.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController implements Controller{
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 1. 사용자(클라이언트, 브라우저)가 보낸 파라미터에서 값 추출
		String mid = request.getParameter("mid");
		String password = request.getParameter("password");
		
		// 2. DB 연동
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMid(mid);
		memberDTO.setPassword(password);
		memberDTO = memberDAO.selectOne(memberDTO);
		
		// 3. 페이지 이동 == 네비게이션
		// viewReslover가 .jsp를 알아서 붙여주므로 .jsp는 필요없음
		String path = "login";
		
		// 로그인이 성공했다면
		if(memberDTO != null) {
			path = "main.do";
		}
		return null;
		
		// 페이지로 바로 이동할 때는 .jsp는 생략
		// 다른 action으로 이동할 때는 .do가 붙음 (FC를 찾아가야하기 때문에)
	}

}
