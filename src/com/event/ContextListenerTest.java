package com.event;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by JS on 2014-11-25.
 */
public class ContextListenerTest implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent evt) {
        System.out.println("Server Opened");

        ServletContext sc = evt.getServletContext();

        sc.setAttribute("helloWorld", "Hello World.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent evt) {
        System.out.println("Server Closed");
    }

}
