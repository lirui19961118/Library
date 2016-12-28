<%@page import="cn.edu.xjtu.se.lib.entity.User"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理界面</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="static/css/agency.min.css" rel="stylesheet">
	
	<link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
  </head>
  <body>
  <nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
					role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<div class="navbar-brand">XJTU</div>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					
					<ul class="nav navbar-nav navbar-right">
						<!-->用session显示输出名字<-->
						<li><a>欢迎你:admin</a></li>
						<li><a href = "BookManager">图书管理</a></li>
						<li><a href="LogoutServlet">注销</a></li>
						
					</ul>
				</div>
		</nav>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="jumbotron">
				
			</div>
			<table class="table table-bordered table-hover">
			<h1 style="text-align:center">读者管理</h1>
				<thead>
					<tr>
					    <th>
							读者学号
						</th>
					
						<th>
							读者姓名
						</th>
						<th>
							借书数量   
						</th>
						<th>
							读者状态
						</th>
						<th>
							借书详情
						</th>
					</tr>
				</thead>
				<tbody>
<% ArrayList users=(ArrayList)session.getAttribute("users");
ArrayList us = null;
String[] sty={"success","error","warning","info"};
%>
	<%
String tr=null;
String select=null;
for(int i=1;i<users.size();i++){
	//String[] info=users.get(i).toString().split("\\[|,|\\]");
	us = (ArrayList)users.get(i);
	tr="stuid"+i;
    select="select"+i;
    //tr="stuid";
    //select="select";
%>	
					<tr class="success"  class = <%= tr %>>
					    <td id = <%= tr %> >
							<%-- <%= info[1] %> --%>
							<%=us.get(0) %>
						</td>
						<td>
							<%-- <%= info[3] %> --%>
							<%=us.get(2) %>
						</td>
						<td>
							<%-- <%= info[6] %> --%>
							<%=us.get(5) %>
						</td>
						<td>
							<a class="btn btn-primary" href="ChangeStatus?userId=<%=us.get(0)%>"><%=us.get(6) %></a>
						</td>
						 
						<td>
							&nbsp&nbsp&nbsp&nbsp<button style="color:orange"><a href="ReaderInfo2Servlet?stuid=<%=us.get(0) %>">详情</a></button>
						</td>
					</tr>
<% } %>					
					<tr class="warning">
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
					</tr>
				</tbody>
			</table>
			
			
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
                    <span class="copyright">Copyright &copy; IT Project Management 2016</span>
                </div>
                <div class="col-md-4">
                    <ul class="list-inline social-buttons">
                        <li><a href="#"><i class="fa fa-twitter"style="margin-top:10px"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-facebook"style="margin-top:10px"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-linkedin"style="margin-top:10px"></i></a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <ul class="list-inline quicklinks">
                        <li><a href="#">Don't click!</a>
                        </li>
                        <li><a href="#">Roll up please</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    
    <script src="static/js/bootstrap.min.js" type="text/javascript"></script>

  </body>
</html>