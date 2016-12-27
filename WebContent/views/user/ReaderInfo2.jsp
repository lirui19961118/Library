<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@page import="cn.edu.xjtu.se.lib.entity.*"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% Admin admin=(Admin)session.getAttribute("user"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>读者信息</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="static/css/agency.min.css" rel="stylesheet">
</head>
<body>
     
     
    
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="jumbotron"></div>
				<table class="table table-bordered">
					<h1 style="text-align: center">借阅信息</h1>
					<thead>
						<tr>
							<th>编号</th>
							<th>图书isbn</th>
							<th>借阅时间</th>
							<th>归还时间</th>
							
						</tr>
					</thead>
					<tbody>
<% ArrayList infoborrow=(ArrayList)session.getAttribute("infoborrow");
String[] sty={"success","error","warning","info"};
ArrayList br=null;
%>
<%
for(int i=1;i<infoborrow.size();i++){
	//String[] info=infoborrow.get(i).toString().split("\\[|,|\\]");
    br = (ArrayList)infoborrow.get(i);
%>
	<tr class=<%= sty[i%4] %>>
	<td><%= i %></td>
	<td><%= br.get(2) %></td>	
	<td><%= br.get(3) %></td>
	<td><%= br.get(4) %></td>
	
    </tr>

<%
}
%>

						
					</tbody>
				</table>
				
				
				
				<nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
					role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<div>XJTU</div>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					
					<ul class="nav navbar-nav navbar-right">
						<!-->用session显示输出名字<-->
						<li><a href="views/user/manager.jsp">欢迎你:admin</a></li>
						<!-- <li><a href="#">我的信息</a></li> -->
						<li><a href="#">注销</a></li>
					</ul>
				</div>
				</nav>
			</div>
		</div>
	</div>
	<footer>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<span class="copyright">Copyright &copy; IT Project
					Management 2016</span>
			</div>
			<div class="col-md-4">
				<ul class="list-inline social-buttons">
					<li><a href="#"><i class="fa fa-twitter"></i></a></li>
					<li><a href="#"><i class="fa fa-facebook"></i></a></li>
					<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
				</ul>
			</div>
			<div class="col-md-4">
				<ul class="list-inline quicklinks">
					<li><a href="#">Don't click!</a></li>
					<li><a href="#">Roll up please</a></li>
				</ul>
			</div>
		</div>
	</div>
	</footer>
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>