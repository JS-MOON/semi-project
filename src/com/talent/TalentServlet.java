package com.talent;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.DBConn;
import com.util.FileManager;
import com.util.ImageName;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
		String path = root + "Product";
		
		String myPath = root + File.separator + "pds" +
				File.separator + "imageFile";
		
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs();
		
		File myDir = new File(myPath);
		if(!myDir.exists())
			myDir.mkdirs();

		if (uri.contains("Register.do")) {

			String mbId = req.getParameter("mbId");
			String mbPw1 = req.getParameter("mbPw1");
			String mbPw2 = req.getParameter("mbPw2");
			String mbPic = "img_profile_img_blank_120x120.png";
			

			String str = "";

			if (dao.selectData(mbId) != null) {
				str = "아이디가 존재합니다.";
			} else if (!mbPw1.equals(mbPw2)) {
				str = "비밀번호가 일치하지 않습니다.";
			} else {

				MemberDTO dto = new MemberDTO();

				dto.setMbId(mbId);
				dto.setMbPw(mbPw1);
				dto.setMbPic(mbPic);
				dao.insertData(dto);


				str = "가입이 완료되었습니다.";
			}

			req.setAttribute("str", str);

			url = "/Register/Register.jsp";
			forward(req, resp, url);

		} else if (uri.contains("Register_ok.do")) {
			resp.sendRedirect("../");
		
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
			
			String imagePath = cp + "/pds/imageFile";

			
			HttpSession session = req.getSession();
			
			MemberSession mbs =
					(MemberSession)session.getAttribute("session");
			
			MemberDTO dto = dao.getReadMember(mbs.getMbId());
			
			req.setAttribute("dto", dto);	
			req.setAttribute("imagePath", imagePath);
 			
			
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

			
			url = "/My/SellProdReg.jsp";// �����ּ�
			forward(req, resp, url);

			
		}else if (uri.indexOf("SellProdReg.do") != -1) {

		
			url = "/My/SellProdReg.jsp";// �����ּ�
			forward(req, resp, url);


		}else if(uri.contains("PhotoUpload_ok.do")){
			
			
//			String mbId = req.getParameter("mbId");
			
			HttpSession session = req.getSession();
			
			MemberSession mbs =
					(MemberSession)session.getAttribute("session");
		
			
			String encType = "UTF-8";
			int maxSize = 5*1024*1024;
			
			MultipartRequest mr =
					new MultipartRequest(req, myPath, maxSize, encType,
							new DefaultFileRenamePolicy());
			
			if(mr.getFile("mbPic")!=null){
		
				String mbPic = mr.getFilesystemName("mbPic");
								
				dao.updateMember(mbPic,mbs.getMbId());
				
			}
			
			url = "complete.jsp";
			forward(req, resp, url);
			
		} else if (uri.indexOf("UpdateMyprofile.do") != -1) {
			
			MemberDTO dto = new MemberDTO();
			
			String mbId = req.getParameter("mbId");
			String mbNickName = req.getParameter("mbNickName");
			String mbAbout = req.getParameter("mbAbout");
			
			dto.setMbId(mbId);
			dto.setMbNickName(mbNickName);
			dto.setMbAbout(mbAbout);
			
			dao.updateMember(dto);
			
			url = "MyProfile.do";
			resp.sendRedirect(url);
			
			
		} else if (uri.indexOf("SellProdReg_ok.do") != -1) {
			
			BoardDTO dto = new BoardDTO();
			ImageName im = new ImageName();

			String encType = "UTF-8";
			int maxSize = 5 * 1024 * 1024; // 5mb

			// ������ ������ ���ε�
			MultipartRequest mr = new MultipartRequest(req, path, maxSize,
					encType, new DefaultFileRenamePolicy());// req,���,���ϻ�����,�ؽ�Ʈ����

			String fileName1 = mr.getOriginalFileName("brMainPhoto");
			String fileName2 = mr.getOriginalFileName("brMorePhoto");
			String newFileName1 = im.mainPhotoName();
			String newFileName2 = im.morePhotoName();

			if (!fileName1.equals("") && !fileName2.equals("")) {
				// ������ ���ε�� �����ο� ���ϸ� ���Ѵ�.
				String fullFileName1 = path + "/" + fileName1;
				String fullFileName2 = path + "/" + fileName2;
				File f1 = new File(fullFileName1);
				File f2 = new File(fullFileName2);
				if (f1.exists()) { // ���ε�� ���ϸ��� �����ϸ� Rename�Ѵ�.
					File newFile = new File(path + "/" + newFileName1 + ".jpg");
					f1.renameTo(newFile); // rename...
				}
				if (f2.exists()) {
					File newFile = new File(path + "/" + newFileName2 + ".jpg");
					f2.renameTo(newFile);
				}
			}

			// ���ε��� ������ �����Ұ�� DB�� ���������� ����
			if (mr.getFile("brMainPhoto") != null
					&& mr.getFile("brMorePhoto") != null) {

				String completedOption = mr.getParameter("completedOption");
				int s2 = Integer.parseInt(mr.getParameter("s2"));

				// dto���
				dto.setBrNum(dao.getMaxNum() + 1);
				dto.setMbId(mr.getParameter("mbId"));
				dto.setCgNum(s2);
				dto.setBrSubject(mr.getParameter("brSubject"));
				dto.setBrMainPhoto(newFileName1 + ".jpg");
				dto.setBrMorePhoto(newFileName2 + ".jpg");
				dto.setBrContent(mr.getParameter("brContent"));
				dto.setBrOptions(completedOption);
				dto.setBrPrice(Integer.parseInt(mr.getParameter("brPrice")));

				// board ���̺� insert
				dao.BoardInsert(dto);
			}

			url = cp + "/Goods/Main.jsp";
			resp.sendRedirect(url);
<<<<<<< HEAD
			
=======


>>>>>>> origin/master
		} else if (uri.indexOf("GList.do") != -1) {

			int start = Integer.parseInt(req.getParameter("start"));
			int end = Integer.parseInt(req.getParameter("end"));

			List<BoardDTO> lists = dao.list(start, end);
			req.setAttribute("lists", lists);


			
			
			String imagePath = cp + "/Product";

			if(1<=start && start<=14){
				start = 1;
				end =14;
			}
			if(15<= start&& start<=22){
				start = 15;
				end = 22;
			}
			if(23<=start && start<=30){
				start = 23;
				end = 30;
			}
			if(31<=start && start<=41){
				start = 31;
				end = 41;
			}
			if(42<=start && start<=50){
				start = 42;
				end = 50;
			}
			if(51<=start && start<=58){
				start = 51;
				end = 58;
			}
			if(59<=start && start<=68){
				start = 59;
				end = 68;
			}
			if(69<=start && start<=79){
				start = 69;
				end = 79;
			}
			if(80<=start && start<=90){
				start = 80;
				end = 90;
			}
			if(91<=start && start<=96){
				start = 91;
				end = 96;
			}
			if(97<=start && start<=109){
				start = 97;
				end = 109;
			}
			
			
			List<CategoryDTO> cglists = dao.getReadCategory(start, end);
			req.setAttribute("cglists", cglists);
			
			req.setAttribute("imagePath", imagePath);
			

			url = "/Goods/GList.jsp";// �����ּ�
			forward(req, resp, url);
			
		} else if (uri.indexOf("GList_ok.do") != -1) {	
		
			int cgNum = Integer.parseInt(req.getParameter("cgNum"));
			
			url = "GList.do?start=" + cgNum + "&end=" + cgNum ;
			resp.sendRedirect(url);
			
		} else if (uri.indexOf("GDetail.do") != -1) {

			int brNum = Integer.parseInt(req.getParameter("brNum"));
			
			/*List<BoardDTO> relists = dao.getReadRelation(start, end);
			req.setAttribute("relists", relists);*/
			// �Ѹ��� ������ �ҷ�����
			BoardDTO dto = dao.getReadData(brNum);
			// �ɼǹ迭 �ҷ�����
			List<String> op = dto.getBrOptionsList();

			// ī�װ� �ҷ�����
			int cgNum = dto.getCgNum();
			CategoryDTO cgdto = dao.getReadCategory(cgNum);
			String category1 = cgdto.getCgCategory1();
			String category2 = cgdto.getCgCategory2();

			// �ۿø���� �ҷ�����
			String MbId = dto.getMbId();

			// ��� �Ѹ�ã�� �޼ҵ�
			MemberDTO mbdto = dao.getReadMember(MbId);
			String nickName = mbdto.getMbNickName();
			
			dto.setBrContent(dto.getBrContent().replaceAll("\n", "<br/>"));
			String imagePath = cp + "/Product";

			//���
			List<CommentsDTO> lists = dao.cmList(brNum);
			List<CommentsDTO> newLists = new ArrayList<CommentsDTO>();
			
			

			String[] subject = new String[lists.size()];

			for (int i = 0; i < lists.size(); i++) {
				CommentsDTO cdto = new CommentsDTO();

				cdto = lists.get(i);

				String[] a = cdto.getCmContent().split("\r\n");
				subject[i] = a[0];
				cdto.setCmContent(cdto.getCmContent().replaceAll("\n", "<br/>"));
				newLists.add(cdto);
			}
			
			req.setAttribute("lists", newLists);
			req.setAttribute("subject", subject);
			
			req.setAttribute("nickName", nickName);
			req.setAttribute("category1", category1);
			req.setAttribute("category2", category2);
			req.setAttribute("op", op);
			req.setAttribute("imagePath", imagePath);
			req.setAttribute("dto", dto);

			url = "/Goods/GDetail.jsp";// �����ּ�
			forward(req, resp, url);
			
		}else if (uri.indexOf("comments_ok.do") != -1) {

			int brNum = Integer.parseInt(req.getParameter("brNum"));
			
			CommentsDTO dto = new CommentsDTO();
			
			int cmMaxNum = dao.cmMaxNum();
			dto.setCmNum(cmMaxNum + 1);

			dto.setBrNum(brNum);
			dto.setCmContent(req.getParameter("cm_content"));
			dto.setCmNickName(req.getParameter("cm_nickName"));
			dto.setCmRating(Integer.parseInt(req.getParameter("cm_rating")));

			dao.cmInsert(dto);

			url = "GDetail.do?brNum=" + brNum;
			resp.sendRedirect(url);

		}

	}

}
































