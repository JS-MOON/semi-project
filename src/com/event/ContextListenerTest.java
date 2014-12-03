package com.event;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListenerTest implements ServletContextListener{
	
	//Web 서버가 실행되거나 종료될때

	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		
		System.out.println("서버 죽는다....");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		
		System.out.println("서버 살아난다....");
		
		ServletContext sc = evt.getServletContext();
		
		//어떤 소스코드에서도 접근이 가능한 데이터
		//모든 servlet,JSP에서 접근이 가능->${name}
		sc.setAttribute("name", "난 누구든지 다 볼수 있다.");
	}
	
	
	
	
	

}
