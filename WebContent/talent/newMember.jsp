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

<script type="text/javascript">

	function sendIt(){
	
	var f = document.myForm;
	
	if(document.myForm.mb_id.value==""){
		alert("id를 입력하세요");
		f.mb_id.focus();
		return;
	}
	
	if(document.myForm.mb_pw.value==""){
		alert("비밀번호를 입력하세요");
		f.mb_pw.focus();
		return;
	}
	f.action = "<%=cp%>/choi/newMember_ok.do";
	f.submit();
}


</script>

</head>
<body>
	
	<form action="" name="myForm">
	<table>
	
	<tr>
		<td>아이디 :</td>
		<td><input type="text" name="mb_id" maxlength="26" size="26"></td>
	</tr>	
	<tr>
		<td>비밀번호 :</td>
		<td><input type="text" name="mb_pw" maxlength="16" size="20"></td>
	</tr>
	
	<tr><td><input type="button" value="완료" onclick="sendIt();"></td></tr>
	
	
	
	</table>
	
	</form>



</body>
</html>

























