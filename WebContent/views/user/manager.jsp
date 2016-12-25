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
							<select name="select" id=<%= select %> class="select">
							    <%if(us.get(6).equals("normal")) {
							    	
							    %>
							    <option value="normal" selected id="Nor" >Normal</option>
								<option value="declined" id="Dec">Declined</option>
							    <%} else {%>
								<option value="normal" >Normal</option>
								<option value="declined" selected>Declined</option>
								<% } %>
							</select>
						</td>
						
						<td>
							&nbsp&nbsp&nbsp&nbsp<button style="color:orange"><a href="ReaderInfo2Servlet?stuid=<%=us.get(0) %>">详情</a></button>
						</td>
					</tr>
<% } %>					
					<tr class="warning">
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
					</tr>
				</tbody>
			</table>
			<table class="table table-bordered table-hover">
			<h1 style="text-align:center">图书管理</h1>

			    <thead>
					<tr>
						<th>
							书名
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

					<tr class="success">
						<td>
							C艹 Primer
						</td>
						<td>
							9787111327288
						</td>
						<td>
							<input class="min" name="" type="button" value="-" />
							<input class="text_box" name="goodnum" type="text" value="1" style="width:25px;" />
							<input class="add" name="" type="button" value="+" />
  
<!--相关Java代码
$(".add").click(function() {
        // $(this).prev() 就是当前元素的前一个元素，即 text_box
        $(this).prev().val(parseInt($(this).prev().val()) + 1);
        setTotal();
});
  
$(".min").click(function() {
        // $(this).next() 就是当前元素的下一个元素，即 text_box
        $(this).next().val(parseInt($(this).next().val()) - 1);
        setTotal();
});
-->
						</td>
						<td>
							<button onclick="" style="color:orange">删除</button>
						</td>
					</tr>
					
					
					
					
					<tr class="error">
						<td>
							X86 PC汇编语言设计
						</td>
						<td>
							9787111327288
						</td>
						<td>
							<input class="min" name="" type="button" value="-" />
							<input class="text_box" name="goodnum" type="text" value="1" style="width:25px;" />
							<input class="add" name="" type="button" value="+" />
						</td>
						<td>
							<button onclick="" style="color:orange">删除</button>
						</td>
					</tr>
					<tr class="warning">
						<td>
							算法导论
						</td>
						<td>
							9787111327288
						</td>
						<td>
							<input class="min" name="" type="button" value="-" />
							<input class="text_box" name="goodnum" type="text" value="1" style="width:25px;" />
							<input class="add" name="" type="button" value="+" />
						</td>
						<td>
							<button onclick="" style="color:orange">删除</button>
						</td>
					</tr>
					<tr class="info">
						<td>
							IT项目管理
						</td>
						<td>
							9787111327288
						</td>
						<td>
							<input class="min" name="" type="button" value="-" />
							<input class="text_box" name="goodnum" type="text" value="1" style="width:25px;" />
							<input class="add" name="" type="button" value="+" />
						</td>
						<td>
							<button onclick="" style="color:orange">删除</button>
						</td>
					</tr>
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
														书&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：<input type="text" name=bookName>
													</td>
													<td>
														ISBN：<input type="text" name=isbn>
													</td>
													
												</tr>
												<tr>
													<td>
														数&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp量：<input type="text" name=publish>
													</td>
													<td>
														作者：<input type="text" name=author>
													</td>
													
												</tr>
												<tr>
													<td>
														出&nbsp&nbsp版&nbsp&nbsp社：<input type="text" name=addNumber>
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
											<button type="button" class="btn btn-primary">
												提交更改
											</button>
										</div>
									</div><!-- /.modal-content -->
								</div><!-- /.modal -->
							</div>
						</td>
					</tr>
					<tr class="warning">
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
					</tr>
				</tbody>
			</table>
			<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">XJTU</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="SearchHere" />
						</div> <button type="submit" class="btn btn-default">Submit</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
							<!-->用session显示输出名字<-->
							 <li><a href="#">欢迎你:XXX</a></li>
							 <li><a href="Index.html">我的信息</a></li>
							 <li><a href="Index.html">注销</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
</div>
			
			
			<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">XJTU</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="SearchHere" />
						</div> <button type="submit" class="btn btn-default">Submit</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
							<!-->用session显示输出名字<-->
							 <li><a href="#">欢迎你:<%= admin.getAdminName() %></a></li>
							 <li><a href="#">我的信息</a></li>
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
<script language="javascript" type="text/javascript"> 
 $(document).ready(function(){ 
	//for (var i=0;i<4;i++)
	//{
		
		$('#'+'select'+1).change(function(){ 
			
			alert("已修改为"+$(this).children('option:selected').val()); 
			
			var p1=$(this).children('option:selected').val();//这就是selected的值 
			
			//var p2=$('#stuid').val();//获取本页面其他标签的值 
			//var p2=$('#'+'stuid'+'i').val();//获取本页面其他标签的值 
			var p2=$('#'+'stuid'+1).text().trim();
			//window.location.href="index.jsp?param1="+p1+"&m2="+p2;//页面跳转并传参 
			console.log(p1 + "  " + "   " + p2);
			}) 
			
			
		$('#'+'select'+2).change(function(){ 
			
			alert("已修改为"+$(this).children('option:selected').val()); 
			
			var p1=$(this).children('option:selected').val();//这就是selected的值 
			
			//var p2=$('#stuid').val();//获取本页面其他标签的值 
			//var p2=$('#'+'stuid'+'i').val();//获取本页面其他标签的值 
			var p2=$('#'+'stuid'+2).text().trim();
			//window.location.href="index.jsp?param1="+p1+"&m2="+p2;//页面跳转并传参 
			console.log(p1 + "  " + "   " + p2);
			}) 
	//}

}) 

/* $(document).ready(function(){ 
	var len = $(".select").length; 
	for (var i=0;i<10;i++)
	{
		($(".select").get(i)).change(function(){ 
			alert("已修改为"+$(this).children('option:selected').val()); 
			var p1=$(this).children('option:selected').val();//这就是selected的值 

			//var p2=$('#stuid').val();//获取本页面其他标签的值 
			var p2=$('.studi').get(i).val();//获取本页面其他标签的值 
			window.location.href="xx.php?param1="+p1+"¶m2="+p2+"";//页面跳转并传参 
			}) 
		
	}

})  */
</script> 
  </body>
</html>