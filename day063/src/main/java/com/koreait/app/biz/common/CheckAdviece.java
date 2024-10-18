package com.koreait.app.biz.common;

import org.aspectj.lang.annotation.AfterReturning;

import com.koreait.app.biz.member.MemberDTO;

public class CheckAdviece {
	
	@AfterReturning(pointcut="PointcutCommon.aPointcut()", returning = "returnObj")
	public void check(Object returnObj) {
		if(returnObj instanceof MemberDTO) {
			MemberDTO memberDTO = (MemberDTO)returnObj;
			if(memberDTO.getRole().equals("USER")) {
				System.out.println("회원이 로그인 했습니다.");
			}
			else {
				System.out.println("관리자가 로그인했습니다.");
			}
		}
	}
}
