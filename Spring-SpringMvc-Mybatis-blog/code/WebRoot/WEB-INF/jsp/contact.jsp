<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>时光海小屋</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/nav.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
   	<ul class="navul">
		<li class="navli"><a href="${APP_PATH}/">Home</a></li>
<%--		<li class="navli"><a href="https://github.com/oldbiwang">github</a></li>--%>
		<li class="navli"><a target="_blank" href="${APP_PATH }/contact">Contact me</a></li>
<%--		<li class="navli"><a target="_blank" href="${APP_PATH }/about">About me</a></li>--%>
		<li class="navli"><a target="_blank" href="${APP_PATH }/login">Login</a></li>
	</ul> 
  <h2>联系我</h2>
  <p>我们一起携手共进步</p>
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">Github</div>
      <div class="panel-body">https://github.com/shiguanghai</div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">Blog</div>
      <div class="panel-body">https://shiguanghai.top</div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">Bilibili</div>
      <div class="panel-body">https://space.bilibili.com/8049046</div>
    </div>
  </div>
  	<br></br>
	<div>
		<h3 style="text-align: center;">想对我说什么.....</h3>
		<div class="col-lg-12">
			<div class="row">
				<div class="col-md-12 form-group">
					<input class="form-control" id="name" name="name"
						placeholder="Name" type="text" required>
				</div>
			</div>
			<textarea class="form-control" id="comments" name="comment"
				placeholder="留下你的心声..." rows="8"></textarea>
			<br>
			<div class="row">
				<div class="col-lg-12 form-group">
					<button class="btn btn-success" type="submit" onclick="sendheartword(520)">Send</button>
					  <br><br>
					  <p style="text-align: center;"><a href="${APP_PATH }">
					  @2019 Shiguanghai 豫ICP备19026848号</a></p>
				</div>
			</div>
		</div>
	</div> 
</div>
<script>
	  function sendheartword(sid) {
            	$.ajax({
            		type: "post",
            		url: "${APP_PATH}/sendheartword",
            		data: {
            			id : sid,
            			name : $("#name").val(),
            			comment: $("#comments").val()
            		},
            		dataType: "json",
            		success : function(result) {
            			alert(result.msg);
            		} 
            	});
            }
</script>
</body>
</html>
