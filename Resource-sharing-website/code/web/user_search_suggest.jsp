<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/user_header.jsp" %>
<div style="width: 1200px; margin: auto">
    <div class="row" style="width: 1012px; margin-left: 110px">
        <div class="col-md-12" style="padding: 0">
            <div class="span8">
                <ul class="nav nav-pills nav-justified" style="font-size: 16px; width: 980px; margin-bottom: 5px;">
                    <li class="nav-item"><a href="#zonghe" class="nav-link active" data-toggle="tab">综合</a></li>
                    <li class="nav-item"><a href="#shipin" class="nav-link" data-toggle="tab">视频</a></li>
                    <li class="nav-item"><a href="#sheying" class="nav-link" data-toggle="tab">摄影</a></li>
                    <li class="nav-item"><a href="#chengxu" class="nav-link" data-toggle="tab">程序</a></li>
                    <li class="nav-item"><a href="#gequ" class="nav-link" data-toggle="tab">歌曲</a></li>
                    <li class="nav-item"><a href="#haowen" class="nav-link" data-toggle="tab">好文</a></li>
                </ul>
                <div class="topbgline" style="width: 980px; margin-bottom: 10px; margin-left: 0"></div>
                <div class="tab-content">
                    <div class="tab-pane active" id="zonghe">
                        <c:if test="${not empty search_result}">
                            <ul class="nav nav-pills" style="font-size: 12px; margin-bottom: 10px; width: 980px">
                                <li class="nav-item"><a href="#" class="nav-link active" data-toggle="tab">综合排序</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" data-toggle="tab">最多点击</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" data-toggle="tab">最新发布</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" data-toggle="tab">最多收藏</a></li>
                            </ul>
                            <ul class="nav nav-pills" style="font-size: 12px; margin-bottom: 10px; width: 980px">
                                <li class="nav-item"><a href="#" class="nav-link active" onclick="type_search_update(0)" data-toggle="tab">全部分区</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(1)" data-toggle="tab">数码</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(2)" data-toggle="tab">旅行</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(3)" data-toggle="tab">摄影</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(4)" data-toggle="tab">科技</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(5)" data-toggle="tab">搞笑</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(6)" data-toggle="tab">舞蹈</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(7)" data-toggle="tab">科普</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(8)" data-toggle="tab">美食</a></li>
                            </ul>
                            <div class="topbgline" style="width: 980px; margin-left: 0"></div>
                            <div class="search_subject">
                                <div class="row" style="margin: 0">
                                    <ul class="col-md-12 col-sm-12 search_suggest_type" style="padding: 0">
                                        <c:forEach items="${search_result}" var="s" varStatus="s_r">
                                            <li style="float: left; margin-right:32px; margin-top: 20px; border: 1px solid #e5e9ef;">
                                                <a href="javascript:void(0);" title="${s.video_name}"  onclick="showBigVideo('${s.iframe}')">
                                                    <img alt="图片出错了" src="${s.url}" class="rounded" style="width: 168px; height: 100px" />
                                                    <div style="width: 168px; height: 58px; padding: 8px 10px 0; background: #fff">
                                                        <div style="margin-bottom: 12px; height: 40px; overflow: hidden">
                                                            <p style="font-size: 14px; margin-bottom: 0px">
                                                                    ${s.video_name}
                                                            </p>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${empty search_result}">
                            <div class="search_subject">
                                <div style="width: 980px; height: 442px; margin-left: 0; margin-top: 15px">
                                    <div class="error-wrap">
                                        <p style="font-size: 25px">
                                            没有相关数据
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </div>
                    <div class="tab-pane" id="shipin">
                        <c:if test="${not empty search_result}">
                            <ul class="nav nav-pills" style="font-size: 12px; margin-bottom: 10px; width: 980px">
                                <li class="nav-item"><a href="#" class="nav-link active" data-toggle="tab">综合排序</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" data-toggle="tab">最多点击</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" data-toggle="tab">最新发布</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" data-toggle="tab">最多收藏</a></li>
                            </ul>
                            <ul class="nav nav-pills" style="font-size: 12px; margin-bottom: 10px; width: 980px">
                                <li class="nav-item"><a href="#" class="nav-link active" onclick="type_search_update(0)" data-toggle="tab">全部分区</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(1)" data-toggle="tab">数码</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(2)" data-toggle="tab">旅行</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(3)" data-toggle="tab">摄影</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(4)" data-toggle="tab">科技</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(5)" data-toggle="tab">搞笑</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(6)" data-toggle="tab">舞蹈</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(7)" data-toggle="tab">科普</a></li>
                                <li class="nav-item"><a href="#" class="nav-link" onclick="type_search_update(8)" data-toggle="tab">美食</a></li>
                            </ul>
                            <div class="topbgline" style="width: 980px; margin-left: 0"></div>
                            <div class="search_subject">
                                <div class="row" style="margin: 0">
                                    <ul class="col-md-12 col-sm-12 search_suggest_type" style="padding: 0">
                                        <c:forEach items="${search_result}" var="s" varStatus="s_r">
                                            <li style="float: left; margin-right:32px; margin-top: 20px; border: 1px solid #e5e9ef;">
                                                <a href="javascript:void(0);" title="${s.video_name}"  onclick="showBigVideo('${s.iframe}')">
                                                    <img alt="图片出错了" src="${s.url}" class="rounded" style="width: 168px; height: 100px" />
                                                    <div style="width: 168px; height: 58px; padding: 8px 10px 0; background: #fff">
                                                        <div style="margin-bottom: 12px; height: 40px; overflow: hidden">
                                                            <p style="font-size: 14px; margin-bottom: 0px">
                                                                    ${s.video_name}
                                                            </p>
                                                        </div>
                                                    </div>
                                                </a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${empty search_result}">
                            <div class="search_subject">
                                <div style="width: 980px; height: 442px; margin-left: 0; margin-top: 15px">
                                    <div class="error-wrap">
                                        <p style="font-size: 25px">
                                            没有相关数据
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </div>
                    <div class="tab-pane" id="sheying">
                        <div class="search_subject">
                            <div style="width: 980px; height: 442px; margin-left: 0; margin-top: 15px">
                                <div class="error-wrap">
                                    <p style="font-size: 25px">
                                        没有相关数据
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="chengxu">
                        <div class="search_subject">
                            <div style="width: 980px; height: 442px; margin-left: 0; margin-top: 15px">
                                <div class="error-wrap">
                                    <p style="font-size: 25px">
                                        没有相关数据
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="gequ">
                        <div class="search_subject">
                            <div style="width: 980px; height: 442px; margin-left: 0; margin-top: 15px">
                                <div class="error-wrap">
                                    <p style="font-size: 25px">
                                        没有相关数据
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="haowen">
                        <div class="search_subject">
                            <div style="width: 980px; height: 442px; margin-left: 0; margin-top: 15px">
                                <div class="error-wrap">
                                    <p style="font-size: 25px">
                                        没有相关数据
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>




<%@include  file="user_footer.jsp"%>
