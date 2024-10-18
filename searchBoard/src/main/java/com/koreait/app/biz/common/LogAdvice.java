package com.koreait.app.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	// 작업을 한 데이터의 반환값 타입을 알아야 하므로 JoinPoint를 사용한다.
	@AfterReturning("PointcutCommon.returnPointcut()")
	public void printReturnValue(JoinPoint jp) {
		// 현재 이 어드바이스와 연결된 JP에서 메서드명을 가져옴
		String methodName = jp.getSignature().getName();
		
		// DTO를 반환하는 메서드는 selectOne만 있으므로
		// JP의 메서드명이 selectOne이라면
		if(methodName.equals("selectOne")) {
			// 현재 이 어드바이스와 연결된 JP에서 매개변수 정보 가져오기
			Object[] args = jp.getArgs();
			
			// DTO 이름을 추출할 변수명
			String DTOName = args[0].getClass().getName();
			
			// 출력할 부분만 추출
			DTOName = DTOName.substring(DTOName.lastIndexOf(".")+1, DTOName.length());
			
			
			
			// 어떤 DTO인지 출력
			System.out.println(DTOName+"를 사용했습니다.");
		}
		
	}
	
	@Before("PointcutCommon.CUDPointcut()")
	public void printDBConnect() {
		System.out.println("DB 접근 발생!");
	}
	@AfterReturning("PointcutCommon.CUDPointcut()")
	public void printDBDisConnect() {
		System.out.println("DB 변경 완료!");
	}
}
