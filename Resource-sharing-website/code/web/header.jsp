<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<html>
<head>
    <!-- 以下四行代码用来导入bootstrap -->
    <script src="js/popper.js"></script>
    <script src="js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="icon" href="img/icon.ico" type="image/x-icon"/>
    <meta charset=UTF-8">
    <title>时光海小屋</title>
    <meta name="Viewport" content="width=device-width, initial-scale=1.0">
    <meta name="Keywords" content="shiguanghai,个人博客,时光海个人博客,个人网站,时光海,时光海小屋">
    <meta name="Description" content="这是我个人的首个博客网站，目前还在测试阶段，正在尽力完善，旨在展示个人的兴趣爱好、大学生活、以及一些软件过程专业相关的认识和理解。">
    <meta name="author" content="时光海">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
</head>
<body style="background-image:url('img/background.png');">

<div class="header">
    <ul>
        <li>
            <a href="https://space.bilibili.com/8049046" target="_blank" >
                <span class="icon"> <img src="img/bilibili.png"> </span> Bilibili</a>
        </li>
        <li>
            <a href="https://weibo.com/u/5043359825?is_all=1" target="_blank">
                <span class="icon"> <img src="img/weibo.png"> </span> Weibo</a>
        </li>
        <li>
            <a href="https://twitter.com/wang8852165" target="_blank">
                <span class="icon"> <img src="img/twitter.png" > </span> Twitter</a>
        </li>
        <li>
            <a href="https://github.com/shiguanghai" target="_blank">
                <span class="icon"> <img src="img/github.png" > </span> Github</a>
        </li>
    </ul>
</div>
<div id="header1"></div>
<div id="top">
    <div id="logo">
        <a href="home.action">
            <img src="img/logo.png" alt="">
        </a>
    </div>
    <div class="header_search_box">
        <div class="hearer_search">
            <form id="header_searchform">
                <input id="header_search_keyword" value="${search_title}" type="text" name="keyword" autocomplete="off" placeholder="在这里输入内容以查询！">
                <a id="header_searching" href="javascript:void(0);" onclick="search_jump()">
                    <div class="header_search_btn">
                        <img src="img/search.png" alt="" class="header_search_submit">
                    </div>
                </a>
            </form>
            <ul id="search_suggest" class="header_search_suggest" style="display: none">

            </ul>
        </div>
    </div>
    <div id="toptext">
        (｡･∀･)ﾉﾞ嗨！这里是时光海小屋！
        &nbsp;&nbsp;
        <a  href="#denglu" role="button" data-toggle="modal">登录</a>
        &nbsp;|&nbsp;
        <a  href="#zhuce" role="button" data-toggle="modal">注册</a>
    </div>
</div>



