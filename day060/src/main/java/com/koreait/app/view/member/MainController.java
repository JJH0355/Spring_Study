package com.koreait.app.view.member;

import com.koreait.app.view.controller.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainController implements Controller{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		String path = "main";
		return path;
	}
	
}
