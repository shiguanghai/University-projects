<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员首页</title>
<!-- 以下四行代码用来导入bootstrap -->
<script src="js/popper.js"></script>
<script src="js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12 col-12">
			<nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-between">
				<a class="navbar-brand" href="homepage.action">
					<span class="text-info">网络点餐系统</span></a>
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a class="nav-link" href="admin_list_user.action">用户管理</a>
					</li>
					<li class="nav-item ">
						<a class="nav-link" href="admin_list_foodtype.action">菜品分类管理</a>
					</li>
					<li class="nav-item ">
						<a class="nav-link" href="admin_list_food_page.action">菜品管理</a>
					</li>
					<li class="nav-item ">
						<a class="nav-link" href="admin_show_dc.action">查看用户点餐情况</a>
					</li>
				</ul>
				<ul class="nav justify-content-end">
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"> ${un} </a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li>
								<a class="nav-link" href="logout.action">退出登录</a>
							</li>
						</ul>
					</li>
				</ul>
			</nav>
		</div>
	</div>
</div>
	<br />
	<br />
	<br />
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h5 class="text-muted">欢迎进入后台管理员页面。</h5>
			</div>
		</div>
	</div>
</body>
</html>