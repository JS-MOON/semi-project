//package com.talent;
//
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.fileTest.FileTestDAO;
//import com.oreilly.servlet.MultipartRequest;
//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
//import com.util.DBConn;
//import com.util.FileManager;
//
//public class TalentServlet extends HttpServlet{
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//
//	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url)
//			throws ServletException, IOException {
//		RequestDispatcher rd = req.getRequestDispatcher(url);
//		rd.forward(req, resp);
//	}
//
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//
//		//�ѱ�ó��
//		req.setCharacterEncoding("UTF-8");
//
//		//study���� ���
//		String cp = req.getContextPath();
//
//		//DB����
//		Connection conn = DBConn.getConnection();
//		TalentDAO dao = new TalentDAO(conn);
//		FileManager file = new FileManager();
//
//
//		//����ڰ� �ּ�â�� �Է��� �ּ�(study���� �ּ�)
//		String uri = req.getRequestURI();
//
//		//forward�Ҷ� ���� �ּ�(�ڵ��ϰ� ��� ���� �ּ�)
//		String url;
//
//
//		/////////////////////////////�̹������� ���ε�///////////////////////////////////
//
//		//������ ������ ���
//		//D:\java\work\.metadata\.plugins\org.eclipse.wst.server.core\tmp3\wtpwebapps\study ���
//		String root = getServletContext().getRealPath("/");
//		//separator(�ݸ�,�и�) == \
//		//D:\java\work\.metadata\.plugins\org.eclipse.wst.server.core\tmp3\wtpwebapps\study\pbs\saveFile ���
//		String path = root + File.separator + "pds" + File.separator + "imageFile";
//
//
//		if(uri.indexOf("sell.do")!=-1){
//
//
//			url = "/talent/sell.jsp";//�����ּ�
//			forward(req, resp, url);
//
//
//		}else if(uri.indexOf("sell_ok.do")!=-1){
//
//			TalentDTO dto = new TalentDTO();
//
//
//
//			File dir = new File(path);
//			if(!dir.exists()){//path ��� ������
//				dir.mkdirs();	//���� ������
//			}
//
//			String encType = "UTF-8";
//			int maxSize = 5*1024*1024; //5mb
//
//			//������ ������ ���ε�
//			MultipartRequest mr =
//					new MultipartRequest(req, path, maxSize, encType,
//							new DefaultFileRenamePolicy());//req,���,���ϻ�����,�ؽ�Ʈ����
//
//
//			//���ε��� ������ �����Ұ�� DB�� ���������� ����
//			if(mr.getFile("ts_mainPhoto")!=null){
//
//				String ts_options = mr.getParameter("options")+","+mr.getParameter("money");
//
//				dto.setMb_id(mr.getParameter("mb_id"));
//				dto.setTs_num(dao.getMaxNum()+1);
//				dto.setTs_options(ts_options);
//				dto.setTs_price(Integer.parseInt(mr.getParameter("ts_price")));
//				dto.setTs_mainPhoto(mr.getOriginalFileName("ts_mainPhoto"));
//				dto.setTs_morePhoto(mr.getOriginalFileName("ts_morePhoto"));
//
//				//tosell ���̺� insert
//				dao.ts_Insert(dto);
//
//			}
//
//
//			int br_MaxNum = dao.br_MaxNum();
//
//			dto.setBr_num(br_MaxNum+1);
//
//			dto.setBr_subject(mr.getParameter("br_subject"));
//
//			//board ���̺� insert
//			dao.ts_Board(dto);
//
//			url = cp + "/market/list.do";//�����ּ�
//			resp.sendRedirect(url);
//
//		}else if(uri.indexOf("list.do")!=-1){
//
//
//
//
//
//			List<TalentDTO> lists = dao.list();
//
//			req.setAttribute("lists", lists);
//
//
//
//
//
//
//
//			url = "/talent/list.jsp";//�����ּ�
//			forward(req, resp, url);
//
//
//		}else if(uri.indexOf("delete.do")!=-1){
//			//board�� �����ϰ� tosell�� �����ϰ� ���ε��� ���ϵ� �����ؾߵ�
//
//			int br_num = Integer.parseInt(req.getParameter("br_num"));
//
//
//
//			//tosell - board �����ϴ� ts_num select
//			int ts_num = dao.getTsnum(br_num);
//
//
//
//			//board�Խ��� ������ ����
//			dao.br_delete(br_num);
//
//			//board�Խ��� ������ tosell�Խ��ǿ��� ���� ts_num ������ ����
//			dao.ts_delete(ts_num);
//
//
//			//���ε��� ���� ����
//			TalentDTO dto= dao.getReadData(ts_num);
//			System.out.println(dto.getTs_mainPhoto());
//			System.out.println(path);
//			file.doFileDelete(dto.getTs_mainPhoto(), path);
//
//
//		}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//}
