<%--
  Created by IntelliJ IDEA.
  User: JS
  Date: 2014-12-01
  Time: 오후 8:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<head>
    <title></title>
</head>
<body>

<form method="post" action="./Register_ok.do" name="myForm">
</form>
<%
    out.print("<script language=\"javascript\">\n" +
            "     window.onload = function() {\n" +
            "         alert(\"" + request.getAttribute("str") +  "\");\n" +
            "         document.myForm.submit();\n" +
            "    }\n" +
            "</script>\n");
%>

</body>
</html>
