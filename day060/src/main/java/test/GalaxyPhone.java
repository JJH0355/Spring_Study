package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("samsung")
public class GalaxyPhone implements Phone{
	@Autowired
	@Qualifier("galaxyWatch")
	private Watch watch;
	
	public GalaxyPhone() {
		System.out.println("갤럭시 객체 생성");
	}
	public GalaxyPhone(Watch watch) {
		this.watch = watch;
	}
	
	// 워치로 핸드폰을 키고 싶다
	@Override
	public void powerOn() {
		//System.out.println("갤럭시 전원 ON");
		this.watch.turnOn();
	}

	@Override
	public void powerOff() {
		//System.out.println("갤럭시 전원 Off");
		this.watch.turnOff();
	}
}
