<%--
  Created by IntelliJ IDEA.
  User: 26752
  Date: 2019/3/5
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}<br/>
<form id="form" action="/08shiro_ssm_war_exploded/userIndex/login" method="post">
    姓名:<input name="name" type="text"><br/>
    密码:<input name="pwd" type="password"><br/>
    <input type="submit" value="登录"><br/>
    <input type="checkbox" name="rememberMe">记住我
</form>

</body>
</html>
