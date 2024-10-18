package com.koreait.app.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.koreait.app.biz.board.BoardDTO;

@Service
@Aspect
public class TestAdvice {
	
	@AfterReturning("PointcutCommon.aPoint()")
	public void print(JoinPoint jp){
		System.out.println("현재 이 어드바이스랑 연결된 조인포인트의 메서드명");
		System.out.println("== 현재 포인트컷의 메서드명");
		String methodName = jp.getSignature().getName();
		System.out.println(methodName);
		
		System.out.println("현재 이 어드바이스랑 연결된 조인포인트의 매개변수 정보");
		System.out.println("== 포인트컷의 매개변수 정보");
		Object[] args = jp.getArgs();
		
		// casting 전 가능한지 확인작업
		if(args[0] instanceof BoardDTO) {
			BoardDTO boardDTO = (BoardDTO)args[0];
			System.out.println(boardDTO.getWriter()+"님이 DB에 글을 등록했습니다.");
		}
	}

}
