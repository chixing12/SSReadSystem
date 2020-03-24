<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterCheck" method="post">

</form>
<script>
window.onload=function(){
	var flag = <%=(String) request.getAttribute("flag1") %>;
	if(flag =="0"){
		alert("用户名名已存在！");
		flag="1";
	}
}
</script>
</body>
</html>