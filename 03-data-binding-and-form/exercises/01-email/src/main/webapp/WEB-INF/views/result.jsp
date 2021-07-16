<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Language: ${emailSetting.language}</h3>
<h3>Page size: ${emailSetting.pageSize}</h3>
<h3>Spams filter: ${emailSetting.enableSpamFilter}</h3>
<h3>Signature: ${emailSetting.signature}</h3>
</body>
</html>
