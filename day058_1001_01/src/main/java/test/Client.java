package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		System.out.println("Client 실행");
		
		// 컨테이너를 구동시키는 코드
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("Client가 객체를 가져옴");
		Phone phone = (Phone) factory.getBean("apple");
		// Bean == 자바객체 == 객체 == POJO
		// 객체를 요청하다.
		// == look up
		
		phone.powerOn();
		phone.powerOff();
		
		factory.close();
	}
}