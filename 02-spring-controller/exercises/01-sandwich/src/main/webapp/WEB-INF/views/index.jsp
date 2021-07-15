
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
        <input type="checkbox" id="lettuce" name="condiments" value="lettuce" onchange="isChecked()">
        <label for="lettuce">Lettuce</label><br>
        <input type="checkbox" id="tomato" name="condiments" value="tomato" onchange="isChecked()">
        <label for="tomato">Tomato</label><br>
        <input type="checkbox" id="mustard" name="condiments" value="mustard" onchange="isChecked()">
        <label for="mustard">Mustard</label><br>
        <input type="checkbox" id="sprouts" name="condiments" value="sprouts" onchange="isChecked()">
        <label for="sprouts">Sprouts</label><br>
        <hr>
        <button type="submit" id="btnSubmit" disabled>Submit</button>
    </form>
</div>
</body>
<script>
    function isChecked() {
        if (document.getElementById("lettuce").checked == false
            && document.getElementById("tomato").checked == false
            && document.getElementById("mustard").checked == false
            && document.getElementById("sprouts").checked == false){
            document.getElementById("btnSubmit").disabled = true;
        }else {
            document.getElementById("btnSubmit").disabled = false;
        }
    }
</script>
</html>
