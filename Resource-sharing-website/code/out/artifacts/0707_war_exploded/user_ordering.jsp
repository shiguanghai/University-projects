<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>点餐页</title>
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
							<a class="nav-link" href="user_ordering.action">正在点餐</a>
						</li>
						<li class="nav-item ">
							<a class="nav-link" href="user_myorder.action">我的点餐</a>
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
							action="user_ordering.action" method="post">
							<div class="form-group">
								<input class="form-control mr-sm-2" type="text" name="s_fn"
									value="${s_fn}" placeholder="按菜名搜索" />
							</div>
							<div class="form-group">
								<select class="form-control mr-sm-2" name="s_se" >
									<option value ="all">所有分类</option>
								<c:forEach items="${typeList}" var="t" varStatus="vs">
									<option value ="${t.id}">${t.typename}</option>
								</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<button class="btn btn-outline-success my-2 my-sm-0"
									type="submit">搜索</button>
							</div>
						</form>
					</div>
					<form action="user_myorder.action" method="post" style="margin: 0px">
						<div class="card-body">
							<div class="table-responsive-xl">
								<table class="table table-striped table-hover table-sm">
									<thead>
										<tr>
											<th>#</th>
											<th>菜名</th>
											<th>特色</th>
											<th>主料</th>
											<th>价格</th>
											<th>分类</th>
											<th>图片</th>
											<th>点击率</th>
											<th>备注</th>
											<th>选择</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${foodList}" var="f" varStatus="vs">
										<tr>
											<th>${vs.count}</th>
											<td>${f.foodname}</td>
											<td>${f.feature}</td>
											<td>${f.material}</td>
											<td>${f.price}元</td>
											<c:if test="${f.type==1}">
												<td>家常</td>
											</c:if>
											<c:if test="${f.type==2}">
												<td>凉菜</td>
											</c:if>
											<c:if test="${f.type==3}">
												<td>主食</td>
											</c:if>
											<c:if test="${f.type==4}">
												<td>饮品</td>
											</c:if>
											<td><img src="${f.picture }"></td>
											<td>${f.hits}</td>
											<c:if test="${f.comment==0}">
												<td>厨师推荐</td>
											</c:if>
											<c:if test="${f.comment==-1}">
												<td></td>
											</c:if>
											<c:if test="${f.comment!=0&&f.comment!=-1}">
												<td>特价${f.comment}元</td>
											</c:if>
											<td><input type="checkbox" name="car" value="${f.id}"></td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<button type="submit" class="btn btn-md btn-success btn-block">将菜品添加到点餐车</button>
						</div>
					</form>
					<div class="row">
						<div class="col-md-3">
						</div>
						<div class="col-md-3">
						</div>
						<div class="col-md-3">
						</div>
						<div class="col-md-3">
							<nav>
								<ul class="pagination">
									<li class="page-item">
										<a class="page-link" href="#">&lt;</a>
									</li>
									<li class="page-item">
										<a class="page-link" href="#">1</a>
									</li>
									<li class="page-item">
										<a class="page-link" href="#">2</a>
									</li>
									<li class="page-item">
										<a class="page-link" href="#">3</a>
									</li>
									<li class="page-item">
										<a class="page-link" href="#">4</a>
									</li>
									<li class="page-item">
										<a class="page-link" href="#">5</a>
									</li>
									<li class="page-item">
										<a class="page-link" href="#">&gt;</a>
									</li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--ending row-->
	</div>


</body>
</html>