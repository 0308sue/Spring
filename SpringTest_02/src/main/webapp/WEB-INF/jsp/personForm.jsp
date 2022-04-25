<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>개인 정보 입력</h2>
<form action="person_insert.go" method="post" >
이름 : <input type="text" name = "name" ><br/>
아이디 : <input type="text" name = "id" ><br/>
패스워드 : <input type="text" name = "password" ><br/>

성별 : 
<label for="m">남자</label><input type="radio" value = "남" id = "m" name ="gender" checked> 
<label for="f">여자</label><input type="radio" value = "여" id = "f" name ="gender"> <br/>

직업 : 
<select name="job">
<option value="학생">학생</option>
<option value="직장인">직장인</option>
<option value="자영업자">자영업자</option>
<option value="무직">무직</option>
</select><br/>
<!-- <input type="submit" value="전송"/> -->
<input type = "submit" value = "확인" >
<input type="reset" value="취소">
</form>
</body>
</html>