
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bài tập</title>
</head>
<body>
<div style="display: inline">
    <h2>Sandwich Condiments</h2><br>
    <output name="result">${result}</output><br>
    <hr>
    <form action="/sandwich/save" method="post" style="width: 200px; height: auto">
        <input type="checkbox" id="lettuce" name="condiments" value="lettuce">
        <label for="lettuce">Lettuce</label><br>
        <input type="checkbox" id="tomato" name="condiments" value="tomato">
        <label for="tomato">Tomato</label><br>
        <input type="checkbox" id="mustard" name="condiments" value="mustard">
        <label for="mustard">Mustard</label><br>
        <input type="checkbox" id="sprouts" name="condiments" value="sprouts">
        <label for="sprouts">Sprouts</label><br>
        <hr>
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>
