<%@page import="com.talent.TalentDTO"%>
<%@page import="com.talent.TalentDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();	
	
	String mb_id = request.getParameter("mb_id");
		
	Connection conn = DBConn.getConnection();
	
	TalentDAO dao = new TalentDAO(conn);
	TalentDTO dto = dao.selectData(mb_id);
	
	DBConn.close();
			
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

아이디:<%=dto.getMb_id()%> pw:<%=dto.getMb_pw()%>
닉네임:<%=dto.getMb_nickName() %>

</body>
</html>

























