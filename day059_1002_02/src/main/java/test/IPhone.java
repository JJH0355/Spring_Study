package test;

public class IPhone implements Phone{
	private Watch watch;
	
	public IPhone() {
		System.out.println("아이폰 객체 생성");
	}
	
	public void powerOn() {
		System.out.println("아이폰 전원 ON");
		this.watch.turnOn();
	}
	
	public void powerOff() {
		System.out.println("아이폰 정말 Off");
		this.watch.turnOff();
	}

}
