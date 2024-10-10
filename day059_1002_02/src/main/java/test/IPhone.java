package test;

public class IPhone implements Phone{
	// 2. 의존하는 객체를 멤버변수로 만듬
	private Watch watch;
	// 원시타입의 경우
	private int num;
	
	public IPhone() {
		System.out.println("아이폰 객체 생성 01");
	}
	
	// 생성자 주입
	
	// 3. 객체 생성
	// 기본 생성자에 new가 들어가야 하므로 외부에서 받아서 하도록 새로운 생성자를 만듬
	public IPhone(Watch watch) {
		this.watch = watch;
		System.out.println("아이폰 객체 생성 02");
	}
	//원시타입의 경우
	public IPhone(Watch watch, int num) {
		this.watch = watch;
		this.num = num;
		System.out.println("아이폰 객체 생성 03");
	}
	
	
	
	// 1. 해당 코드를 보니 watch에 의존성을 가짐
	public void powerOn() {
		this.watch.turnOn();
		System.out.println("num = ["+this.num+"]");
	}
	
	public void powerOff() {
		this.watch.turnOff();
	}

	// setter 주입
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
