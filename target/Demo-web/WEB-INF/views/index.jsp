<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <!-- 引入jQuery -->
    <script type="text/javascript" src="${APP_PATH}/js/jquery-1.4.4.min.js">
    </script>
</head>
<body>
<h3>欢迎进入本页面</h3>
<div style="background: cyan;width: 500px; margin-top: auto;margin-left:350px;text-align: center">
<table id="logTable" border="1" align="center">
    <thead><tr>
        <th>日志id</th>
        <th>用户id</th>
        <th>用户ip</th>
        <th>登录时间</th>
    </tr></thead>
    <tbody>

    </tbody>

</table>
</div>
</body>
<script type="text/javascript">
    $(function() {
        var userid=window.location.search.replace("?userId=","")
        /*alert(userid+"index");*/
      $.ajax({
            url:"${APP_PATH}/userLoginLog/userLogin",
            data:{"userId":userid},
            type:"POST",
            success:function(result){
                /*alert(result);*/
                console.log(result);
                userLoginLogTable(result);
            }
        });
    });
    function userLoginLogTable(result) {
        $("#logTable tbody").empty();

        var log=result;
        $.each(log,function(index,item) {
            var timestamp4 = new Date(item[3]);
            var loginId=$("<th></th>").append(item[0]);
            var userId=$("<th></th>").append(item[1]);
            var userIp=$("<th></th>").append(item[2]);
            var loginTime=$("<th></th>").append(timestamp4.toLocaleDateString().replace(/\//g, "-") + " " + timestamp4.toTimeString().substr(0, 8));
            $("<tr></tr>").append(loginId).append(userId).append(userIp).append(loginTime).appendTo("#logTable tbody")
        })
    }
</script>
</html>