<%--
  Created by IntelliJ IDEA.
  User: ENC
  Date: 05-Aug-21
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Contact</title>
</head>
<body>
    <form action="CreateContactServlet" method="GET">
        Name: <input type="text" name="name">
        <br/>
        Tel Number: <input type="text" name="tel_number"/>
        <input type="submit" value="Submit"/>
</form>
</body>
</html>
