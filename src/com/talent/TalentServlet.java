package com.talent;

import com.util.DBConn;
import com.util.FileManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by JS on 2014-12-01.
 */
public class TalentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

		String cp = req.getContextPath();

		Connection conn = DBConn.getConnection();
		TalentDAO dao = new TalentDAO(conn);
		FileManager file = new FileManager();

		String uri = req.getRequestURI();

		String url;

		String root = getServletContext().getRealPath("/");
		String path = root + File.separator + "pds" + File.separator + "imageFile";

		if(uri.contains("Register.do")){
            url = "/Register/Register.jsp";
            forward(req, resp, url);
		} else if(uri.contains("Register_ok.do")) {
            resp.sendRedirect("../");
        } else if(uri.contains("GDetail.do")) {
			String brNum = req.getParameter("brNum");

			url = "/Goods/GDetail.do";
			forward(req, resp, url);
		} else if(uri.contains("GOrder.do")) {
			String option = req.getParameter("completedOption");
			String brNum = req.getParameter("brNum");

			req.setAttribute("option", option);

			url = "/Goods/GOrder.jsp";
			forward(req, resp, url);
		}

    }

    protected void forward(HttpServletRequest req, HttpServletResponse resp, String url)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
}
