package com.koreait.app.view.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.app.biz.member.MemberDTO;
import com.koreait.app.biz.member.MemberService;

@RestController
public class CheckController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/checkMID.do", method = RequestMethod.POST)
	public @ResponseBody String checkMID(MemberDTO memberDTO) {
		
		memberDTO = memberService.selectOne(memberDTO);
		
		String result = "false";
		
		if(memberDTO != null) {
			result = "true";
		}
		
		System.out.println("result : ["+result+"]");
		return result;
	}
}
