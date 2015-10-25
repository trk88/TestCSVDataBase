
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>

  <h1>Menu page:</h1>
  <div>
      <form action="Controller" method="post">
          <input type="hidden" name="page" value="list"/>
          <input type="submit" name="List page" value="ListPage"/>
      </form>
  </div>
  <div>
      <form action="Controller" method="post">
          <input type="hidden" name="page" value="import"/>
          <input type="submit" name="Import page" value="ImportPage"/>
      </form>
  </div>

  </body>
</html>
