package test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.koreait.app.biz.member.MemberDTO;
import com.koreait.app.biz.member.MemberService;

public class Client {
	public static void main(String[] args) {
		// 컨테이너를 구동시키는 코드
		AbstractApplicationContext factory = new GenericXmlApplicationContext("app.xml");
		
		MemberService app = (MemberService) factory.getBean("memberService");
		MemberDTO memberDTO = new MemberDTO();
		
//		memberDTO.setMid("JJHid");
//		memberDTO.setPassword("1234");
//		memberDTO.setName("JJH");
//		memberDTO.setRole("USER");
		
		List<MemberDTO> datas = app.selectAll(memberDTO);
		
		System.out.println(datas);
		
		factory.close();

		
	/*	AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		Phone phone = (Phone) factory.getBean("apple");
		// Bean == 자바객체 == 객체 == POJO
		// 객체를 요청하다.
		// == look up
		
		phone.powerOn();
		phone.powerOff();
		*/
		
	}
}