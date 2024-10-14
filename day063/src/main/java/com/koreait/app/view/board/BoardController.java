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
	
	// 가게 검색
	@RequestMapping("/searchBoard.do")
	public String searchBoard(HttpServletRequest request, BoardDTO boardDTO, Model model) {
		System.out.println("	log : BoardController.searchBoard()		시작");
		
		// 프론트에서 받은 파라미터 값 DTO에 넣음
		// 검색 카테고리, 검색 키워드 값
		System.out.println(request.getParameter("searchCate"));
		boardDTO.setSearchCate(request.getParameter("searchCate"));
		boardDTO.setSearchKeyword(request.getParameter("searchKeyword"));
		System.out.println("	log : BoardController.searchBoard()		boardDTO : ["+boardDTO+"]");

		// 이동할 경로
		String path = "main";
		
		// DAO로 selectAll 하기
		// 검색 결과를 List<boardDTO> datas로 받기 
		List<BoardDTO> datas = boardService.selectAll(boardDTO);
		System.out.println("	log : BoardController.searchBoard()		datas : ["+datas+"]");
		
		// Model 객체 안에 datas 값 넣기
		model.addAttribute("datas", datas);
		model.addAttribute("searchCate", boardDTO.getSearchCate());
		model.addAttribute("searchKeyword", boardDTO.getSearchKeyword());
		
		return path;
	}

}
