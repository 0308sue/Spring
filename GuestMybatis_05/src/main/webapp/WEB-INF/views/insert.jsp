<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>

<form action="gInsert" method="post">
<table align="center">
<tr>
<td>글쓴이</td>
<td><input type="text" name = "name" ></td>
</tr>

<tr>
<td>내용</td>
<td><input type="text" name = "content" ></td>
</tr>

<tr>
<td>평가</td>
<td><input type="radio" value = "excellent" id = "e" name ="grade" checked> 아주잘함(excellent)
<input type="radio" value = "good" id = "g" name ="grade"> 잘함(good)
<input type="radio" value = "normal" id = "n" name ="grade"> 보통(normal)
<input type="radio" value = "fail" id = "f" name ="grade"> 노력(fail)
</td>
</tr>

<tr>
<td colspan="2"><input type = "submit" value = "입력" ></td>
</tr>

</table>

</form>
</body>
</html>
