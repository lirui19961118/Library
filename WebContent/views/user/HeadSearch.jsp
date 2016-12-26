<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="cn.edu.xjtu.se.lib.entity.*"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>


<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>注册新用户</title>

<!-- Bootstrap -->
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/vendor/font-awesome/css/font-awesome.min.css"
		rel="stylesheet" type="text/css">
	<link href="static/css/agency.min.css" rel="stylesheet">
	<script type="text/javascript" src=".../js/jquery-1.5.1.min.js" ></script>
	<script type="text/javascript" src=".../js/jquery_dialog.js" ></script>
</head>
<body>
	<%
  		User u = (User)session.getAttribute("user");
  		String name = u.getName();
  	%>
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
					role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">XJTU</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<form class="navbar-form navbar-left" role="search" action="SearchBook">
						<div class="form-group">
							<input type="text" class="form-control" name="bookName" placeholder="SearchHere" />
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<!-->用session显示输出名字<-->
						<li><a>欢迎你:<%= name %></a></li>
						<li><a href="views/user/ReaderInfo.jsp">我的信息</a></li>
						<li><a href="LogoutServlet">注销</a></li>
						<li><a href="BookList">进入图书馆</a></li>
					</ul>
				</div>
		</nav>

		
</body>
</html>