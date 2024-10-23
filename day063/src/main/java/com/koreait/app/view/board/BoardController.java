package com.koreait.app.view.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.app.biz.board.BoardDTO;
import com.koreait.app.biz.board.BoardService;
import com.koreait.app.biz.image.ImageDTO;
import com.koreait.app.biz.image.ImageService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	// DAO 가져옴
	@Autowired
	private BoardService boardService;
	@Autowired
	private ImageService imageService;

	// 게시글 등록 페이지
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public String insertBoard(HttpSession session) {
		// 이동 페이지
		String path = "insertBoard";

		// 로그인 상태가 아니라면
		if (session.getAttribute("userID") == null) {
			path = "login";
		}

		return path;
	}

	// 게시글 등록
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(HttpServletRequest request, HttpSession session, BoardDTO boardDTO) throws Exception {
		System.out.println("	log : BoardController.InsertBoard()		시작");
		// 사용자가 보낸 파라미터 값 추출
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// session에서 작성자명 userId 값 가져오기
		String writer = (String) session.getAttribute("userID");

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
		System.out.println("	log : BoardController.InsertBoard()		flag : [" + flag + "]");

		// 페이지 이동
		path = "insertBoard";

		// 만약 insert에 성공했다면
		if (flag) {
			System.out.println("	log : BoardController.InsertBoard()		insert 성공");
			path = "redirect:main.do";

		}

		System.out.println("	log : BoardController.InsertBoard()		종료");
		return path;
	}

	// 게시글 상세 보기
	@RequestMapping("/viewBoard.do")
	public String viewBoard(Model model, BoardDTO boardDTO, ImageDTO imageDTO) throws Exception {
		System.out.println("	log : BoardController.viewBoard()		시작");
		System.out.println("	log : BoardController.viewBoard()		boardDTO : [" + boardDTO + "]");
		System.out.println("	log : BoardController.viewBoard()		시작");
		System.out.println("	log : BoardController.viewBoard()		imageDTO : [" + imageDTO + "]");

		// selecOne 실행
		boardDTO = boardService.selectOne(boardDTO);
		System.out.println("boardService는 완료");
		imageDTO = imageService.selectOne(imageDTO);
		System.out.println("imageService는 완료");

		// model에 값 넣기
		model.addAttribute("data", boardDTO);

		// 만약 imageDTO가 null이 아니라면
		if (imageDTO != null) {
			model.addAttribute("path", imageDTO.getPath());
		}

		// 내용은 생략
		return "viewBoard";
	}

	// 게시글 검색
	@RequestMapping("/searchBoard.do")
	public String searchBoard(HttpServletRequest request, BoardDTO boardDTO, Model model) {
		System.out.println("	log : BoardController.searchBoard()		시작");

		// 프론트에서 받은 파라미터 값 DTO에 넣음
		// 검색 카테고리, 검색 키워드 값
		System.out.println(request.getParameter("searchCate"));
		boardDTO.setSearchCate(request.getParameter("searchCate"));
		boardDTO.setSearchKeyword(request.getParameter("searchKeyword"));
		System.out.println("	log : BoardController.searchBoard()		boardDTO : [" + boardDTO + "]");

		// 이동할 경로
		String path = "main";

		// DAO로 selectAll 하기
		// 검색 결과를 List<boardDTO> datas로 받기
		List<BoardDTO> datas = boardService.selectAll(boardDTO);
		System.out.println("	log : BoardController.searchBoard()		datas : [" + datas + "]");

		// Model 객체 안에 datas 값 넣기
		model.addAttribute("datas", datas);
		model.addAttribute("searchCate", boardDTO.getSearchCate());
		model.addAttribute("searchKeyword", boardDTO.getSearchKeyword());

		return path;
	}

	@RequestMapping(value = "/updateBoard.do")
	public String imageUpload(ImageDTO imageDTO) throws IllegalStateException, IOException {
		System.out.println("	log : BoardController.imageUpload()		시작");
		System.out.println("	log : BoardController.imageUpload()		imageDTO : [" + imageDTO + "]");

		// DTO에서 사진을 꺼내옴
		MultipartFile file = imageDTO.getFile();
		// 꺼내온 파일 이름 확인
		String fileName = file.getOriginalFilename();
		System.out.println("사진 이름 : [" + fileName + "]");
		
		String path = "redirect:main.do";

		// 경로를 추가하여 서버 공간에 사진 파일 추가
		file.transferTo(
				new File("C:\\Users\\11wog\\Desktop\\S\\java_study\\workspace03\\day063\\src\\main\\webapp\\images\\"
						+ fileName));

		// 파일이 존재하는지 확인
		// selectOne으로 해당 게시물에 사진이 존재하는지 확인
		imageDTO = imageService.selectOne(imageDTO);
		
		// 만약 데이터가 존재한다면
		if (imageDTO != null) {
			System.out.println("데이터가 존재함");
			// DTO에 파일 이름 추가
			imageDTO.setPath(fileName);
			// update로 path 변경
			imageService.update(imageDTO);
		} else {
			System.out.println("데이터가 존재하지 않음");
			// DTO에 파일 이름 추가
			imageDTO.setPath(fileName);
			// update로 path 변경
			imageService.insert(imageDTO);
		}

		return path;
	}

}
