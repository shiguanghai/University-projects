<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/header.jsp" %>
<div id="nav">
    <div id="navleft"><a href="film_home.action" title="个人摄影" class="nav_first">个人摄影</a></div>
    <ul>
        <li><a href="video_home.action" title="视频创作">视频创作</a></li>
        <li><a href="program_home.action" title="程序交流">程序交流</a></li>
        <li><a href="song_home.action" title="歌曲分享">歌曲分享</a></li>
        <li><a href="article_home.action" title="好文推荐">好文推荐</a></li>
        <li><a href="home.action" title="首页">返回首页</a></li>
    </ul>
</div>
<div class="topbgline"></div>
<div id="subject">
    个人摄影内容待更新，尽情期待！
    <!-- 显示大图部分 -->
    <div class="modal fade bs-example-modal-lg text-center" id="imgModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" >
        <div class="modal-dialog modal-lg" ><!-- style="display: inline-block; width: auto;" -->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                    <h4 class="modal-title" id="modalLabel"></h4>
                </div>
                <img alt="暂无图片" id="imgInModalID" src="" width="90%" >
            </div>
        </div>
    </div>
    <span><a href="javascript:void(0);" οnclick="showBigImg('fiml_images/1.JPG','1')" >查看大图</a></span>
</div>
<script language="JavaScript">
    // 查看大图
    function showBigImg( pictrue, name){
        $("#modalLabel").text(name);
        $("#imgInModalID").attr("src", getContextPath()+"/images/"+pictrue);
        $("#imgModal").modal('show');
        alert(pictrue +" "+name);
    }
    //jquery获得path路径
    function getContextPath() {
        var pathName = document.location.pathname;
        var index = pathName.substr(1).indexOf("/");
        var result = pathName.substr(0,index+1);
        return result;
    }
</script>


<%@include  file="footer.jsp"%>
