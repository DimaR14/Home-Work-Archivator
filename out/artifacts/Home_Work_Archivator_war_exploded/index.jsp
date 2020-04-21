<%--
  Created by IntelliJ IDEA.
  User: WilD
  Date: 18.04.2020
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>My File</title>
  </head>
  <body>
  <form action = "/file.zip">
    <p> Select files: </p>
    <p><input type="checkbox" name="file1" value="file1.txt">File #1</p>
    <p><input type="checkbox" name="file2" value="file2.txt">File #2</p>
    <p><input type="checkbox" name="file3" value="file3.txt">File #3</p>
    <p><input type="checkbox" name="file4" value="file4.txt">File #4</p>
    <p><input type="checkbox" name="file5" value="file5.txt">File #5</p>
    <p><input type="submit" value="Archive"></p>
  </form>
  </body>
</html>
