<%@page import="cn.edu.xjtu.se.lib.entity.User"%>

<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="cn.edu.xjtu.se.lib.entity.*"%> 
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% Admin admin=(Admin)session.getAttribute("user"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
  <head>
  <base href="<%=basePath%>">
    <!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"> -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理图书界面</title>
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
						<li><a href="views/user/manager.jsp">欢迎你:admin</a></li>
						
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
			<h1 style="text-align:center">图书管理</h1>

			    <thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							ISBN号
						</th>
						<th>
							数量
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>

				<tbody>
<%
    	ArrayList bookSearch = (ArrayList)request.getAttribute("books");
    	ArrayList al = null;
    	if(bookSearch != null){
    		for(int i = 1; i < bookSearch.size(); i++){
    			al = (ArrayList)bookSearch.get(i);
 %>

   <form action="ChangeNum"  method="post">
					<tr class="info">
						<td>
							<%= al.get(1) %>
						</td>
						<td>
							<%= al.get(0) %>
						</td>
						
							<input class="text_box" name="isbn" type="text" value="<%= al.get(0) %>" style="display:none" style="width:25px;" />
						
						<td>
							<!-- <input class="min" name="" type="button" value="-" /> -->
							<input class="text_box" name="number" type="text" value="<%= al.get(4) %>" style="width:25px;"/>
							<!-- <input class="add" name="" type="button" value="+" /> -->
						</td>
						<td>
							<button  style="color:orange" type="submit">修改数量</button>
						</td>
					</tr>
	</form>
<% } 
    	}
%>
					<tr class="warning">
						<td>
							......
						</td>
						<td>
							......
						</td>
						<td>
							......
						</td>
						<td>
							<button data-toggle="modal" href="#myModal" style="color:blue">添加新书</button>
							<!-- 模态框（Modal） -->
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
								
								<form action="AddBook"  method="post">
								
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
												&times;
											</button>
											<h4 class="modal-title" id="myModalLabel">
												添加书籍信息
											</h4>
										</div>
										
										<div class="modal-body">
											<table class="table">
											
											<tbody>
												<tr>
													<td>
														书&nbsp&nbsp&nbsp名：<input type="text" name=bookName>
													</td>
													<td>
														ISBN：<input type="text" name=isbn>
													</td>
													
												</tr>
												<tr>
													<td>
														数&nbsp&nbsp&nbsp量：<input type="text" name=number>
													</td>
													<td>
														作者：<input type="text" name=author>
													</td>
													
												</tr>
												<tr>
													<td>
														出&nbsp&nbsp版&nbsp&nbsp社：<input type="text" name=publish>
													</td>
													<td>
														书籍图片：<input type="file" name=picture>
													</td>
													
												</tr>
												
											</tbody>
											</table>
											&nbsp&nbsp描述：<br>&nbsp&nbsp<textarea name="describe" style="width:480px;height:50px;">这里写内容</textarea>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">关闭
											</button>
											<button type="submit" class="btn btn-primary">
												提交更改
											</button>
										</div>
										
							</form>	
									</div><!-- /.modal-content -->
								</div><!-- /.modal -->
							</div>
						</td>
					</tr>

			<!-- 		<tr class="warning">
						<td>
							<a href=# style="color:red">显示更多...</a>
						</td>
						<td>
							......
						</td>
						<td>
							......
						</td>
						<td>
							......
						</td>
					</tr> -->
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
                        <li><a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a>
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