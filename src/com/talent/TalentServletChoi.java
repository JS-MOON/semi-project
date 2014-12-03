package com.talent;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.DBConn;

public class TalentServletChoi extends HttpServlet {

	private static final long serialVersionUID = 1L;

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

		String cp = req.getContextPath();

		Connection conn = DBConn.getConnection();

		TalentDAO dao = new TalentDAO(conn);

		String uri = req.getRequestURI();

		String url;

		if(uri.indexOf("test.do") != -1){
			
			url = "/talent/test.jsp";
			forward(req, resp, url);
			
		}
		else if (uri.indexOf("member.do") != -1) {
			
			List<TalentDTO> lists = dao.getList();
			
			req.setAttribute("lists", lists);
			
			url = "/talent/member.jsp";
			forward(req, resp, url);						

		}else if (uri.indexOf("newMember.do") != -1) {
			
			url = "/talent/newMember.jsp";
			forward(req, resp, url);
			
		}else if (uri.indexOf("newMember_ok.do") != -1) {
			
			TalentDTO dto = new TalentDTO();
			int result = 0;
			
			dto.setMb_id(req.getParameter("mb_id"));
			dto.setMb_pw(req.getParameter("mb_pw"));
			
			result = dao.insertData(dto);
						
			req.setAttribute("result", result);

			url = "/talent/newMember_ok.jsp";
			forward(req, resp, url);
		
		}else if (uri.indexOf("searchMember.do") != -1) {
			
			url = "/talent/searchMember.jsp";
			forward(req, resp, url);
			
		}else if (uri.indexOf("searchMember_ok.do") != -1) {
			
			dao.selectData(req.getParameter("mb_id"));
			
			
			url = "/talent/searchMember_ok.jsp";
			forward(req, resp, url);
		}else if (uri.indexOf("login.do") != -1) {
			
			url = "/talent/login.jsp";
			forward(req, resp, url);
			
		}else if (uri.indexOf("login_ok.do") != -1) {
			
			String mb_id = req.getParameter("mb_id");
			String mb_pw = req.getParameter("mb_pw");
			
			TalentDTO dto = dao.getReadMember(mb_id);
			
			String str = "";
			
			if(dto==null){
				
				str="아이디가 존재 하지 않습니다.";
				req.setAttribute("result",str);
				url = "/talent/login.jsp";
				forward(req, resp, url);
				
			}else if(!dto.getMb_pw().equals(mb_pw)){//아이디 존재시 비밀번호 판별
				
				str = "비밀번호가 틀립니다.";
				req.setAttribute("result",str);
				url = "/talent/login.jsp";
				forward(req, resp, url);
				
			}
				
			str = "로그인 성공!";	
			req.setAttribute("result",str);
		
			HttpSession session = req.getSession(true);
			
			MemberSession mbs = new MemberSession();
			
			mbs.setMb_id(dto.getMb_id());
			mbs.setMb_pw(dto.getMb_pw());
			mbs.setMb_nickName(dto.getMb_nickName());
			
			session.setAttribute("session", mbs);
			
			url = cp + "/choi/test.do";
			resp.sendRedirect(url);
			
			
		
		}else if (uri.indexOf("updateMember.do") != -1) {
			
			url = "/talent/updateMember.jsp";
			forward(req, resp, url);
			
		}else if (uri.indexOf("updateMember_ok.do") != -1) {
					
			TalentDTO dto = new TalentDTO();

			
			String mb_id = req.getParameter("mb_id");
			String mb_pw = req.getParameter("mb_pw");
			String mb_pw1 = req.getParameter("mb_pw1");
			String mb_pw2 = req.getParameter("mb_pw2");
			String mb_tel = req.getParameter("mb_tel");
			String mb_nickName = req.getParameter("mb_nickName");
			String mb_pic = req.getParameter("mb_pic");
			String mb_about = req.getParameter("mb_about");
						
			String str = "";
			
			String mb_pw_r = dao.login(mb_id);
			
			if(!mb_pw.equals(mb_pw_r)){
				str = "비밀번호가 틀립니다.";
				req.setAttribute("str", str);
				url = "/talent/updateMember.jsp";
				forward(req, resp, url); 
				
			}else if(!mb_pw1.equals(mb_pw2)){
				
				str = "비밀번호를 확인해 주세요.";
				req.setAttribute("str", str);
				url = "/talent/updateMember.jsp";
				forward(req, resp, url); 
				
			}else{
				
				dto.setMb_id(mb_id);
				dto.setMb_pw(mb_pw1);
				dto.setMb_tel(mb_tel);
				dto.setMb_pic(mb_pic);
				dto.setMb_about(mb_about);
				dto.setMb_nickName(mb_nickName);
				
				dao.updateMember(dto);
			
				url = cp + "/choi/test.do";
				resp.sendRedirect(url);
				
			}
			
			
			
		}else if (uri.indexOf("logout.do") != -1) {
			
			HttpSession session = req.getSession();
			
			session.removeAttribute("session");
			session.invalidate();
			
			url = "choi/test.do";
			resp.sendRedirect(url);
			
		}else if (uri.indexOf("deleteMember.do") != -1) {
			
			HttpSession session = req.getSession();
			
			MemberSession mbs = (MemberSession)session.getAttribute("session");
			
			dao.deleteMember(mbs.getMb_id());
	
			session.removeAttribute("session");
			session.invalidate();
			
			url = "choi/test.do";
			resp.sendRedirect(url);
		}

	}

}































