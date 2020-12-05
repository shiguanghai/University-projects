<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>时光海小屋</title>
	<link href="css/login.css" rel="stylesheet" type="text/css" />
	<!--  Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
	   		  <div class="row">
	        <div class="col-sm-6 col-md-4 col-md-offset-4">
	            <h1 class="text-center login-title">登陆界面</h1>
	            <div class="account-wall">
	                <img class="profile-img" src="images/avatar.png"
	                    alt="">
	                <form class="form-signin" action="${APP_PATH }/validatellogin" method="post">
	                <input type="text" class="form-control" placeholder="username" name="username" required autofocus>
	                <input type="password" class="form-control" placeholder="password" name="password" required>
	                <button class="btn btn-lg btn-primary btn-block" type="submit">
	                    Sign in</button>
	                <label class="checkbox pull-left">
	                    <input type="checkbox" value="remember-me">
	                    Remember me
	                </label>
	                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
	                </form>
	            </div>
	            <a href="#" class="text-center new-account">Create an account </a>
				<a href="/" class="text-center new-account">Break </a>
	        </div>
	    </div>
	</div>
</body>
</html>