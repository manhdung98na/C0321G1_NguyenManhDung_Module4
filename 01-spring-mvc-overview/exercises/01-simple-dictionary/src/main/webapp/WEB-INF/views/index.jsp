<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/7/2021
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>

<form method="post" action="/translate">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/><br><br>
    <%--    OUTPUT: <input type="text" name="result" id="result" placeholder="Here is result" readonly/><br><br>--%>
    <input type="submit" id="submit" value="Search"/>
</form>
</body>
</html>
