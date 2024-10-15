package com.koreait.app.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.app.biz.board.BoardDTO;
import com.koreait.app.biz.board.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController{
	// DAO 가져옴
	@Autowired
	private BoardService boardService;

	// 가게 등록 페이지
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoard() {
		return "insertBoard";
	}

	// 가게 등록
	@RequestMapping(value="/insertBoard.do", method =RequestMethod.POST)
	public String insertBoard(HttpServletRequest request, BoardDTO boardDTO) throws Exception {
		System.out.println("	log : BoardController.InsertBoard()		시작");
		// 사용자가 보낸 파라미터 값 추출
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// 페이지 이동 반환 변수
		String path;

		// DB 연동
		// insert할 값들 setting
		boardDTO.setTitle(title);
		boardDTO.setWriter(writer);
		boardDTO.setContent(content);

		// insert한 결과를 가져옴
		boolean flag = boardService.insert(boardDTO);
		System.out.println("	log : BoardController.InsertBoard()		DAO.insert 실행");
		System.out.println("	log : BoardController.InsertBoard()		flag : ["+ flag+"]");

		// 페이지 이동
		path = "insertBoard";

		// 만약 insert에 성공했다면
		if(flag){
			System.out.println("	log : BoardController.InsertBoard()		insert 성공");
			path = "redirect:viewBoard.do";
		}

		System.out.println("	log : BoardController.InsertBoard()		종료");
		return path;
	}

	// 가게 상세 보기
	@RequestMapping("/viewBoard.do")
	public String viewBoard(Model model) throws Exception {
		// 내용은 생략
		return "viewBoard";
	}

}
