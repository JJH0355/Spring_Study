package test;

public class AppleWatch implements Watch{
	
	public AppleWatch() {
		System.out.println("애플워치 생성");
	}

	@Override
	public void turnOn() {
		System.out.println("화면 켜짐");
		
	}

	@Override
	public void turnOff() {
		System.out.println("화면 꺼짐");
		
	}

}
