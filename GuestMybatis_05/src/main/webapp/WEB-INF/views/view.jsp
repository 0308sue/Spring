<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상세보기</h3>

<input type="hidden" name="num" id="num" value="${guest.num }">
이름:${guest.name}  <br>
내용:${guest.content } <br>
평가:${guest.grade } <br>
<input type="button" value="수정" onclick="location.href='update?num=${guest.num }'">
<input type="button" value="삭제" onclick="location.href='delete?num=${guest.num }'">
</body>
</html>