package com.koreait.app.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
		
	@Before("PointcutCommon.aPointcut()")
	public void printLog() {
		System.out.println("공통 관심 - 로그 : 비즈니스 메서드 수행 전에 호출 됨");
	}

}
