<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
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
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-0"></div>
			<div class="col-md-8 col-12">
				<div class="card border-warning">
					<div class="card-header border-warning bg-warning">
						<h5 class="text-center">修 改 菜 品 名 称</h5>
					</div>
					<form role="form" method="post" action="admin_edit_foodtype_do.action">
						<input type="hidden" name="id" value="${ftype.id}">
						<div class="card-body">
							<div class="form-group">
								<label form="foodname">菜品分类名称</label> <input type="text"
									class="form-control" name="ft" id="typename"
									required="required" value="${ftype.typename}" />
							</div>			
						</div>
						<div class="card-footer border-warning text-center">
							<button type="submit" class="btn btn-warning">确认修改</button>
							&nbsp;&nbsp; <a role="button" class="btn btn-default"
								href="javascript:history.back();">放弃返回</a>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-2 col-0"></div>
		</div>
		<!--ending 2th row-->
	</div>
</body>
</html>