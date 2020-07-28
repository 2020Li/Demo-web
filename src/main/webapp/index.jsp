<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <jsp:forward page="WEB-INF/views/login.jsp" />
     <%
	    pageContext.setAttribute("APP_PATH",request.getContextPath());
      %>
    <!-- 引入jQuery -->
    <script type="text/javascript" src="${APP_PATH}/js/jquery-1.4.4.min.js">
    </script>
</head>
<body>
成功,去登陆页面


<%--<script type="text/javascript">
    $(function() {
    $.ajax({
    url:"${APP_PATH}/user/login",
    type:"POST",
    success:function(result){
     console.log(result);
    }
    });
    });
</script>--%>
</body>
</html>
