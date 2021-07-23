
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Program Database</title>
        <link rel="stylesheet" type="text/css" href="../css/ada.css">
    </head>
    <body>
        <%@include file="header.jspf"%>
        <section>
            <h1 align="center" style="color:#ae1100;" >${message}</h1>

            <form align="center" action=".">
                <button type="submit">Main page</button>
            </form>
            
        </section>  
        <br>
        <%@include file="footer.jspf"%>
    </body>
</html>
