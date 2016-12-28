<%@page import="cn.edu.xjtu.se.lib.entity.User"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>图书馆</title>

<!-- Bootstrap -->
<link href="static/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <%@include file="../user/HeadSearch.jsp" %>
</head>
<body>
<div class="row" style="margin-top:60px">
    <%
    	ArrayList bookSearch = (ArrayList)request.getAttribute("allBook");
    	ArrayList al = null;
    	if(bookSearch != null){
    		for(int i = 1; i < bookSearch.size(); i++){
    			al = (ArrayList)bookSearch.get(i);
    %>
					
					<div class="col-md-4">
						<div class="thumbnail">
							<img style="width: 260px; height: 320px"
								src=<%=al.get(7) %> />
							<div class="caption">
								<h3><%=al.get(1) %></h3>
								<%-- <p><%=al.get(6) %></p> --%>
								<p>
									<a class="btn btn-primary" href="BookDetail?bookId=<%=al.get(0)%>">查看详情</a>
								</p>
							</div>
						</div>
					</div>

		<%}}%>
</div>
</body>
</html>