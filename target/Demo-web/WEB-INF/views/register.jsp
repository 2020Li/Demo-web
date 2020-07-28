<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020-07-25
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
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
<div style="width: 400px;height: 400px;margin-top: 100px;margin-left: 500px;background-color: #70FFC4">
    <h3 align="center">新用户注册页面,welcome!!!</h3>
    <form id="register" style="margin-left: 50px">
        用户名：<input type="text"id="add_name" name="userName" placeholder="请输入2-10位中文"><br><br>
        密码：<input type="password" class="form-control" id="add_pwd" name="firstPassword" placeholder="请输入密码"><br><br>
        确认密码：<input type="password" class="form-control" id="add_pwd2" name="password" placeholder="请再次输入密码"><br><br>
        手机号：<input type="text" class="form-control" id="add_call" name="cellphone" placeholder="请输入手机号"><br><br>
        邮箱：<input type="text" class="form-control" id="add_email" name="email" placeholder="请输入邮箱地址"><br><br>
    </form>
    <div class="modal-footer" align="center" id="registerSubmit">
        <%--<button type="button" class="btn btn-primary" id="saveData">申请注册</button>--%>
    </div>
    <div class="modal-footer" align="center" id="goLogin">
        <p>已有账号！<a href="${APP_PATH}/user/login">去登录</a></p>
    </div>
</div>
</body>
<%--<script type="text/javascript">
    //点击提交添加事件
    $("#saveData").click(function () {
        var firstPwd=$("#add_pwd").val();
        var secondPwd=$("#add_pwd2").val();
        if (firstPwd == secondPwd){
            $.ajax({
                url:"${APP_PATH}/user/addUser",
                data:$("#register").serialize(),
                type:"POST",
                success:function (res) {
                    console.log(res);
                    if(res){
                        parent.location.href="/Demo_web/user/login"
                    }else{
                        alert("用户名已被注册");
                    }
                }
            })
        } else {
            alert("两次密码不一致，请重新输入")
        }
        /*alert($("#register").serialize())*/

    })
</script>--%>
<script src="${APP_PATH}/js/register_button.js"></script>
</html>
