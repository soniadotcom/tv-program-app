<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Program Database</title>
    <link href="/css/mdb.css" rel="stylesheet" type="text/css">
    <style>
        table {
            width: 1000px;
            margin: auto;
        }
        td {
            text-align: center;
        }
    </style>
</head>
<body link="#ae1100" vlink="#ae1100" alink="#ae1100">
<%@include file="header.jspf"%>
<section>
    <table>
        <thead>
        <tr>
            <th class="th">Programs</th>
            <th class="th"><a href="search?sort=BY_CHANNEL&text=${param.text}">   By Channel   </a></th>
            <th class="th"><a href="search?sort=OLD_FIRST&text=${param.text}">In Order    </a></th>
            <th class="th"><a href="search?sort=NEW_FIRST&text=${param.text}">Reverse Order</a></th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="program" items="${programs}">
                <tr>
                    <td><a href="program?programId=${program.programId}">${program.title}</a></td>
                    <td>${program.channel}</td>
                    <td>${program.time}</td>
                    <td>${program.description}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <c:if test="${user.admin}">
    <form class="red" style="width: 75%;" action="newProgram" method="POST">
        <button class="red" type="submit">Add program</button>
    </form>
    </c:if>
</section>
<br>
<%@include file="footer.jspf"%>
</body>
</html>
