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
<form action="personUpdate.sp" method="post" >
이름 : <input type="text" name = "name" value="${person.name }" ><br/>
아이디 : <input type="text" name = "id" value="${person.id }"><br/>
패스워드 : <input type="text" name = "password" ><br/>

성별 : 
<label for="m">남자</label><input type="radio" value = "남" id = "m" name ="gender" > 
<label for="f">여자</label><input type="radio" value = "여" id = "f" name ="gender"> <br/>

직업 : 
<select name="job" id="job">
<option value="학생">학생</option>
<option value="직장인">직장인</option>
<option value="자영업자">자영업자</option>
<option value="무직">무직</option>
</select><br/>
<script>
$("input:radio[value='${person.gender}']").prop("checked",true);

$("#job option").each(function(){
	if($(this).val()=="${person.job}"){
		$(this).prop("selected",true);
	}
})
</script>

<input type = "submit" value = "수정" >
<input type="reset" value="취소">
</form>
</body>
</html>