<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@page import="cn.edu.xjtu.se.lib.entity.*"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% User user=(User)session.getAttribute("user"); %>

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
<%@include file="HeadSearch.jsp" %>
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
							<!-- <th>状态</th> -->
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
<% List infoborrow=(List)session.getAttribute("infoborrow");
//List infoborrow=(List)request.getAttribute("infoborrow");
ArrayList infob = null;
String[] sty={"success","error","warning","info"};
%>
<%
for(int i=1;i<infoborrow.size();i++){
	//String[] info=infoborrow.get(i).toString().split("\\[|,|\\]");
    infob = (ArrayList)infoborrow.get(i);
   
%>
<%-- 	<tr class=<%= sty[i%4] %>>
	<td><%= i %></td>
	<td><%= info[3] %></td>	
	<td><%= info[4].split(" ")[1] %></td>
	<td><%= info[5].split(" ")[1] %></td>
	<td><%= info[6] %></td>
	<td><a class="btn btn-primary">还书</a></td>
    </tr> --%>
    
    <tr class=<%= sty[i%4] %>>
	<td><%= i %></td>
	<td><%= infob.get(2) %></td>	
    <td><%= infob.get(3) %></td>
	<%-- <td><%= infob.get(4) %></td> --%>
	<td><%= infob.get(5) %></td>
	<td><a class="btn btn-primary" href="ReturnBook?bookId=<%=infob.get(2)%>&orderId=<%=infob.get(0)%>">还书</a></td>
    </tr>

<%
}
%>

						
					</tbody>
				</table>
				
				<h1 style="text-align: center">图书推荐</h1>
				<div class="row">
					<div class="col-md-4">
						<div class="thumbnail">
							<img style="width: 260px; height: 320px"
								src="static/img/C++.jpg" />
							<div class="caption">
								<h3>C艹 Primer</h3>
								<p>Introduction to Algorithms is a book by Thomas H. Cormen,
									Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein.</p>
								<p>
									<a class="btn btn-primary" href="#">查看详情</a>
								</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="thumbnail">
							<img style="width: 260px; height: 320px"
								src="static/img/X86.jpg" />
							<div class="caption">
								<h3>X86 PC汇编语言设计</h3>
								<p>Introduction to Algorithms is a book by Thomas H. Cormen,
									Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein.</p>
								<p>
									<a class="btn btn-primary" href="#">查看详情</a>
								</p>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="thumbnail">
							<img style="width: 260px; height: 320px"
								src="static/img/Algorithm.jpg" />
							<div class="caption">
								<h3>算法导论</h3>
								<p>Introduction to Algorithms is a book by Thomas H. Cormen,
									Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein.</p>
								<p>
									<a class="btn btn-primary" href="#">查看详情</a>
								</p>
							</div>
						</div>
					</div>
					
					
					
				</div>
					
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