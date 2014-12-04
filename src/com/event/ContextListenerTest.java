package com.event;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListenerTest implements ServletContextListener{
	

	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		
		System.out.println("Server Opened!");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		
		System.out.println("Server Closed!");
		
	}
	
	
	
	
	

}
