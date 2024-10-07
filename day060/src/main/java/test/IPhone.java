package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// .xml 파일의 bean을 대신하는 어노테이션
// bean 속성의 class는 해당 위치임으로 충족
// 			 id는 뒤에 입력
@Component("apple")
public class IPhone implements Phone{
	// Autowired 어노테이션을 달면 메모리의 자료형(타입)을 인지해서 주입해줌
	@Autowired
	// 주입할 객체의 이름까지 지정하는 어노테이션
	@Qualifier("appleWatch")
	private Watch watch;
	// 원시타입의 경우
	private int num;
	
	public IPhone() {
		System.out.println("아이폰 객체 생성 01");
	}
	
    // 메서드
	public void powerOn() {
		this.watch.turnOn();
		System.out.println("아이폰 켜짐");
		System.out.println("num = ["+this.num+"]");
	}
	public void powerOff() {
		this.watch.turnOff();
		System.out.println("아이폰 꺼짐");
	}

    // getter, setter
	public Watch getWatch() {
		return watch;
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}