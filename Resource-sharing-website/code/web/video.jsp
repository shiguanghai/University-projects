<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/header.jsp" %>
<div id="nav">
    <div id="navleft"><a href="video_home.action" title="视频创作" class="nav_first">视频创作</a></div>
    <ul>
        <li><a href="film_home.action" title="个人摄影">个人摄影</a></li>
        <li><a href="program_home.action" title="程序交流">程序交流</a></li>
        <li><a href="song_home.action" title="歌曲分享">歌曲分享</a></li>
        <li><a href="article_home.action" title="好文推荐">好文推荐</a></li>
        <li><a href="home.action" title="首页">返回首页</a></li>
    </ul>
</div>
<div class="topbgline"></div>
<div id="subject">
    <div class="container-fluid" style="background: #ffffff40">
        <div class="row">
            <div class="navtitle">
                <a href="javascript:void(0);">
                    <img src="img/tuijian.png" alt="" class="icon">
                </a>
                <span class="cate-title" style="float: left">  推荐</span>
                <a class="cate-title" href="javascript:void(0);" style="float: right"> 更多  > </a>
            </div>
            <div class="row" style="margin: 0">
                <c:forEach items="${video_tuijian}" var="v_t" varStatus="vi_t">
                    <c:if test="${vi_t.count<=6}">
                        <div class="col-md-2 col-sm-2" style="padding: 2px 5px 5px 5px;">
                            <a href="javascript:void(0);" title="${v_t.video_name}" onclick="showBigVideo('${v_t.iframe}')">
                                <img alt="图片出错了" src="${v_t.url}" class="rounded" style="width: 190px; height: 115px" />
                                <div class="carousel-caption" style="padding: 0;background: #1919195c; bottom: 10px;width: 190px">
                                    <p style="font-size: 14px; margin-bottom: 0px">
                                            ${v_t.video_name}
                                    </p>
                                </div>
                            </a>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="row" style="margin: 0">
                <c:forEach items="${video_tuijian}" var="v_t" varStatus="vi_t">
                    <c:if test="${vi_t.count>6}">
                        <div class="col-md-2 col-sm-2" style="padding: 5px 5px 2px 5px;">
                            <a href="javascript:void(0);" title="${v_t.video_name}" onclick="showBigVideo('${v_t.iframe}')">
                                <img alt="图片出错了" src="${v_t.url}" class="rounded" style="width: 190px; height: 115px" />
                                <div class="carousel-caption" style="padding: 0;background: #1919195c; bottom: 10px">
                                    <p style="font-size: 14px; margin-bottom: 0px">
                                            ${v_t.video_name}
                                    </p>
                                </div>
                            </a>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
    <br>
    <div class="container-fluid" style="background: #ffffff40">
        <div class="row">
            <div class="navtitle">
                <a href="javascript:void(0);">
                    <img src="img/remen.png" alt="" class="icon">
                </a>
                <span class="cate-title" style="float: left">  热门</span>
                <a class="cate-title" href="javascript:void(0);" style="float: right"> 更多  > </a>
            </div>
            <div class="row" style="margin: 0">
                <c:forEach items="${video_remen}" var="v_r" varStatus="vi_r">
                    <c:if test="${vi_r.count<=6}">
                        <div class="col-md-2 col-sm-2" style="padding: 0 5px 5px 5px;">
                            <a href="javascript:void(0);" title="${v_r.video_name}" onclick="showBigVideo('${v_r.iframe}')">
                                <img alt="图片出错了" src="${v_r.url}" class="rounded" style="width: 190px; height: 115px" />
                                <div class="carousel-caption" style="padding: 0;background: #1919195c; bottom: 10px">
                                    <p style="font-size: 14px; margin-bottom: 0px">
                                            ${v_r.video_name}
                                    </p>
                                </div>
                            </a>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="row" style="margin: 0">
                <c:forEach items="${video_remen}" var="v_r" varStatus="vi_r">
                    <c:if test="${vi_r.count>6}">
                        <div class="col-md-2 col-sm-2" style="padding: 5px 5px 0 5px;">
                            <a href="javascript:void(0);" title="${v_r.video_name}" onclick="showBigVideo('${v_r.iframe}')">
                                <img alt="图片出错了" src="${v_r.url}" class="rounded" style="width: 190px; height: 115px" />
                                <div class="carousel-caption" style="padding: 0;background: #1919195c; bottom: 10px">
                                    <p style="font-size: 14px; margin-bottom: 0px">
                                            ${v_r.video_name}
                                    </p>
                                </div>
                            </a>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
    <br>
    <c:forEach items="${typelist}" var="t" varStatus="ty">
        <div class="container-fluid" style="background: #ffffff40">
            <div class="row">
                <div class="navtitle">
                    <a href="javascript:void(0);">
                        <img src="${t.picture}" alt="" class="icon">
                    </a>
                    <span class="cate-title" style="float: left">${t.typeName}</span>
                    <a class="cate-title" href="javascript:void(0);" style="float: right"> 更多  > </a>
                </div>
                <div class="row" style="margin: 0">
                    <c:forEach items="${t.videoList}" var="v_list" varStatus="vi_list">
                        <div class="col-md-2 col-sm-2" style="padding: 0 5px 5px 5px;">
                            <a href="" title="${v_list.videoName}" onclick="showBigVideo('${v_list.iframe}')">
                                <img alt="图片出错了" src="${v_list.url}" class="rounded" style="width: 190px; height: 115px" />
                                <div class="carousel-caption" style="padding: 0;background: #1919195c; bottom: 10px">
                                    <p style="font-size: 14px; margin-bottom: 0px">
                                            ${v_list.videoName}
                                    </p>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <br>
    </c:forEach>






</div>


<%@include  file="footer.jsp"%>

