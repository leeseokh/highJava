package kr.or.ddit.basic;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener
										, ServletContextAttributeListener{
	public MyServletContextListener() {
		System.out.println("[MyServletContextListener]"
				+ "생성자 메서드 호출됨.");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("[MyServletContextListener]"
				+ "contextDestroyed() 메서드 호출됨.");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("[MyServletContextListener]"
				+ "contextInitialized() 메서드 호출됨.");
		
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("[MyServletContextListener]"
				+ "attributeAdded() 메서드 호출됨 : " 
				+ scae.getName());
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("[MyServletContextListener]"
				+ "attributeRemoved() 메서드 호출됨 : " 
				+ scae.getName());
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("[MyServletContextListener]"
				+ "attributeReplaced() 메서드 호출됨 : " 
				+ scae.getName());
	}

}
