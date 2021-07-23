<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Program Database</title>
    <link rel="stylesheet" type="text/css" href="../css/mdb.css">
</head>
<body>
<%@include file="header.jspf"%>
<section>
    <table class="programs-table">
        <thead>
        <tr>
            <th>Program (
                <a href="search?sort=OLD_FIRST&text=${param.text}">Old First</a>,
                <a href="search?sort=NEW_FIRST&text=${param.text}">New First</a>
                )</th>
            <th>
                <a href="search?sort=BY_CHANNEL&text=${param.text}">By Channel</a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="program" items="${programs}">
            <tr>
                <td title="${program.description}">
                    <a href="program?programId=${program.programId}">${program.title}</a>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
<br>
<%@include file="footer.jspf"%>
</body>
</html>
