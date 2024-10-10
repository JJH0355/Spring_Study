package test;

public class IPhone implements Phone{
	private int num;
	
	public IPhone() {
		System.out.println("아이폰 객체 생성");
		this.num = 123;
	}
	
	public void powerOn() {
		System.out.println("아이폰 전원 ON");
	}
	
	public void powerOff() {
		System.out.println("아이폰 정말 Off");
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}