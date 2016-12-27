<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@page import="cn.edu.xjtu.se.lib.entity.*"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% User user=(User)session.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书详情</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="syatic/css/agency.min.css" rel="stylesheet">
	  <%@include file="../user/HeadSearch.jsp" %>
</head>
<body>


<%
    	Book b = (Book)request.getAttribute("bookDescrib");
		
 %>
    
    
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="jumbotron"></div>
			<div class="row" style="width:800;font-family:sans-serif;">
				<div class="col-md-4">
					<div class="thumbnail">
						<img style="width:260px;height:320px" src=<%=b.getPicture() %> />
						<div class="caption"></div>
					</div>
				</div>
				
				<h3 style="font-family:sans-serif;color:gray;text-align:center">
								<%=b.getBookName() %>
				</h3>
				<ul style="color:gray;float:right;display:block">
					<li>作者：<%=b.getAuthor() %></li>
					<li>出版社：<%=b.getPublish() %></li>
				</ul>
				<p style="font-family:sans-serif;color:gray">
					&nbsp&nbsp <%=b.getDescribe() %>
				</p>
				<div>
					库存：<%=b.getCan_borrow() %>
				</div>
				<% if(b.getCan_borrow()==0) {%>
				<div style="color:red">
					库存为0,不可借书
				</div>
				<% }else if(!user.getStatus().equals("normal")) {%>
				<div style="color:red">
					处于限制状态
				</div>
				<% }else if(user.getAlready_num() >= 10) {%>
				<div style="color:red">
					已达借书上限10，不可借书
				</div>
				<% }else {%>
				
				<a class="btn btn-primary" href="BorrowBook?bookId=<%=b.getIsbn()%>">借书</a>
				<%} %>
			</div>
			
		</div>
	</div>
</div>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
  </body>
</html>