<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Program Database</title>
    <link rel="stylesheet" type="text/css" href="../css/mdb.css">
</head>
<body>
<%@include file="header.jspf"%>
<section>

        <div class="program-title">
            <h1 style="margin-left: 50px;" class="red" >${program.title}</h1>
            <p class="button" style="margin-left: 50px;" align="left" style="color:rgba(131,132,139,0.8); font-size:20px"> Description ${program.description}</p>
        </div>
        <div class="textarea">
            <p style="margin-left: 50px;" align="left" style="color:rgba(21,20,20,0.8); font-size:20px">Channel ${program.channel}</p>
        </div>
        <div class="input">
            <p class="input" style="margin-left: 50px;" align="left" style="color:rgba(131,132,139,0.8); font-size:20px">Date ${program.date}</p>
        </div>
        <div class="input">
            <p class="input" style="margin-left: 50px;" align="left" style="color:rgb(13,13,14); font-size:20px">Time ${program.time}</p>
        </div>
        <c:forEach var="comment" items="${program.comments}">
        <div>
            <p class="input" style="margin-left: 50px;" align="left" style="font-size:20px ">${comment.text}</p>
        </div>
    </c:forEach>
    <form style="width: 100%;" action="delete" method="POST">
        <c:if test="${user.admin}">
            <input type="hidden" name="programId" value="${program.programId}" />
            <p><input style="width: 95%;" type="submit" value="Delete info" /></p>
        </c:if>
    </form>

    <c:if test="${user.admin}">
        <form style="width: 100%;" action="edit" method="POST">
            <input type="hidden" name="programId" value="${program.programId}" />
            <textarea class="boxsizingBorder" name="title">${program.title}</textarea>
            <textarea class="boxsizingBorder" name="channel">${program.channel}</textarea>
            <textarea class="boxsizingBorder" name="date">${program.date}</textarea>
            <textarea class="boxsizingBorder" name="time">${program.time}</textarea>
            <textarea class="border" name="description">${program.description}</textarea>
            <input style="width: 95%;" type="submit" value="Edit info" />
        </form>
        <br>
        <form style="width: 100%;" action="comment" method="POST">
            <input type="hidden" name="programId" value="${program.programId}" />
            <textarea style="width: 70%;" rows="4" name="text" class="form-control"></textarea>
            <input style="width: 95%;" type="submit" value="Add info" />
        </form>
    </c:if>
        <br>
    <c:if test="${user.admin}">
        <form text-align: center; class="red" style="width: 95%;" action="deleteProgram" method="POST">
                <input type="hidden" name="programId" value="${program.programId}" />
                <button class="red" type="submit"> Delete program ${program.title}</button>
        </form>
    </c:if>
        <br>
    <form class="red" align="left" action=".">
        <button class="red" type="submit">Main page</button>
    </form>
    <p></p>
</section>
<%@include file="footer.jspf"%>
</body>
</html>
