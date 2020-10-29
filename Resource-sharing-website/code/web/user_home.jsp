<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/user_header.jsp" %>
<div id="nav">
    <div id="navleft"><a href="user_home.action" title="首页" class="nav_first">小屋主题分类</a></div>
    <ul>
        <li><a href="user_video_home.action" title="视频创作">视频创作</a></li>
        <li><a href="user_film_home.action" title="个人摄影">个人摄影</a></li>
        <li><a href="user_program_home.action" title="程序交流">程序交流</a></li>
        <li><a href="user_song_home.action" title="歌曲分享">歌曲分享</a></li>
        <li><a href="user_article_home.action" title="好文推荐">好文推荐</a></li>
    </ul>
</div>
<div class="topbgline"></div>
<div id="subject">
    <div class="container-fluid" style="background: #ffffff40">
        <div class="row">
            <div class="col-md-5 col-sm-5" style="padding: 0">
                <div class="carousel slide" id="carousel-246995"  data-interval="5000">
                    <ol class="carousel-indicators">
                        <li data-slide-to="0" data-target="#carousel-246995">
                        </li>
                        <li data-slide-to="1" data-target="#carousel-246995" class="active">
                        </li>
                        <li data-slide-to="2" data-target="#carousel-246995">
                        </li>
                    </ol>
                    <div class="carousel-inner">
                        <c:forEach items="${carousel}" var="c" varStatus="ca">
                            <c:if test="${ca.count==1}">
                                <div class="carousel-item active carousel-item-left">
                                    <a href="javascript:void(0);" title="${c.carousel}" onclick="showBigVideo('${c.iframe}')">
                                        <img class="d-block w-100" alt="图片出错了" src="${c.url}" class="rounded" style="width: 500px; height: 281px"/>
                                        <div class="carousel-caption">
                                            <p style="background: #1919195c">
                                                    ${c.carousel}
                                            </p>
                                        </div>
                                    </a>
                                </div>
                            </c:if>
                            <c:if test="${ca.count==2}">
                                <div class="carousel-item carousel-item-next carousel-item-left">
                                    <a href="javascript:void(0);" title="${c.carousel}" onclick="showBigVideo('${c.iframe}')">
                                        <img class="d-block w-100" alt="图片出错了" src="${c.url}" class="rounded" style="width: 500px; height: 281px"/>
                                        <div class="carousel-caption">
                                            <p style="background: #1919195c">
                                                    ${c.carousel}
                                            </p>
                                        </div>
                                    </a>
                                </div>
                            </c:if>
                            <c:if test="${ca.count==3}">
                                <div class="carousel-item">
                                    <a href="javascript:void(0);" title="${c.carousel}" onclick="showBigVideo('${c.iframe}')">
                                        <img class="d-block w-100" alt="图片出错了" src="${c.url}" class="rounded" style="width: 500px; height: 281px"/>
                                        <div class="carousel-caption">
                                            <p style="background: #1919195c">
                                                    ${c.carousel}
                                            </p>
                                        </div>
                                    </a>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                    <a class="carousel-control-prev" href="#carousel-246995" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a>
                    <a class="carousel-control-next" href="#carousel-246995" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
                </div>
            </div>
            <div class="col-md-7">
                <div class="row">
                    <c:forEach items="${video}" var="v" varStatus="vi">
                        <c:if test="${vi.count<=3}">
                            <div class="col-md-4 col-sm-4" style="padding: 0 0 5px 15px">
                                <a href="javascript:void(0);" title="${v.video_name}" onclick="showBigVideo('${v.iframe}')">
                                    <img alt="图片出错了" src="${v.url}" class="rounded" style="width: 218px; height: 135px" />
                                    <div class="carousel-caption" style="padding: 0;background: #1919195c">
                                        <p style="font-size: 14px; margin-bottom: 0px">
                                                ${v.video_name}
                                        </p>
                                    </div>
                                </a>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="row">
                    <c:forEach items="${video}" var="v" varStatus="vi">
                        <c:if test="${vi.count>3}">
                            <div class="col-md-4 col-sm-4" style="padding: 5px 0 0 15px">
                                <a href="javascript:void(0);" title="${v.video_name}" onclick="showBigVideo('${v.iframe}')">
                                    <img alt="图片出错了" src="${v.url}" class="rounded" style="width: 218px; height: 135px" />
                                    <div class="carousel-caption" style="padding: 0;background: #1919195c">
                                        <p style="font-size: 14px; margin-bottom: 0px">
                                                ${v.video_name}
                                        </p>
                                    </div>
                                </a>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <br><br>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-8" style="background: #ffffff7a">
                <h2>
                    欢迎来到时光海小屋
                </h2>
                <p>
                    一个致力基于热门资源网站发展资源分享的小屋，小伙伴可以在这里交换分享自己喜欢的资源，再也不用因寻找不到新鲜资源而烦恼，在这里我们都是一家人.
                </p>
                <p style="background: #aeaeae8a; margin: 0">
                    <a class="btn" href="#">了解更多 »</a>
                </p>
                <div class="media" style="background: #959494b0">
                    <c:forEach items="${film_left}" var="f_l" varStatus="fi_l">
                        <c:if test="${fi_l.count==1}">
                            <img class="mr-3" alt="图片出错了" src="${f_l.url}" style="width: 64px; height: 64px"/>
                        </c:if>
                    </c:forEach>
                    <div class="media-body">
                        <h5 class="mt-0">
                            在这里
                        </h5> 你可以晒出自己珍藏的照片，和大家一起分享，你会发现一些随意的人和日常物品的照片，就像你的朋友跟你分享他的照片一样，拿起你的相机和大家一起记录生活吧，希望我们都能主动去发现生活中的美好.
                        <div class="media mt-3">
                            <c:forEach items="${film_left}" var="f_l" varStatus="fi_l">
                                <c:if test="${fi_l.count==2}">
                                    <a class="pr-3" href="${f_l.address}">
                                        <img alt="图片出错了" src="${f_l.url}" style="width: 64px; height: 64px"/>
                                    </a>
                                </c:if>
                            </c:forEach>
                            <div class="media-body">
                                <h5 class="mt-0">
                                    在这里
                                </h5> 你也可以分享你喜爱的其他网站的照片，在征求作者同意的前提下，和大家一起分享吧，不同爱好的朋友相聚在此，成为共同的伙伴，时光静好，我在这里等你……
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="row">
                    <c:forEach items="${film}" var="f" varStatus="fi">
                        <c:if test="${fi.count==1}">
                            <div class="col-md-6 col-sm-6" style="padding: 0 7px 5px 10px">
                                <a href="${f.address}" title="${f.film_author}" onclick="showBigImg('${f.url}','${f.film_author}')">
                                    <img alt="图片出错了" src="${f.url}" class="img-thumbnail" style="height: 120px; width: 185px; background-color: #c8c4c4; border: 1px solid #7e7d7d;"/>
                                </a>
                            </div>
                        </c:if>
                        <c:if test="${fi.count==2}">
                            <div class="col-md-6 col-sm-6" style="padding: 0 2px 5px 7px">
                                <a href="${f.address}" title="${f.film_author}" onclick="showBigImg('${f.url}','${f.film_author}')">
                                    <img alt="图片出错了" src="${f.url}" class="img-thumbnail" style="height: 120px; width: 185px; background-color: #c8c4c4; border: 1px solid #7e7d7d;"/>
                                </a>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="row">
                    <c:forEach items="${film}" var="f" varStatus="fi">
                        <c:if test="${fi.count==3}">
                            <div class="col-md-4 col-sm-4" style="padding: 5px 5px 5px 10px">
                                <a href="${f.address}" title="${f.film_author}" onclick="showBigImg('${f.url}','${f.film_author}')">
                                    <img alt="图片出错了" src="${f.url}" class="img-thumbnail" style="height: 120px; width: 120px; background-color: #c8c4c4; border: 1px solid #7e7d7d;"/>
                                </a>
                            </div>
                        </c:if>
                        <c:if test="${fi.count==4}">
                            <div class="col-md-4 col-sm-4" style="padding: 5px 7px 5px 7px">
                                <a href="${f.address}" title="${f.film_author}" onclick="showBigImg('${f.url}','${f.film_author}')">
                                    <img alt="图片出错了" src="${f.url}" class="img-thumbnail" style="height: 120px; width: 120px; background-color: #c8c4c4; border: 1px solid #7e7d7d;"/>
                                </a>
                            </div>
                        </c:if>
                        <c:if test="${fi.count==5}">
                            <div class="col-md-4 col-sm-4" style="padding: 5px 2px 5px 5px">
                                <a href="${f.address}" title="${f.film_author}" onclick="showBigImg('${f.url}','${f.film_author}')">
                                    <img alt="图片出错了" src="${f.url}" class="img-thumbnail" style="height: 120px; width: 120px; background-color: #c8c4c4; border: 1px solid #7e7d7d;"/>
                                </a>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="row">
                    <c:forEach items="${film}" var="f" varStatus="fi">
                        <c:if test="${fi.count==6}">
                            <div class="col-md-6 col-sm-6" style="padding: 5px 7px 0 10px">
                                <a href="${f.address}" title="${f.film_author}" onclick="showBigImg('${f.url}','${f.film_author}')">
                                    <img alt="图片出错了" src="${f.url}" class="img-thumbnail" style="height: 120px; width: 185px; background-color: #c8c4c4; border: 1px solid #7e7d7d;"/>
                                </a>
                            </div>
                        </c:if>
                        <c:if test="${fi.count==7}">
                            <div class="col-md-6 col-sm-6" style="padding: 5px 2px 0 7px">
                                <a href="${f.address}" title="${f.film_author}" onclick="showBigImg('${f.url}','${f.film_author}')">
                                    <img alt="图片出错了" src="${f.url}" class="img-thumbnail" style="height: 120px; width: 185px; background-color: #c8c4c4; border: 1px solid #7e7d7d;"/>
                                </a>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <br><br>
    <div id="music">
    </div>


</div>



<%@include  file="user_footer.jsp"%>
