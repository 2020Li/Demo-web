<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020-07-25
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <!-- 引入jQuery -->
    <script type="text/javascript" src="${APP_PATH}/js/jquery-1.4.4.min.js">
    </script>
    <script src="${APP_PATH}/js/react.development.js"></script>
    <script src="${APP_PATH}/js/react-dom.development.js"></script>
    <script src="${APP_PATH}/js/babel.min.js"></script>

</head>
<body>
<div style="width: 500px;height: 300px;margin-top: 150px;margin-left: 450px;background-color: #bcfffc">
    <br>
    <h3 align="center" >登录页面,welcome!!!</h3>
    <form style="margin-left: 130px;margin-top: 30px">
        邮箱：<input type="text"id="query_email" name="email" placeholder="123@qq.com"><br><br>
        密码：<input type="password" class="form-control" id="query_pwd" name="password" placeholder="*****"><br>
    </form>
    <div class="modal-footer" align="center" id="login">
        <%--<button type="button" class="btn btn-primary" id="login">登录</button>--%>
    </div>
    <div align="center">
        <p>还未注册？<a href="${APP_PATH}/user/register">去注册</a></p>
    </div>
</div>

<%--<script type="text/javascript">
    //点击登录事件
    $("#login").click(function () {
        var email=$("#query_email").val();
        var password=$("#query_pwd").val();
        $.ajax({
            url:"${APP_PATH}/user/userLogin",
            data:{"email":email,"password":password},
            type:"POST",
            success:function (res) {
                if(res != "lose"){
                    parent.location.href="/Demo_web/user/index?userId="+res
                }else{
                    alert("邮箱或密码错误");
                }
            }
        })
    })
</script>--%>
</body>
<script src="${APP_PATH}/js/like_button.js"></script>
</html>
