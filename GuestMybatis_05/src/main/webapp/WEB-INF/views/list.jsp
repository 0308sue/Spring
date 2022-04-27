<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
<h3>전체보기(${count })</h3>

<form action="list">
<select name="field">
<option value="name">이름</option> 
<option value="content">내용</option> 
</select>
<input type="text" name="word">
<input type="submit" value="검색">
</form>



<c:forEach items="${guestlist }" var="guest">
글쓴이:<a href="view?num=${guest.num }">${guest.name }</a>  <br>
내용:${guest.content } <br>
평가:${guest.grade } <hr>
</c:forEach>
</body>
</html>