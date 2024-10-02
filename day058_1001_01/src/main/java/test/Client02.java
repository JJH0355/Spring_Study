package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client02 {
	public static void main(String[] args) {
		
		// 컨테이너를 구동시키는 코드
		// Spring에서 제공하고 있는 컨테이너 클래스
		// 설정파일을 인자로 받음
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 생성되어있는 객체를 가져옴(getBean)
		// 어떤 타입으로 들어올 지 모르니 형변환
		Watch watch = (Watch)factory.getBean("appleWatch");
		
		watch.turnOn();
		watch.turnOff();
		
		factory.close();
	}
}
