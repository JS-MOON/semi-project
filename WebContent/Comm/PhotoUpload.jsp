<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="PhotoUpload_ok.do" name="myForm" method="post" enctype="multipart/form-data">

<table>

<tr><td><input type="file" size="15" name="mbPic"/></td></tr>
<%-- <tr><td><input type="hidden" value="${sessionScope.session.mbId}" name="mbId"/></td></tr> --%> 
<tr><td><input type="submit" value="등록"/></td></tr>


</table>

</form>

</body>
</html>

























