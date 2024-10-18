package com.koreait.app.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.app.biz.board.BoardDAO;
import com.koreait.app.biz.board.BoardDTO;
import com.koreait.app.biz.board.BoardService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController{
	// DAO 가져옴
	@Autowired
	private BoardService boardService;

	// 가게 등록 페이지
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoard(HttpSession session) {
		// 이동 페이지
		String path = "insertBoard";
		
		// 로그인 상태가 아니라면
		if(session.getAttribute("userID") == null) {
			path = "login";
		}
		
		return path;
	}

	// 가게 등록
	@RequestMapping(value="/insertBoard.do", method =RequestMethod.POST)
	public String insertBoard(HttpServletRequest request, HttpSession session, BoardDTO boardDTO) throws Exception {
		System.out.println("	log : BoardController.InsertBoard()		시작");
		// 사용자가 보낸 파라미터 값 추출
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// session에서 작성자명 userId 값 가져오기
		String writer = (String)session.getAttribute("userID");

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
			path = "redirect:main.do";
			
		}

		System.out.println("	log : BoardController.InsertBoard()		종료");
		return path;
	}

	// 가게 상세 보기
	@RequestMapping("/viewBoard.do")
	public String viewBoard(Model model, BoardDTO boardDTO) throws Exception {
		System.out.println("	log : BoardController.viewBoard()		시작");
		System.out.println("	log : BoardController.viewBoard()		boardDTO : ["+boardDTO+"]");
		
		// selecOne 실행
		boardDTO = boardService.selectOne(boardDTO);
		
		// model에 값 넣기
		model.addAttribute("data", boardDTO);
		
		// 내용은 생략
		return "viewBoard";
	}

}
