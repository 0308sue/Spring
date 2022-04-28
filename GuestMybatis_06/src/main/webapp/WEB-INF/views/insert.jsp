<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<script>
	$(function(){
		loadData("","");
		$("#send").click(sendIt)
		$("#btnSearch").click(function(){
			loadData($("#field").val(),$("#word").val());
		})
	})
	
	function sendIt(){
		var postString = {
				"name":$("#name").val(),
				"content":$("#content").val(),
				"grade":$("input:radio[name=grade]:checked").val()
		}
		$.ajax({
			type:"post",
			url:"insert",
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify(postString),
			success:function(resp){
				alert(resp);
				loadData("","");
			},
			beforeSend:showRequest,
			error:function(e){
				alert("실패:"+e)
			}
		})
	}
	
	function fdelete(num){
		$.ajax({
			type:"DELETE",
			url:"delete/"+num,
			success:function(resp){
				alert("삭제 성공")
				loadData();
			},
			error:function(e){
				alert("삭제 실패:"+e)
			}
		})
	}
	
	function fview(num){
		$.getJSON("view",{"num":num},function(val){
			var str ="";				
				str += " 이름 :"+ val.name +"<br/>"
				str += " 내용 :"+ val.content +"<br/>"			
				str += " 등급 :"+ val.grade +"<br/>"				
				str += " 게시일 :"+ val.created +"<br/>"				
				str += " ip주소 :"+ val.ipaddr +"<br/>"
				
			
			$("#viewDiv").html(str);
		})
	}
	
	function loadData(field,word){
		$.getJSON("list",{"field":field,"word":word},function(resp){
			//alert(resp.count);
			var str ="";
			$("#cntDiv").text("개수 : "+resp.count);
			$.each(resp.arr,function(key,val){
				
				
				str += " <a href = javascript:fview('"+val.num+"')> 이름 :"+ val.name +"</a><br/>"
				str += " 내용 :"+ val.content +"<br/>"
				str += " 등급 :"+ val.grade +"<br/>"
				str += " <a href = javascript:fdelete('"+val.num+"')>삭제</a><br/>"
				str += "<br/>"
			})
			
			$("#result").html(str);
		})
	}
	
	
	function showRequest(){
		if(!$("#name").val()){
			alert("글쓴이를 입력하세요");
			$("#name").focus();
			return false;
		}
		if(!$("#content").val()){
			alert("내용을 입력하세요");
			$("#content").focus();
			return false;
		}
		if($("input:radio[name=grade]:checked").length==0){
			alert("평가하세요");
			return false;
		}
		return true;
		
	}
	
	</script>
	
</head>
<body>

<form action="insert" method="post">
<table align="center">
<tr>
<td>글쓴이</td>
<td><input type="text" name = "name" id="name"></td>
</tr>

<tr>
<td>내용</td>
<td><input type="text" name = "content" id="content"></td>
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
<td colspan="2"><input type = "button" value = "입력"  id="send"></td>
</tr>

</table>

<div align="right">
	<select name="field" id="field">
	<option value="name">이름</option> 
	<option value="content">내용</option> 
	</select>
	<input type="text" name="word" id="word">
	<input type="button" value="검색" id="btnSearch">
</div>

</form>


<hr>
<div id="cntDiv"></div>
<div id="result"></div>
<hr>
<div id="viewDiv"></div>

</body>
</html>
