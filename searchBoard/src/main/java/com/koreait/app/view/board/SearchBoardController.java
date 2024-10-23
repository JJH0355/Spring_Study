package com.koreait.app.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.app.biz.board.BoardDTO;
import com.koreait.app.biz.board.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SearchBoardController {
	@Autowired
	private BoardService boardService;
	
	// 게시글 검색
	@RequestMapping("/searchBoard.do")
	public @ResponseBody List<BoardDTO> searchBoard(@RequestBody BoardDTO boardDTO) {
		System.out.println("	log : BoardController.searchBoard()		시작");

		// 비동기처리로 들어오 DTO 확인
		System.out.println("	log : BoardController.searchBoard()		boardDTO : [" + boardDTO + "]");

		// DAO로 selectAll 하기
		// 검색 결과를 List<boardDTO> datas로 받기
		List<BoardDTO> datas = boardService.selectAll(boardDTO);
		System.out.println("	log : BoardController.searchBoard()		datas : [" + datas + "]");

		return datas;
	}
}
