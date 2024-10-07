package com.koreait.app.view.controller;

import java.security.DomainLoadStoreParameter;
import java.util.HashMap;
import java.util.Map;

import com.koreait.app.view.member.LoginController;

public class HandlerMapping {
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		// 의존 주입 1개
		this.mappings = new HashMap<String, Controller>();
		
		this.mappings.put("/login.do", new LoginController());
		this.mappings.put("/main.do", new MainController());
	}
	
	// 생성자 주입
	public Controller getController(String command) {
		return mappings.get(command);
	}
}
