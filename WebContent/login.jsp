<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 引入jqurey -->
<script type="text/javascript" src="frame/js/jquery-3.4.1.min.js"></script>
<!-- 引入样式 -->
<link rel="stylesheet" href="dist/css/mystyle.css">
<link href="dist/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
<form class="form-horizontal">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Sign in</button>
    </div>
  </div>
</form>
<script>
window.onload=function(){
	var flag = <%=(String) request.getAttribute("flag1") %>;
	if(flag =="0"){
		alert("用户名或密码错误！");
		flag="1";
	}
}
</script>
</body>
</html>