<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15/7/2021
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="display: block; text-align: -webkit-center">
    <h3>Calculator</h3><br>
    <hr>
    <form action="/" method="post">
        <table>
            <tr>
                <td colspan="2">
                    <input type="text" name="soHang1" required style="width: 100%">
                </td>
                <td colspan="2">
                    <input type="text" name="soHang2" required style="width: 100%">
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit" name="btn" value="addition">Addition (+)</button>
                </td>
                <td>
                    <button type="submit" name="btn" value="subtraction">Subtraction (-)</button>
                </td>
                <td>
                    <button type="submit" name="btn" value="multiplication">Multiplication (x)</button>
                </td>
                <td>
                    <button type="submit" name="btn" value="division">Division (/)</button>
                </td>
            </tr>
        </table>
    </form>
    <output name="result">Result: ${result}</output>
</div>
</body>
</html>
