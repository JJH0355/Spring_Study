package com.koreait.app.view.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.app.biz.board.BoardDAO;
import com.koreait.app.biz.board.BoardDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertBoardController implements Controller{
	// DAO 가져옴
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("	log : InsertBoardController.java	시작");
		// 사용자가 보낸 파라미터 값 추출
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// DB 연동
		// insert할 값들 setting
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle(title);
		boardDTO.setWriter(writer);
		boardDTO.setContent(content);

		// insert한 결과를 가져옴
		boolean flag = boardDAO.insert(boardDTO);
		System.out.println("	log : InsertBoardController.java	DAO.insert 실행");
		System.out.println("	log : InsertBoardController.java	flag : ["+ flag+"]");

		// 페이지 이동
		ModelAndView mav = new ModelAndView();
		mav.setViewName("insertBoard");
		
		// 만약 insert에 성공했다면
		if(flag){
		  mav.setViewName("viewBoard.do");
		}
		
		System.out.println("	log : InsertBoardController.java	path : ["+ mav.getViewName() +"]");
		System.out.println("	log : InsertBoardController.java	종료");
		return mav;
	}

}
