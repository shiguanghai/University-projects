<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	request.setAttribute("APP_PATH", request.getContextPath());
 %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>时光海小屋</title>
</head>
<body>
	${message }<a href="${APP_PATH }/validatellogin">继续新建文章</a>
</body>
</html>