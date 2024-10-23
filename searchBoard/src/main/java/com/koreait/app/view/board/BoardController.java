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

import com.koreait.app.biz.board.BoardDAO;
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
	public String insertBoard(HttpServletRequest request, HttpSession session, BoardDTO boardDTO, ImageDTO imageDTO)
			throws Exception {
		System.out.println("	log : BoardController.InsertBoard()		시작");
		// 사용자가 보낸 파라미터 값 추출
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// session에서 작성자명 userId 값 가져오기
		String writer = (String) session.getAttribute("userID");

		// 이미지 값 가져오기
		MultipartFile file = imageDTO.getFile();
		// 꺼내온 파일 이름 확인
		String fileName = file.getOriginalFilename();
		System.out.println("사진 이름 : [" + fileName + "]");

		// 경로를 추가하여 서버 공간에 사진 파일 추가
		file.transferTo(new File(
				"C:\\Users\\11wog\\Desktop\\S\\java_study\\workspace03\\searchBoard\\src\\main\\webapp\\images\\"
						+ fileName));

		// 페이지 이동 반환 변수
		String path = "insertBoard";

		// DB 연동
		// insert할 값들 setting
		boardDTO.setTitle(title);
		boardDTO.setWriter(writer);
		boardDTO.setContent(content);

		// insert한 결과를 가져옴
		boolean flag = boardService.insert(boardDTO);
		System.out.println("	log : BoardController.InsertBoard()		DAO.insert 실행");
		System.out.println("	log : BoardController.InsertBoard()		flag : [" + flag + "]");

		// 만약 insert에 실패했다면
		if (!flag) {
			System.out.println("	log : BoardController.InsertBoard()		insert 실패");
			return path;
		}
		// bNum 가져오기
		boardDTO = boardService.selectOne(boardDTO);
		System.out.println("selectOne 완료 : " + boardDTO);

		// 이미지파일 insert
		// DTO에 파일 이름 추가
		imageDTO.setPath(fileName);
		// bNum 추가
		imageDTO.setbNum(boardDTO.getbNum());

		// update로 path 변경
		flag = imageService.insert(imageDTO);

		// 만약 insert에 실패했다면
		if (!flag) {
			System.out.println("	log : BoardController.InsertBoard()		insert 실패");
			return path;
		}

		path = "redirect:main.do";

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

	// 게시글 업데이트
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
		file.transferTo(new File(
				"C:\\Users\\11wog\\Desktop\\S\\java_study\\workspace03\\searchBoard\\src\\main\\webapp\\images\\"
						+ fileName));

		// DTO에 파일 이름 추가
		imageDTO.setPath(fileName);

		// 파일이 존재하는지 확인
		// selectOne으로 해당 게시물에 사진이 존재하는지 확인
		ImageDTO checkImageDTO = imageService.selectOne(imageDTO);

		// 만약 데이터가 존재한다면
		if (checkImageDTO != null) {
			System.out.println("데이터가 존재함");
			// checkImageDTO에서 imageId 가져오기
			imageDTO.setImageId(checkImageDTO.getImageId());
			
			// update로 path 변경
			imageService.update(imageDTO);
		} else {
			System.out.println("데이터가 존재하지 않음");
			// update로 path 변경
			imageService.insert(imageDTO);
		}

		return path;
	}

}
