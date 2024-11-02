package com.koreait.app.view.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bungeobbang.app.biz.store.StoreDTO;
import com.koreait.app.biz.board.BoardDTO;
import com.koreait.app.biz.board.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SearchBoardController {
//	@Autowired
//	private BoardService boardService;
	
	// 게시글 검색
//	@RequestMapping("/searchBoard.do")
//	public @ResponseBody List<BoardDTO> searchBoard(@RequestBody BoardDTO boardDTO) {
//		System.out.println("	log : BoardController.searchBoard()		시작");
//
//		// 비동기처리로 들어오 DTO 확인
//		System.out.println("	log : BoardController.searchBoard()		boardDTO : [" + boardDTO + "]");
//
//		// DAO로 selectAll 하기
//		// 검색 결과를 List<boardDTO> datas로 받기
//		List<BoardDTO> datas = boardService.selectAll(boardDTO);
//		System.out.println("	log : BoardController.searchBoard()		datas : [" + datas + "]");
//
//		return datas;
//	}
	
	@RequestMapping("/addressSearch.do")
	public @ResponseBody List<StoreDTO> searchStore(@RequestBody StoreDTO storeDTO){
		System.out.println("storeDTO : ["+storeDTO+"]");
		
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

		StoreDTO storeDTO5 = new StoreDTO();
		storeDTO5.setStoreName("찹쌀 붕어빵");
		storeDTO5.setStoreAddress("서울시 종로구 종로3가 5");
		storeDTO5.setStoreAddressDetail("버스정류장 근처");
		storeDTO5.setStoreContact("010-4444-4444");
		datas.add(storeDTO5);

		StoreDTO storeDTO6 = new StoreDTO();
		storeDTO6.setStoreName("고구마 붕어빵");
		storeDTO6.setStoreAddress("서울시 성동구 연무장7길 11");
		storeDTO6.setStoreAddressDetail("마트 앞");
		storeDTO6.setStoreContact("010-5555-5555");
		datas.add(storeDTO6);

		StoreDTO storeDTO7 = new StoreDTO();
		storeDTO7.setStoreName("미니 붕어빵");
		storeDTO7.setStoreAddress("서울시 은평구 통일로 684");
		storeDTO7.setStoreAddressDetail("상가 내부");
		storeDTO7.setStoreContact("010-6666-6666");
		datas.add(storeDTO7);
        
        // 데이터 확인 출력
        datas.forEach(System.out::println);
		
		return datas;
	}
	
	@RequestMapping("/loadListStoreMap.do")
	public @ResponseBody List<StoreDTO> mySearchStore(@RequestBody StoreDTO storeDTO){
		System.out.println("storeDTO : ["+storeDTO+"]");
		
		List<StoreDTO> datas = new ArrayList<StoreDTO>();
		
		StoreDTO storeDTO1 = new StoreDTO();
		storeDTO1.setStoreName("붕어빵 가게 1");
		storeDTO1.setStoreAddress("서울시 강남구 역삼동 825-1");
		storeDTO1.setStoreAddressDetail("스타벅스 옆");
		storeDTO1.setStoreContact("010-1234-0001");
		datas.add(storeDTO1);

		StoreDTO storeDTO2 = new StoreDTO();
		storeDTO2.setStoreName("붕어빵 가게 2");
		storeDTO2.setStoreAddress("서울시 강남구 역삼동 840-1");
		storeDTO2.setStoreAddressDetail("역삼역 3번 출구");
		storeDTO2.setStoreContact("010-1234-0002");
		datas.add(storeDTO2);

		StoreDTO storeDTO3 = new StoreDTO();
		storeDTO3.setStoreName("붕어빵 가게 3");
		storeDTO3.setStoreAddress("서울시 강남구 역삼동 832-2");
		storeDTO3.setStoreAddressDetail("GS25 옆");
		storeDTO3.setStoreContact("010-1234-0003");
		datas.add(storeDTO3);

		StoreDTO storeDTO4 = new StoreDTO();
		storeDTO4.setStoreName("붕어빵 가게 4");
		storeDTO4.setStoreAddress("서울시 강남구 역삼동 840");
		storeDTO4.setStoreAddressDetail("커피빈 옆");
		storeDTO4.setStoreContact("010-1234-0004");
		datas.add(storeDTO4);

		StoreDTO storeDTO5 = new StoreDTO();
		storeDTO5.setStoreName("붕어빵 가게 5");
		storeDTO5.setStoreAddress("서울시 강남구 역삼동 834-1");
		storeDTO5.setStoreAddressDetail("역삼우체국 앞");
		storeDTO5.setStoreContact("010-1234-0005");
		datas.add(storeDTO5);

		StoreDTO storeDTO6 = new StoreDTO();
		storeDTO6.setStoreName("붕어빵 가게 6");
		storeDTO6.setStoreAddress("서울시 강남구 역삼동 840-3");
		storeDTO6.setStoreAddressDetail("선릉공원 옆");
		storeDTO6.setStoreContact("010-1234-0006");
		datas.add(storeDTO6);

		StoreDTO storeDTO7 = new StoreDTO();
		storeDTO7.setStoreName("붕어빵 가게 7");
		storeDTO7.setStoreAddress("서울시 강남구 역삼동 830");
		storeDTO7.setStoreAddressDetail("파리바게뜨 옆");
		storeDTO7.setStoreContact("010-1234-0007");
		datas.add(storeDTO7);
        
        // 데이터 확인 출력
        datas.forEach(System.out::println);
		
		return datas;
	}
}
