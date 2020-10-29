<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户首页</title>
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
                                <a class="nav-link"  id="modal-ziliao" href="#ziliao" role="button" class="btn" data-toggle="modal">个人资料 <span class="sr-only">(current)</span></a>
                            </li>
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
            <h5 class="text-muted">欢迎进入用户页面。</h5>
        </div>
    </div>
</div>

<div class="modal fade" id="ziliao" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="myModalLabe2">
                    资料修改
                </h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="user_modify_do.action?un=${un}" method="post">
                    <div class="form-group row">
                        <label for="setPw" class="col-sm-2 col-form-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="setPw" name="password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="setTel" class="col-sm-2 col-form-label">电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="setTel" name="telephone">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="setLoc" class="col-sm-2 col-form-label">地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="setLoc" name="address">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                            取消
                        </button>
                        <button type="submit" class="btn btn-primary">
                            保存
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
