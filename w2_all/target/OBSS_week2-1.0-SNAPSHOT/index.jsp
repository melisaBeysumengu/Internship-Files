<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<%--
For RegisterServlet ---------------------------------------------
--%>
<br/>
<a href="<%= request.getContextPath() %>/RegisterServlet">Hello Servlet</a>
<br/>

<h1>Registration Page</h1>
<form action="<%= request.getContextPath() %>/RegisterServlet" method="post">
    First Name: <input type="text" name="firstName">
    <br> <br>
    Last Name: <input type="text" name="lastName">
    <br> <br>
    <input type="submit" value="register">
</form>

<br> <br>
<hr class="solid">
<%--
For Hello/MerhabaServlet ------------------------------------
--%>
<a href="hello">Hello Servlet</a>
<br/>
<a href="merhaba">Merhaba Servlet</a>

<hr class="solid">
<%--
For DispatchExample ---------------------------------------
--%>
<form action="dispatch-example">
    <label>Enter path:
        <input type="text" name="path">
    </label>
    <button type="submit">Submit</button>
</form>

<hr class="solid">
<%--
For Service Servlet ---------------------------------------
--%>
<a href="service-example">Service Servlet</a>
<br/>
<%--
For JSP Servlet ---------------------------------------
--%>
<hr class="solid">
<a href="jsp-example">JSP Servlet</a>
<br/>

<%--
For JSP Servlet ---------------------------------------
--%>
<hr class="solid">
<a href="origin-servlet">Origin Servlet</a>
<br/>

<hr class="solid">
<a href="origin-servlet2">Origin Servlet2</a>
<br/>

<hr class="solid">
<a href="error-servlet">Error Servlet</a>
<br/>

<hr class="solid">
<a href="custom-error-servlet">Custom Error Servlet</a>
<br/>

<hr class="solid">
<a href="w2_d4_e2/HomePage.jsp">Contact Servlet</a>
<br/>

<hr class="solid">
<a href="w2_d5/public/public.html">Contact Servlet</a>
<br/>

</body>
</html>