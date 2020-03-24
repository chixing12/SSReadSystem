<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="GoodsInsertCheck" method="post">
		<input type = "submit" value="提交">
</form>
<script>
window.onload=function(){
	var flag = <%=(String) request.getAttribute("flag4") %>;
	if(flag =="0"){
		alert("添加错误！");
		flag="1";
	}
}
</script>
</body>
</html>