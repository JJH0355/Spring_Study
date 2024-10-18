package com.koreait.app.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	// 참조 메서드들 작성
	// 모든 서비스 기능에서 반환 값이 있을 경우를 찾기 위한 참조 메서드
	@Pointcut("execution(* com.koreait.app.biz..*Impl.*(..))")
	public void returnPointcut() {}
	
	// 모든 서비스 기능에서 CUD에 접근하는 경우를 찾기 위한 참조 메서드
	// CUD의 일치하는 형식은 boolean 값으로 반환 한다는 것
	@Pointcut("execution(boolean com.koreait.app.biz..*Impl.*(..))")
	public void CUDPointcut() {}
	
	// 게시물 등록 로그용
	@Pointcut("execution(* com.koreait.app.biz.board..*Impl.insert(..))")
	public void boardInsertPointcut() {}
}
