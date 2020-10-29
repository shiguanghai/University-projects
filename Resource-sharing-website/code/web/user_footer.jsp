<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<br><br>

<div id="footer">
    &copy;&nbsp;2019&nbsp;ShiGuangHai&nbsp;.All Rights Reserved.&nbsp;(www.shiguanghai.top)<br>
    如有疑问请发送邮件到：1932275668@qq.com<br>
    <a href="http://www.beian.miit.gov.cn">豫ICP备19026848号</a>
</div>


<!-- 显示大图部分 -->
<div class="modal fade bs-example-modal-lg text-center" id="imgModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" >
    <div class="modal-dialog modal-lg" ><!-- style="display: inline-block; width: auto;" -->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalLabel"></h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <img alt="暂无图片" id="imgInModalID" src="" width="100%">
        </div>
    </div>
</div>

<!-- 显示大视频部分 -->
<div class="modal fade bs-example-modal-lg text-center" id="videoModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" >
    <div class="modal-dialog modal-lg" ><!-- style="display: inline-block; width: auto;" -->
        <div class="modal-content">
            <div class="modal-header">
                <a href="javascript:void(0);" >
                    <span style="font-size: 18px">点我收藏</span>
                    <span class="icon" id="shoucang_icon">
                        <img src="img/shoucang_0.png">
                    </span>
                </a>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close" id="video_modal">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <iframe alt="视频失效" id="videoInModalID" src="" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"
                    style="max-width: 798px; height: 560px; width: 100%;"></iframe>
        </div>
    </div>
</div>

<script language="JavaScript">
    window.onload = function () {
        var search_keyword = document.querySelector("#header_search_keyword");
        var search_suggest = document.querySelector("#search_suggest");

        search_keyword.onfocus = function () {//搜索提示获取焦点
            this.intervalID = setInterval( () => {//es6 箭头函数
                var searchKeywordValue = search_keyword.value;//获取搜索框的值
                if(searchKeywordValue){
                    search_suggest.style.display="block";
                    $.ajax({
                        type:"POST",
                        url:"/search_submit.action",
                        data:{
                            keyword:searchKeywordValue
                        },
                        async:true,
                        dataType:"json",
                        success:function (result) {
                            var temp = "";
                            if(Object.keys(result).length === 0){//es6
                                temp += "<li class='suggest_item'>无搜索无结果！</li>"
                            }else {
                                for(var i=0;i<result.length;i++){
                                    temp += "<li class='suggest_item'><a href='user_search_suggest.action?id="+result[i].id+"' title='"+result[i].video_name+"'>"+result[i].video_name+"</a></li>"
                                }
                            }
                            search_suggest.innerHTML = temp;
                        }
                    });
                }else {
                    search_suggest.style.display="none";
                }
            },400);
        };
        search_keyword.onblur = function () {//搜索提示失去焦点
            clearInterval(this.intervalID);
            var timer = setTimeout(function () {//延迟
                search_suggest.style.display="none";
            },120);
        };
    };
    // 查看大图
    function showBigImg(pictrue, name){
        $("#modalLabel").text("作者："+name);
        $("#imgInModalID").attr("src", pictrue);
        $("#imgModal").modal('show');
        // alert(pictrue +" "+name);
    }
    // 查看大视频
    function showBigVideo(video){
        $("#videoInModalID").attr("src", "https:"+video+"&high_quality=1");
        $("#videoModal").modal('show');
        // alert(video);
    }
    //利用video原生方法pause();（关闭弹窗的时候暂停视频，注意这不是jquery方法）
    $("#video_modal").click(function(){
        $("#videoInModalID").attr("src", "");
    })
    //点击搜索图标
    function search_jump(){
        var header_search_keyword = $("input[id='header_search_keyword']").val();
        if(header_search_keyword){
            window.location.href="/user_search_suggest_keyword.action?keyword="+header_search_keyword;
        }
    }
    //搜索界面标签更新数据
    function type_search_update(type) {
        var search_suggest_type = document.querySelector(".search_suggest_type");
        var header_search_keyword = $("input[id='header_search_keyword']").val();
        if(header_search_keyword){
            $.ajax({
                type:"POST",
                url:"/search_type_update.action",
                data:{
                    keyword:header_search_keyword,
                    type:type
                },
                async:true,
                dataType:"json",
                success:function (result) {
                    var temp = "";
                    if(Object.keys(result).length === 0){//es6
                        temp += "<div class='search_subject'>" +
                            "<div style='width: 980px; height: 240px; margin-left: 0; margin-top: 15px'>" +
                            "<div class='error-wrap' style='line-height: 240px'>" +
                            "<p style='font-size: 25px'>空</p></div></div></div>"
                    }else {
                        for(var i=0;i<result.length;i++){
                            temp += "<li style='float: left; margin-right:32px; margin-top: 20px; border: 1px solid #e5e9ef;'>" +
                                "<a href='javascript:void(0);' title='"+result[i].video_name+"' onclick=\"showBigVideo('"+result[i].iframe+"')\">" +
                                "<img alt='图片出错了' src='"+result[i].url+"' class='rounded' style='width: 168px; height: 100px' />" +
                                "<div style='width: 168px; height: 58px; padding: 8px 10px 0; background: #fff'>" +
                                "<div style='margin-bottom: 12px; height: 40px; overflow: hidden'>" +
                                "<p style='font-size: 14px; margin-bottom: 0px'>" +result[i].video_name+"</p></div></div></a></li>"
                        }
                    }
                    search_suggest_type.innerHTML = temp;
                }
            });
        }
    }
</script>

<!-- 点击名字 -->
<%--<div class="modal fade" id="ziliao" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title" id="myModalLabe2">--%>
<%--                    资料修改--%>
<%--                </h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal">--%>
<%--                    <span aria-hidden="true">×</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <form action="user_modify_do.action?un=${un}" method="post">--%>
<%--                    <div class="form-group row">--%>
<%--                        <label for="setPw" class="col-sm-2 col-form-label">密码</label>--%>
<%--                        <div class="col-sm-10">--%>
<%--                            <input type="text" class="form-control" id="setPw" name="password">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group row">--%>
<%--                        <label for="setTel" class="col-sm-2 col-form-label">电话</label>--%>
<%--                        <div class="col-sm-10">--%>
<%--                            <input type="text" class="form-control" id="setTel" name="telephone">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group row">--%>
<%--                        <label for="setLoc" class="col-sm-2 col-form-label">地址</label>--%>
<%--                        <div class="col-sm-10">--%>
<%--                            <input type="text" class="form-control" id="setLoc" name="address">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="modal-footer">--%>
<%--                        <button type="button" class="btn btn-secondary" data-dismiss="modal">--%>
<%--                            取消--%>
<%--                        </button>--%>
<%--                        <button type="submit" class="btn btn-primary">--%>
<%--                            保存--%>
<%--                        </button>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

</body>
</html>
