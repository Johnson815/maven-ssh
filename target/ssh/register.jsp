<%--
  Created by IntelliJ IDEA.
  User: TimaNetworks
  Date: 2020/1/15
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 引入struts2 的标签库--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<s:form action="user_register.action" method="post" theme="simple">
    <table width="400" border="1">
        <tr>
            <td>用户名</td>
            <td><s:textfield name="user.name"></s:textfield></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><s:textfield name="user.pwd"></s:textfield></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><s:textfield name="user.age"></s:textfield></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="注册"/></td>
        </tr>
    </table>
</s:form>
</body>
</html>
