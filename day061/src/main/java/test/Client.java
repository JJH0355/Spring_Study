package test;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.koreait.app.biz.board.BoardDTO;
import com.koreait.app.biz.board.BoardService;

public class Client {
	public static void main(String[] args) {
		// 컨테이너를 구동시키는 코드
				AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
				
				BoardService app = (BoardService) factory.getBean("boardService");
				BoardDTO boardDTO = new BoardDTO();
				
				boardDTO.setTitle("시험용");
				boardDTO.setWriter("JJH");
				boardDTO.setContent("확인용 게시글 insert");
				
				boolean flag = app.insert(boardDTO);
				
				System.out.println("	log : Client.java	flag : ["+flag+"]");
				
				factory.close();
	}

}
