package com.event;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListenerTest implements ServletContextListener{
	
	//Web ������ ����ǰų� ����ɶ�

	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		
		System.out.println("���� �״´�....");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		
		System.out.println("���� ��Ƴ���....");
		
		ServletContext sc = evt.getServletContext();
		
		//� �ҽ��ڵ忡���� ������ ������ ������
		//��� servlet,JSP���� ������ ����->${name}
		sc.setAttribute("name", "�� �������� �� ���� �ִ�.");
	}
	
	
	
	
	

}
