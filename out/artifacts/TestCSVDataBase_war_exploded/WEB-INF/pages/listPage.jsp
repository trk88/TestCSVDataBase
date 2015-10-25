<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 20.10.2015
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<div>
    <c:forEach items="${numOP}" var="num">
    <tr>

        <form action="/Controller" method="post">
            <input type="hidden" name="page" value="paging"/>
            <input type="submit" name="numOP" value='${num}'/>
        </form>

    </tr>
    </c:forEach>
</div>

<div>
    <table border="1">
        <tr>
            <td>
                <form action="Controller" method="post">
                    <input type="hidden" name="page" value="sorting"/>
                    <input type="submit" name="sortvalue" value="name"/>
                </form>
            </td>
            <td>
                <form action="Controller" method="post">
                    <input type="hidden" name="page" value="sorting"/>
                    <input type="submit" name="sortvalue" value="surname"/>
                </form>
            </td>
            <td>
                <form action="Controller" method="post">
                    <input type="hidden" name="page" value="sorting"/>
                    <input type="submit" name="sortvalue" value="login"/>
                </form>
            </td>
            <td>
                <form action="Controller" method="post">
                    <input type="hidden" name="page" value="sorting"/>
                    <input type="submit" name="sortvalue" value="email"/>
                </form>
            </td>
            <td>
                <form action="Controller" method="post">
                    <input type="hidden" name="page" value="sorting"/>
                    <input type="submit" name="sortvalue" value="phonenumber"/>
                </form>
            </td>
        </tr>
    <c:forEach items="${subentities}" var="entity">
        <tr>

            <td>${entity.name}</td>
            <td>${entity.surname}</td>
            <td>${entity.login}</td>
            <td>${entity.email}</td>
            <td>${entity.phonenumber}</td>
        </tr>
    </c:forEach>
    </table>

</div>

</body>
</html>
