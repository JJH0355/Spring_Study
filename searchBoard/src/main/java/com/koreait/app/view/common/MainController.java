package com.koreait.app.view.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.app.biz.board.BoardDTO;
import com.koreait.app.biz.board.BoardService;

@Controller
public class MainController {
	@Autowired
	private BoardService boardService;
	
	// 게시글 목록 보기
		@RequestMapping(value="/main.do", method=RequestMethod.GET)
		public String boardList(BoardDTO boardDTO, Model model) throws Exception {
			
			List<BoardDTO> datas = boardService.selectAll(boardDTO);
			model.addAttribute("datas", datas);
			return "main";
		}
}