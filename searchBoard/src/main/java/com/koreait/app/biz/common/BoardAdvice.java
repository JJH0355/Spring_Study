package com.koreait.app.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.koreait.app.biz.board.BoardDTO;

@Service
@Aspect
public class BoardAdvice {
	
	@AfterReturning("PointcutCommon.boardInsertPointcut()")
	public void boardInsertLog(JoinPoint jp) {
		
		// JointPoint의 매개변수 정보 가져오기
		Object[] args = jp.getArgs();
		
		// casting 전 가능한지 확인작업
		if(args[0] instanceof BoardDTO) {
			BoardDTO boardDTO = (BoardDTO)args[0];
			// 매개변수에서 작성자 가져오기
			System.out.println(boardDTO.getWriter()+"님이 DB에 글을 등록했습니다.");
		}
		else {
			System.out.println("DTO 외의 값이 들어옴");
		}
	}
}