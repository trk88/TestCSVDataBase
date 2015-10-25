
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<div>

    <form action="upload"  method="post" enctype="multipart/form-data">
        <input type="hidden" name="page" value="add"/>
        <input type="file" name="file" />
        <input type="text" name="destination" />
        <input type="submit" name="Add" value="Add">

    </form>
</div>

</body>
</html>
