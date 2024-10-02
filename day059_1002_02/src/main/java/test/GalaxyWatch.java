package test;

public class GalaxyWatch implements Watch{

	public GalaxyWatch() {
		System.out.println("갤럭시 워치 생성");
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
