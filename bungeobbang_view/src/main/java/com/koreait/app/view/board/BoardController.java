package com.koreait.app.view.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.bungeobbang.app.biz.store.StoreDTO;
import com.bungeobbang.app.biz.store.StoreMenuDTO;
import com.bungeobbang.app.biz.store.StorePaymentDTO;
import com.bungeobbang.app.biz.store.StoreWorkDTO;
import com.koreait.app.biz.board.BoardDTO;
import com.koreait.app.biz.board.BoardService;
import com.koreait.app.biz.image.ImageDTO;
//import com.koreait.app.biz.image.ImageService;
import com.koreait.app.biz.product.ProductDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	// DAO 가져옴
	//@Autowired
	//private BoardService boardService;
//	@Autowired
//	private ImageService imageService;

	// 게시글 등록 페이지
//	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
//	public String insertBoard(HttpSession session) {
//		// 이동 페이지
//		String path = "insertBoard";
//
//		// 로그인 상태가 아니라면
//		if (session.getAttribute("userID") == null) {
//			path = "login";
//		}
//
//		return path;
//	}

	// 게시글 등록
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(HttpServletRequest request, HttpSession session, BoardDTO boardDTO, ImageDTO imageDTO)
			throws Exception {
//		System.out.println("	log : BoardController.InsertBoard()		시작");
//		// 사용자가 보낸 파라미터 값 추출
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//
//		// session에서 작성자명 userId 값 가져오기
//		String writer = (String) session.getAttribute("userID");
//
//		// 이미지 값 가져오기
//		MultipartFile file = imageDTO.getFile();
//		// 꺼내온 파일 이름 확인
//		String fileName = file.getOriginalFilename();
//		System.out.println("사진 이름 : [" + fileName + "]");
//
//		// 경로를 추가하여 서버 공간에 사진 파일 추가
//		file.transferTo(new File(
//				"C:\\Users\\11wog\\Desktop\\S\\java_study\\workspace03\\searchBoard\\src\\main\\webapp\\images\\"
//						+ fileName));
//
//		// 페이지 이동 반환 변수
		String path = "insertBoard";
//
//		// DB 연동
//		// insert할 값들 setting
//		boardDTO.setTitle(title);
//		boardDTO.setWriter(writer);
//		boardDTO.setContent(content);
//
//		// insert한 결과를 가져옴
//		boolean flag = boardService.insert(boardDTO);
//		System.out.println("	log : BoardController.InsertBoard()		DAO.insert 실행");
//		System.out.println("	log : BoardController.InsertBoard()		flag : [" + flag + "]");
//
//		// 만약 insert에 실패했다면
//		if (!flag) {
//			System.out.println("	log : BoardController.InsertBoard()		insert 실패");
//			return path;
//		}
//		// bNum 가져오기
//		boardDTO = boardService.selectOne(boardDTO);
//		System.out.println("selectOne 완료 : " + boardDTO);
//
//		// 이미지파일 insert
//		// DTO에 파일 이름 추가
//		imageDTO.setPath(fileName);
//		// bNum 추가
//		imageDTO.setbNum(boardDTO.getbNum());
//
//		// update로 path 변경
//		flag = imageService.insert(imageDTO);
//
//		// 만약 insert에 실패했다면
//		if (!flag) {
//			System.out.println("	log : BoardController.InsertBoard()		insert 실패");
//			return path;
//		}
//
		path = "redirect:main.do";
//
//		System.out.println("	log : BoardController.InsertBoard()		종료");
		return path;
	}

	// 게시글 상세 보기
	@RequestMapping("/viewBoard.do")
	public String viewBoard(Model model, BoardDTO boardDTO, ImageDTO imageDTO) throws Exception {
//		System.out.println("	log : BoardController.viewBoard()		시작");
//		System.out.println("	log : BoardController.viewBoard()		boardDTO : [" + boardDTO + "]");
//		System.out.println("	log : BoardController.viewBoard()		시작");
//		System.out.println("	log : BoardController.viewBoard()		imageDTO : [" + imageDTO + "]");
//
//		// selecOne 실행
//		boardDTO = boardService.selectOne(boardDTO);
//		System.out.println("boardService는 완료");
//		imageDTO = imageService.selectOne(imageDTO);
//		System.out.println("imageService는 완료");
//
//		// model에 값 넣기
//		model.addAttribute("data", boardDTO);
//
//		// 만약 imageDTO가 null이 아니라면
//		if (imageDTO != null) {
//			model.addAttribute("image", imageDTO);
//		}
//
//		// 내용은 생략
		return "viewBoard";
	}

	// 게시글 업데이트
//	@RequestMapping(value = "/updateBoard.do")
	public String imageUpload(ImageDTO imageDTO) throws IllegalStateException, IOException {
//		System.out.println("	log : BoardController.imageUpload()		시작");
//		System.out.println("	log : BoardController.imageUpload()		imageDTO : [" + imageDTO + "]");
//
//		// DTO에서 사진을 꺼내옴
//		MultipartFile file = imageDTO.getFile();
//		// 꺼내온 파일 이름 확인
//		String fileName = file.getOriginalFilename();
//		System.out.println("사진 이름 : [" + fileName + "]");
//
		String path = "redirect:main.do";
//
//		// 경로를 추가하여 서버 공간에 사진 파일 추가
//		file.transferTo(new File(
//				"C:\\Users\\11wog\\Desktop\\S\\java_study\\workspace03\\searchBoard\\src\\main\\webapp\\images\\"
//						+ fileName));
//
//		// DTO에 파일 이름 추가
//		imageDTO.setPath(fileName);
//
//		// 파일이 존재하는지 확인
//
//		// 만약 데이터가 존재한다면
//		if (imageDTO.getImageId() > 0) {
//			System.out.println("데이터가 존재함");		
//			// update로 실행
//			imageService.update(imageDTO);
//		} else {
//			System.out.println("데이터가 존재하지 않음");
//			// insert 실행
//			imageService.insert(imageDTO);
//		}
//
		return path;
	}

	// 확인용
	@RequestMapping(value = "/addStore.do", method = RequestMethod.POST)
	public void checkAddStoreData(HttpServletRequest request, StoreDTO storeDTO, StoreMenuDTO storeMenuDTO, StorePaymentDTO storePaymentDTO, StoreWorkDTO storeWorkDTO) {
		System.out.println("storeDTO : ["+storeDTO+"]");
		System.out.println("storeMenuDTO : ["+storeMenuDTO+"]");
		System.out.println("storePaymentDTO : ["+storePaymentDTO+"]");
		System.out.println("storeWorkDTO : ["+storeWorkDTO+"]");
		
		String[] workWeek = request.getParameterValues("workWeek");
		String[] workStartTime = request.getParameterValues("workStartTime");
		String[] workEndTime = request.getParameterValues("workEndTime");
		
		for(int i = 0; i < workWeek.length; i++) {			
			System.out.println("i : ["+i+"]");
			System.out.println("workWeek : ["+workWeek[i]+"]");
			System.out.println("workStartTime : ["+workStartTime[i]+"]");
			System.out.println("workEndTime : ["+workEndTime[i]+"]");
		}
	}
	
	@RequestMapping(value = "/infoStore.do")
	public String checkStoreData(Model model, StoreDTO storeDTO, StoreWorkDTO storeWorkDTO) {
		storeDTO.setStoreNum(1);
		storeDTO.setStoreName("갈빵 붕어빵");
		storeDTO.setStoreAddress("서울시 강남구 테헤란로26길 10");
		storeDTO.setStoreAddressDetail("13층");
		storeDTO.setStoreContact("010-0000-0000");
		storeDTO.setStoreClosed("N");
		storeDTO.setStoreSecret("Y");
		
		storeDTO.setStoreMenuNormal("Y");
		storeDTO.setStoreMenuVeg("N");
		storeDTO.setStoreMenuMini("N");
		storeDTO.setStoreMenuPotato("Y");
		storeDTO.setStoreMenuIce("N");
		storeDTO.setStoreMenuCheese("N");
		storeDTO.setStoreMenuPastry("Y");
		storeDTO.setStoreMenuOther("N");
		storeDTO.setStorePaymentCashMoney("Y");
		storeDTO.setStorePaymentCard("Y");
		storeDTO.setStorePaymentAccount("N");
		
		model.addAttribute("storeInfo", storeDTO);
		
		ArrayList<StoreWorkDTO> datas = new ArrayList<StoreWorkDTO>();
		
		StoreWorkDTO data1 = new StoreWorkDTO();
		data1.setStoreWorkWeek("월요일");
		data1.setStoreWorkOpen("11:00");
		data1.setStoreWorkClose("15:00");
		datas.add(data1);
		StoreWorkDTO data2 = new StoreWorkDTO();
		data2.setStoreWorkWeek("수요일");
		data2.setStoreWorkOpen("12:00");
		data2.setStoreWorkClose("17:00");
		datas.add(data2);
		StoreWorkDTO data3 = new StoreWorkDTO();
		data3.setStoreWorkWeek("금요일");
		data3.setStoreWorkOpen("11:00");
		data3.setStoreWorkClose("18:00");
		datas.add(data3);
		
		storeDTO.setWorkList(datas);
		
		
		return "store";
	}
	
	// 확인용
	@RequestMapping(value = "/loadListStore.do")
	public String checkLoadStoreListData(Model model, StoreDTO storeDTO) {
		List<StoreDTO> datas = new ArrayList<StoreDTO>();
		
		StoreDTO storeDTO1 = new StoreDTO();
		storeDTO1.setStoreName("갈빵 붕어빵");
		storeDTO1.setStoreAddress("서울시 동작구 대방동13길 13");
		storeDTO1.setStoreAddressDetail("골목 옆");
		storeDTO1.setStoreContact("010-0000-0000");
		datas.add(storeDTO1);

		StoreDTO storeDTO2 = new StoreDTO();
		storeDTO2.setStoreName("수제 붕어빵");
		storeDTO2.setStoreAddress("서울시 강남구 테헤란로26길 14");
		storeDTO2.setStoreAddressDetail("사거리 옆 건물 2층");
		storeDTO2.setStoreContact("010-1111-1111");
		datas.add(storeDTO2);

		StoreDTO storeDTO3 = new StoreDTO();
		storeDTO3.setStoreName("한입 붕어빵");
		storeDTO3.setStoreAddress("서울시 서초구 서초동 1621-13");
		storeDTO3.setStoreAddressDetail("지하철역 출구 근처");
		storeDTO3.setStoreContact("010-2222-2222");
		datas.add(storeDTO3);

		StoreDTO storeDTO4 = new StoreDTO();
		storeDTO4.setStoreName("옛날 붕어빵");
		storeDTO4.setStoreAddress("서울시 마포구 월드컵로3길 14");
		storeDTO4.setStoreAddressDetail("공원 앞");
		storeDTO4.setStoreContact("010-3333-3333");
		datas.add(storeDTO4);
		
		model.addAttribute("storeList", datas);
		
		return "storeList";
	}
	
	// 확인용
		@RequestMapping(value = "/loadListProduct.do")
		public String checkLoadProductListData(Model model, ProductDTO productDTO) {
			List<ProductDTO> datas = new ArrayList<ProductDTO>();
			
			ProductDTO productDTO1 = new ProductDTO();
			productDTO1.setProductNum(1);
			productDTO1.setProductName("붕어빵 후드티");
			productDTO1.setProductProfileWay("image5.png");
			productDTO1.setProductPrice(20000);
			productDTO1.setProductCategoryName("의류");
			productDTO1.setProductCategoryNum(1);
			productDTO1.setBoardTitle("붕어빵 후드티");
			productDTO1.setBoardContent("붕어빵 후드티 입니다.");
			productDTO1.setBoardNum(1);
			datas.add(productDTO1);
			
			ProductDTO productDTO2 = new ProductDTO();
			productDTO2.setProductNum(2);
			productDTO2.setProductName("붕어빵 양말");
			productDTO2.setProductProfileWay("image3.png");
			productDTO2.setProductPrice(1000);
			productDTO2.setProductCategoryName("의류");
			productDTO2.setProductCategoryNum(1);
			productDTO2.setBoardTitle("붕어빵 양말");
			productDTO2.setBoardContent("붕어빵 양말 입니다.");
			productDTO2.setBoardNum(2);
			datas.add(productDTO2);
			
			model.addAttribute("resentProduct", datas);
			model.addAttribute("productList", datas);
			
			return "productList";
		}
		
		// 제품 상세 샘플
		@RequestMapping(value = "/infoProduct.do")
		public String checkLoadProductData(Model model, ProductDTO productDTO) {
			
			productDTO.setProductNum(1);
			productDTO.setProductName("붕어빵 후드티");
			productDTO.setProductProfileWay("image5.png");
			productDTO.setProductPrice(20000);
			productDTO.setProductCategoryName("의류");
			productDTO.setProductCategoryNum(1);
			productDTO.setBoardTitle("붕어빵 후드티");
			productDTO.setBoardContent("붕어빵 후드티 입니다.");
			productDTO.setBoardNum(1);

			model.addAttribute("product", productDTO);
			
			return "productDetail";
		}
		
		// 카트 샘플
		@RequestMapping(value = "/productCart.do")
		public String checkLoadProductCart(Model model, ProductDTO productDTO) {
			
//			productDTO.setProductNum(1);
//			productDTO.setProductName("붕어빵 후드티");
//			productDTO.setProductProfileWay("image5.png");
//			productDTO.setProductPrice(20000);
//			productDTO.setProductCategoryName("의류");
//			productDTO.setProductCategoryNum(1);
//			productDTO.setBoardTitle("붕어빵 후드티");
//			productDTO.setBoardContent("붕어빵 후드티 입니다.");
//			productDTO.setBoardNum(1);
			
			model.addAttribute("product", productDTO);
			model.addAttribute("userPK", "임시");
			
			return "productCart";
		}
		
		// 포인트 충정
		@RequestMapping(value = "/pointRecharge.do")
		public String checkLoadProductCart(Model model) {

			model.addAttribute("userPK", "임시");
			
			return "pointRecharge";
		}
		
		// 게시물 수정
		@RequestMapping(value = "/updateBoard.do")
		public String checkLoadFixBoard(Model model, BoardDTO boardDTO) {
			
			model.addAttribute("userPK", "임시");
			
			boardDTO.setBoardNum(1);
			boardDTO.setBoardFolder("임시");
			boardDTO.setBoardCategoryName("boardList");
			boardDTO.setBoardTitle("확인용 제목");
			boardDTO.setBoardContent("확인용ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
			
			return "fixBoard";
		}
		// 게시물 작성
		@RequestMapping(value = "/addBoard.do")
		public String checkLoadAddBoard(Model model, BoardDTO boardDTO) {
			
			model.addAttribute("userPK", "임시");
			
			boardDTO.setBoardNum(1);
			boardDTO.setBoardFolder("임시");
			boardDTO.setBoardCategoryName("boardList");
			boardDTO.setBoardTitle("확인용 제목");
			boardDTO.setBoardContent("확인용ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
			
			return "boardWrite";
		}
		
}
