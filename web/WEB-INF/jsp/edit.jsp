<%--
  Created by IntelliJ IDEA.
  User: Fedor
  Date: 30.05.2020
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" type="text/css" href="../css/ada.css">
</head>
<body>
edit
<form class="edit-form" action="edit.jsp" method="POST">
    <p><input type="text" name="title"/></p>
    <p><input type="text" name="channel" value=${program.channel} /></p>
    <p><input type="submit" value="Edit" /></p>
</form>
<%= request.getParameter("title") %>
<%= request.getParameter("channel") %>
</body>
</html>
