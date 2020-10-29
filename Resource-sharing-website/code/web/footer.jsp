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
            window.location.href="/search_suggest_keyword.action?keyword="+header_search_keyword;
        }
    }
</script>

<!-- 登录 -->
<div class="modal fade" id="denglu" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="myModalLabel">
                    登录
                </h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="form_login" method="post">
                    <div class="form-group row">
                        <label for="staticId" class="col-sm-2 col-form-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="staticId" name="username">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword" class="col-sm-2 col-form-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="inputPassword" name="password">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                            关闭
                        </button>
                        <button type="button" id="login" class="btn btn-primary">
                            登录
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 注册 -->
<div class="modal fade" id="zhuce" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="myModalLabe2">
                    注册
                </h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="form_zhuce" method="post">
                    <div class="form-group row">
                        <label for="setId" class="col-sm-2 col-form-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="setId" name="username" maxlength="12" placeholder="请输入用户名">
                            <span id="username_result" name="username_span" style="padding: 6px 12px 0 12px"></span>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="setPw" class="col-sm-2 col-form-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="setPw" name="password" maxlength="16" placeholder="请输入6-16位数字&字母组合登录密码">
                            <span id="password_result" name="password_span" style="padding: 6px 12px 0 12px"></span>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="setTel" class="col-sm-2 col-form-label">手机号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="setTel" name="telephone" maxlength="11" placeholder="请输入11位手机号">
                            <span id="telephone_result" name="telephone_span" style="padding: 6px 12px 0 12px; color: #21A719">验证开发中...  (非必填项)</span>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="setLoc" class="col-sm-2 col-form-label">邮箱</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="setLoc" name="address" placeholder="请输入邮箱地址">
                            <span id="address_result" name="address_span" style="padding: 6px 12px 0 12px; color: #21A719">验证开发中...  (非必填项)</span>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                            关闭
                        </button>
                        <button type="button" id="register" class="btn btn-primary">
                            确定
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script language="JavaScript">
    window.onload = function () {
        var search_keyword = document.querySelector("#header_search_keyword");
        var search_suggest = document.querySelector("#search_suggest");
        var username = document.querySelector("#setId");
        var password = document.querySelector("#setPw");
        var telephone = document.querySelector("#setTel");
        var address = document.querySelector("#setLoc");

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
                                    temp += "<li class='suggest_item'><a href='search_suggest.action?id="+result[i].id+"' title='"+result[i].video_name+"'>"+result[i].video_name+"</a></li>"
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

        username.onblur = function () {//注册用户名
            var usernameValue = username.value;
            $.ajax({
                type:"POST",
                url:"/register_uname.action",
                data:{
                    uname:usernameValue
                },
                async:true,
                dataType:"text",
                success:function (result) {
                    var username_result = document.querySelector("#username_result");
                    if (result == "Yes"){
                        username_result.innerText = "用户名可以使用 √";
                        username_result.style.color = "#21A719";
                    } else if(result == "No") {
                        username_result.innerText = "用户名已被注册 ×";
                        username_result.style.color = "#9d4246";
                    } else if(result == "blank"){
                        username_result.innerText = "用户名不能为空.";
                        username_result.style.color = "#B45235";
                    }
                }
            });
        };
        password.onblur = function () {//注册密码
            var passwordValue = password.value;
            $.ajax({
                type:"POST",
                url:"/register_pword.action",
                data:{
                    pword:passwordValue
                },
                async:true,
                dataType:"text",
                success:function (result) {
                    var password_result = document.querySelector("#password_result");
                    if (result == "Yes"){
                        password_result.innerText = "密码可以使用 √";
                        password_result.style.color = "#21A719";
                    } else if(result == "No") {
                        password_result.innerText = "密码不符合规范 ×";
                        password_result.style.color = "#9d4246";
                    } else if(result == "blank"){
                        password_result.innerText = "密码不能为空.";
                        password_result.style.color = "#B45235";
                    }
                }
            });
        };
    };
    //监听注册确定按钮
    $('#register').click(function () {
        register_check();
    });
    $('#login').click(function () {
        login_check();
    });
    //监听回车，执行注册确定按钮
    $("body").keydown(function () {
        if (event.keyCode == "13"){//回车键
            $('#register').click();
            $('#login').click();
        }
    });
    //执行注册检查
    function register_check() {
        var un = $("span[name='username_span']").text();//获取span的值
        var pw = $("span[name='password_span']").text();
        if(un=="用户名可以使用 √"&&pw=="密码可以使用 √"){
            var username = $("input[name='username']").val();
            var password = $("input[name='password']").val();
            var telephone = $("input[name='telephone']").val();
            var address = $("input[name='address']").val();
            $.ajax({
                type:"POST",
                url:"/register.action",
                data:$('#form_zhuce').serialize(),//直接传表里的数据
                async:true,
                dataType:"text",
                success:function (result) {
                    if ("Yes"==result){
                        alert("注册成功！ ");
                        $('#zhuce').modal('hide');
                    }else {
                        alert("注册失败，请重试！ ");
                    }
                }
            });
        } else if($('#zhuce').css('display')=="block"){
            alert("请按规范完善注册信息！ ");
        }
    };
    function login_check() {
        var username = $("input[name='username']").val();
        var password = $("input[name='password']").val();
        if(username&&password){
            $.ajax({
                type:"POST",
                url:"/login.action",
                data:$('#form_login').serialize(),//直接传表里的数据
                async:true,
                dataType:"text",
                success:function (result) {
                    if("No"==result){
                        alert("用户名或密码错误");
                        $("#inputPassword").val("");
                        $("#inputPassword").focus();//光标定位
                    }else {
                        alert("登录成功！ ");
                        if ("user"==result){//用户
                            window.location.href="/user_home.action";
                        } else {//管理员

                        }
                    }
                }
            });
        }else if($('#denglu').css('display')=="block"){
            alert("请填写完整用户名和密码！ ");
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
                    // 接口的insertAdjacentHTML()方法Element将指定的文本解析为HTML或XML，并将结果节点插入DOM树中的指定位置。
                    // 它不会重新解析正在使用该元素的元素，因此不会破坏该元素内部的现有元素。
                    // 这避免了额外的序列化步骤，使其比直接innerHTML操作要快得多。
                    search_suggest_type.innerHTML = temp;
                }
            });
        }
    }


</script>

</body>
</html>
