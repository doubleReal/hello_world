<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>

<body>

<h2>Hello World!ASAD</h2><br/>
<a href="userList">人员管理</a><br/>


    <shiro:hasPermission name="userIndex:system"><a href="system">系统管理</a></shiro:hasPermission>
<shiro:hasPermission name="userIndex:position"><a href="position">权限管理</a></shiro:hasPermission>
<shiro:hasPermission name="userIndex:userList"><a href="userList">人员管理</a></shiro:hasPermission>
<shiro:hasPermission name="userIndex:sell"><a href="sell">销售管理</a></shiro:hasPermission>




<form id="form" action="/08shiro_ssm_war_exploded/userIndex/logout">
    <input type="submit" value="退出">
</form>
</body>
</html>
