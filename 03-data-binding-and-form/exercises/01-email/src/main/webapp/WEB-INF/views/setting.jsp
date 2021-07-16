<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/save-setting" modelAttribute="emailSetting" method="post">
    <table cellpadding="5px">
        <tr>
            <td><form:label path="language">Languages</form:label></td>
            <td>
                <form:select path="language" cssStyle="width: 100%">
                    <form:option value="English"/>
                    <form:option value="Vietnamese"/>
                    <form:option value="Chinese"/>
                    <form:option value="Japanese"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Sizes:</form:label></td>
            <td>
                <p style="display: inline">Show </p>
                <form:select path="pageSize" style="display: inline">
                    <form:option value="5"/>
                    <form:option value="10"/>
                    <form:option value="15"/>
                    <form:option value="25"/>
                    <form:option value="50"/>
                    <form:option value="100"/>
                </form:select>
                <p style="display: inline"> emails per page</p>
            </td>
        </tr>
        <tr>
            <td><form:label path="enableSpamFilter">Spams filter:</form:label></td>
            <td>
                <form:checkbox path="enableSpamFilter"/>
                <form:label path="enableSpamFilter">Enable spams filter</form:label>
            </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature:</form:label></td>
            <td>
                <form:textarea path="signature" rows="3" cssStyle="resize: none; width: 100%"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button>Update</form:button>
                <button type="reset">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
