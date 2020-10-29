<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>菜品分类管理</title>
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
			<div class="col-md-1 col-0"></div>
			<div class="col-md-10 col-12">
				<div class="card border">
					<div class="card-header">
						<form class="form-inline"
							action="admin_list_foodtype.action" method="post">
							<div class="form-group">
								<input class="form-control mr-sm-2" type="text" name="s_ft"
									value="${s_ft}" placeholder="按分类名搜索" />
							</div>
							<div class="form-group">
								<button class="btn btn-outline-primary my-2 my-sm-0"
										type="submit">搜索</button>
								<a class="btn btn-outline-success my-2 my-sm-0"
								   href="admin_add_foodtype.action">添加菜品分类</a>
							</div>
						</form>

					</div>
					<div class="card-body">
						<div class="table-responsive-xl">
							<table class="table table-striped table-hover table-sm">
								<thead>
									<tr>
										<th>#</th>
										<th>分类名称</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${typeList}" var="t" varStatus="vs">
									<tr>
										<th>${vs.count}</th>
										<td>${t.typename}</td>
									    <td>
										<a type="button"
												class="btn btn-sm btn-outline-warning"
												href="admin_upd_foodtype.action?id=${t.id}">修改</a>
										<a type="button"
												class="btn btn-sm btn-outline-danger"
												href="admin_del_foodtype.action?id=${t.id}">删除</a>
										</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--ending row-->
	</div>


</body>
</html>