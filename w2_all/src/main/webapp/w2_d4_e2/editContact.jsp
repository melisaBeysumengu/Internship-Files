<%--
  Created by IntelliJ IDEA.
  User: ENC
  Date: 05-Aug-21
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Contact</title>
</head>
<body>
<form action="EditContactServlet" method="GET">
    Name:${name} <input type=hidden name="name" value="${name}" />
    <br/>

    Tel Number: <input type="text" name="tel_number" value = ${tel_number} />
    <input type="submit" value="Submit"/>
</form>

</body>
</html>
