package com.event;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by JS on 2014-11-25.
 */
public class CountManager implements HttpSessionListener{

    private static CountManager countManager;
    private static int count;

    public CountManager() {
        countManager = this;
    }

    public static synchronized CountManager getInstance() {
        if(countManager == null)
            countManager = new CountManager();

        return countManager;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void sessionCreated(HttpSessionEvent evt) {
        HttpSession session = evt.getSession();
        session.setMaxInactiveInterval(20*60);

        count++;

        System.out.print(session.getId() + ": Session Created, ");
        System.out.print("Members: " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent evt) {
        HttpSession session = evt.getSession();

        count--;

        System.out.print(session.getId() + ": Session Destroyed, ");
        System.out.print("Members: " + count + " ");
    }
}
