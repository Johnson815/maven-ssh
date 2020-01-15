<%--
  Created by IntelliJ IDEA.
  User: wenqsh
  Date: 2020/1/15
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引入struts2 的标签库--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<%-- 获取值栈中的user对象的uname的值--%>
用户名： <s:property value="user.name"></s:property>
<br/>
密码： <s:property value="user.pwd"></s:property>
</body>
</html>
