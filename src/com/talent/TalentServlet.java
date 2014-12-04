package com.talent;

import com.util.DBConn;
import com.util.FileManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by JS on 2014-12-01.
 */
public class TalentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void forward(HttpServletRequest req, HttpServletResponse resp,
			String url) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String cp = req.getContextPath();

		Connection conn = DBConn.getConnection();
		TalentDAO dao = new TalentDAO(conn);
		FileManager file = new FileManager();

		String uri = req.getRequestURI();

		String url;

		String root = getServletContext().getRealPath("/");
		String path = root + File.separator + "pds" + File.separator
				+ "imageFile";

		if (uri.contains("Register.do")) {

			String mbId = req.getParameter("mbId");
			String mbPw1 = req.getParameter("mbPw1");
			String mbPw2 = req.getParameter("mbPw2");

			String str = "";

			if (dao.selectData(mbId) != null) {
				str = "아이디가 존재합니다.";
			} else if (!mbPw1.equals(mbPw2)) {
				str = "비밀번호가 일치하지 않습니다.";
			} else {

				MemberDTO dto = new MemberDTO();

				dto.setMbId(mbId);
				dto.setMbPw(mbPw1);
				dao.insertData(dto);

				str = "가입이 완료되었습니다.";
			}

			req.setAttribute("str", str);

			url = "/Register/Register.jsp";
			forward(req, resp, url);

		} else if (uri.contains("Register_ok.do")) {
			resp.sendRedirect("../");
		} else if (uri.contains("GDetail.do")) {
			String brNum = req.getParameter("brNum");

			url = "/Goods/GDetail.do";
			forward(req, resp, url);
		} else if (uri.contains("GOrder.do")) {
			String option = req.getParameter("completedOption");
			String brNum = req.getParameter("brNum");

			req.setAttribute("option", option);

			url = "/Goods/GOrder.jsp";
			forward(req, resp, url);

		} else if (uri.contains("Login.do")) {

			String mbId = req.getParameter("mbId");
			String mbPw = req.getParameter("mbPw");
			String str = "";

			MemberDTO dto = dao.getReadMember(mbId);

			if (dto == null) {
				str = "아이디가 없습니다.";

			} else if (!dto.getMbPw().equals(mbPw)) {
				str = "비밀번호가 틀렸습니다.";

			} else {
				HttpSession session = req.getSession(true);

				MemberSession mbs = new MemberSession();

				mbs.setMbId(mbId);
				mbs.setMbPw(mbPw);

				session.setAttribute("session", mbs);

				url = cp + "/Goods/Main.do";
				resp.sendRedirect(url);

				return;
			}

			req.setAttribute("str", str);

			url = "/Register/Register.jsp";
			forward(req, resp, url);

		} else if (uri.contains("Main.do")) {
			String str = "";

			str = (String) req.getAttribute("str");

			req.setAttribute("str", str);

			url = "/Goods/Main.jsp";
			forward(req, resp, url);
		} else if (uri.contains("logout.do")) {

			String str = "";

			str = "로그아웃 되셨습니다.";

			req.setAttribute("str", str);
			
			HttpSession session = req.getSession();
			session.invalidate();
			
			url = "/Register/Register.jsp";
			forward(req, resp, url);

			
			//My	
		} else if (uri.contains("MyAccount.do")) {
			
			url = "/My/MyAccount.jsp";
			forward(req, resp, url);
			
		} else if (uri.contains("MyFavority.do")){
			url = "/My/MyFavority.jsp";
			forward(req, resp, url);
			
		} else if (uri.contains("MyMessage.do")) {
			url = "/My/MyMessage.jsp";
			forward(req, resp, url);
			
		} else if (uri.contains("MyMistus.do")) {
			
			url = "/My/MyMistus.jsp";
			forward(req, resp, url);
			
		} else if (uri.contains("MyOrderMng.do")) {
			
			url = "/My/MyOrderMng.jsp";
			forward(req, resp, url);
			
		} else if (uri.contains("MyPoint.do")) {
			
			url = "/My/MyPoint.jsp";
			forward(req, resp, url);
			
		} else if (uri.contains("MyProfile.do")) {
			
			url = "/My/MyProfile.jsp";
			forward(req, resp, url);
			
		} else if (uri.contains("SellIncome.do")) {
			
			url = "/My/SellIncome.jsp";
			forward(req, resp, url);
			
		} else if (uri.contains("SellMng.do")) {
			
			url = "/My/SellMng.jsp";
			forward(req, resp, url);
			
		} else if (uri.contains("SellProdListMy.do")) {
			
			url = "/My/SellProdListMy.jsp";
			forward(req, resp, url);
			
		} else if (uri.contains("SellProdReg.do")) {
			
			url = "/My/SellProdReg.jsp";
			forward(req, resp, url);

		}

	}

}
































