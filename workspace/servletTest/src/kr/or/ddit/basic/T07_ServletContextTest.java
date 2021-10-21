package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T07_ServletContextTest extends HttpServlet {
/*
     서블릿 컨텍스트 객체에 대하여...
     
     1. 서블릿 프로그램이 컨테이터와 정보를 주고 받기 위한 메서드를 제공한다.
     2. 웹 애플리케이션 당 1개씩  생성된다.
     3. 서블릿이 생성되고 초기화 메서드 실행시,
        ServletConfig 객체를 통해서 얻을 수 있다.
*/	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext ctx = req.getServletContext();
		
		System.out.println("서블릿컨텍스트의 기본 경로 : " 
				+ ctx.getContextPath());
		System.out.println("서버 정보 : " 
				+ ctx.getServerInfo());
		System.out.println("서블릿 API의 메이저 버전 정보 : " 
				+ ctx.getMajorVersion());
		System.out.println("서블릿 API의 마이너 버전 정보 : " 
				+ ctx.getMinorVersion());
		System.out.println("배포기술자에 기술된 컨텍스트명 : " 
				+ ctx.getServletContextName());
		System.out.println("리소스 경로 목록 : " 
				+ ctx.getResourcePaths("/"));
		System.out.println("모든 등록된 서블릿목록 맵 : " 
				+ ctx.getServletRegistrations().toString());
		System.out.println("파일에 대한 MIME타입 정보 : " 
				+ ctx.getMimeType("abc.mp3"));
		System.out.println("파일시스템 상의 실제 경로 : " 
				+ ctx.getRealPath("/"));
		System.out.println("리소스의 URL 정보 : " 
				+ ctx.getResource("/index.html"));
		
		// 속성값 설정
		ctx.setAttribute("attr1", "속성1");
		
		// 속성값 변경
		ctx.setAttribute("attr1", "속성2");
		
		// 속성값 가져오기
		System.out.println("attr1의 속성값 : " 
				+ ctx.getAttribute("attr1"));
		
		// 속성값 지우기
		ctx.removeAttribute("attr1");
		
		// 로깅 작업하기
		ctx.log("서블릿 컨텍스트를 이용한 로깅작업중 입니다.");
		
		// 포워딩 처리
		ctx.getRequestDispatcher("/T06_ServletSessionTest")
				.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
