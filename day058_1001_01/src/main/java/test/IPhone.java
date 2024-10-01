package test;

public class IPhone implements Phone{
	public IPhone() {
		System.out.println("아이폰 객체 생성");
	}
	
	public void powerOn() {
		System.out.println("아이폰 전원 ON");
	}
	
	public void powerOff() {
		System.out.println("아이폰 전원 Off");
	}

}
