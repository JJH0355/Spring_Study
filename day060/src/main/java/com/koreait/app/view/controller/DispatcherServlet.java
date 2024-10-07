package com.koreait.app.view.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// DispatcherServlet은 HandlerMapping, ViewResolver을 의존하고 있다.
	// ==의존 주입 필요 (2개)
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;

	// 의존 주입
	// init 생성 함수를 사용하여 주입함
	public void init() {
		this.handlerMapping = new HandlerMapping();
		this.viewResolver = new ViewResolver();
		this.viewResolver.setPrefix("./");
		this.viewResolver.setSuffix(".jsp");
	}


	public DispatcherServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	// 모든 액션을 처리할 수 있는 doAction생성
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자(클라이언트, 브라우저)의 요청 추출
		String uri = request.getRequestURI();
		// 마지막 슬래시에서 자름
		String command = uri.substring(uri.lastIndexOf("/"));

		// 2. 요청에 해당하는 Controller 기능을 수행
		// 팩토리 패턴을 활용하는 handlerMapping
		Controller controller = this.handlerMapping.getController(command);

		// ViewResolver가 이동 방식을 판단해주므로 경로만 받으면 됨
		String path = controller.excute(request, response);

		// 3. 응답(페이지 이동)
		// viewResolver을 사용하여 응답한다.

		// 응답이 login or main.do로 올 때가 있다.
		// path 뒤쪽에 .do가 붙어있다면 controller로 이동하는 것

		// viw로 이동하는 것이라면
		if(!path.contains(".do")) {
			path=this.viewResolver.getView(path);
		}

		// viw, .do 모두 sendRedirect
		response.sendRedirect(path);

	}
}

