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
					<form action="user_myorder_delate.action" method="post" style="margin: 0px">
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
										<c:forEach items="${carList}" var="c" varStatus="vs">
										<tr>
											<th>${vs.count}</th>
											<td>${c.foodname}</td>
											<td>${c.feature}</td>
											<td>${c.material}</td>
											<td>${c.price}元</td>
											<c:if test="${c.type==1}">
												<td>家常</td>
											</c:if>
											<c:if test="${c.type==2}">
												<td>凉菜</td>
											</c:if>
											<c:if test="${c.type==3}">
												<td>主食</td>
											</c:if>
											<c:if test="${c.type==4}">
												<td>饮品</td>
											</c:if>
											<td><img src="${c.picture }"></td>
											<td>${c.hits}</td>
											<c:if test="${c.comment==0}">
												<td>厨师推荐</td>
											</c:if>
											<c:if test="${c.comment==-1}">
												<td></td>
											</c:if>
											<c:if test="${c.comment!=0&&c.comment!=-1}">
												<td>特价${c.comment}元</td>
											</c:if>
											<td><input type="checkbox" value="${c.id}" name="delcar"></td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<button type="submit" class="btn btn-md btn-danger btn-block">将菜品从点餐车删除</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--ending row-->
	</div>


</body>
</html>