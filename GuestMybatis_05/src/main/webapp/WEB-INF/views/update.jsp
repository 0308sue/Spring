<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h2>수정하기</h2>
<form action="update" method="post">
<input type="hidden" name="num" id="num" value="${guest.num }">
<table align="center">
<tr>
<td>글쓴이</td>
<td><input type="text" name = "name" value="${guest.name }"></td>
</tr>

<tr>
<td>내용</td>
<td><input type="text" name = "content" value="${guest.content }" ></td>
</tr>

<tr>
<td>평가</td>
<td><input type="radio" value = "excellent" id = "e" name ="grade" checked> 아주잘함(excellent)
<input type="radio" value = "good" id = "g" name ="grade"> 잘함(good)
<input type="radio" value = "normal" id = "n" name ="grade"> 보통(normal)
<input type="radio" value = "fail" id = "f" name ="grade"> 노력(fail)
</td>
</tr>


</table>

<script>
$("input:radio[value='${guest.grade}']").prop("checked",true);


</script>

<input type = "submit" value = "수정" >
<input type="reset" value="취소">
</form>
</body>
</html>