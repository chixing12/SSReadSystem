<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 引入jqurey -->
<script type="text/javascript" src="dist/js/jquery-3.4.1.min.js"></script>
<!-- 引入样式 -->
<link href="dist/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<style>
body 
{
	background-image:url(images/timg.jpg);
	background-repeat: no-repeat;
	background-attachment:fixed;
	background-size: 100% 100%;
}
</style>
</head>
<style type="text/css">
	nav{
		width: 100%;
		height: 60px;	
		background: rgba(0,0,0,.3);
		position: absolute;
		z-index: 10;
	}
	nav ul{
		list-style: none;
		margin: 0;
		padding: 0;
	}
	nav ul li{
		text-align: center;
		float: left;
		line-height: 60px;
	}
	nav ul li a{
		width: 100px;
		color: #fff;
		font-size: 20px;
		font-weight: 600;
		display: block;
	}
	nav ul li a:hover,nav ul li a:visited{
		text-decoration: none;
		background: rgba(0,0,0,.5);
		color: #fff;
	}
	.words{font-size: 40px;
			letter-spacing: 10px;
			position: absolute;
			top:150px;
			left: 30%;}
	.imgw{position: relative;}
</style>
<body>
<nav>
		<ul>
			<li class="active"><a href="login.jsp">登录/注册</a></li>
			<li><a href="goodsShow.jsp">查看</a></li>
			<li><a href="goodsInsert.jsp">增加</a></li>
			<li><a href="goodsUpdate.jsp">修改</a></li>
			<li><a href="goodsDelete.jsp">删除</a></li>
		</ul>
	</nav>
	<div class="imgw">
		<div class="words">学生用品浏览系统</div>
	</div>
</body>
</html>