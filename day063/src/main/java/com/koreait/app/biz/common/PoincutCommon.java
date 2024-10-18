package com.koreait.app.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PoincutCommon{
	
	@Pointcut("execution(* com.koreait.app.biz..*Impl.*(..))")
	public void aPointcut() {} // 참조 메서드
								// 실질적 기능은 없으므로 빈 메서드로 생성
	
	@Pointcut("execution(* com.koreait.app.biz..*Impl.select*(..))")
	public void bPointcut() {}

}
