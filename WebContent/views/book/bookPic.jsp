<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Upload</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="static/css/common.css" />
	<script type="text/javascript" src="static/js/jquery-1.11.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".thumbs a").click(function(){
				var largePath  = $(this).attr("href");
				var largeAlt = $(this).attr("title");
				$("#largeImg").attr({
					src : largePath,
					alt : largeAlt
				});
				return false;
			});
			/*
			$("#myfile").change(function(){
				$("#previewImg").attr("src","file:///" + $("#myfile").val());
			});
			*/
			$('#myfile').change(function() {
				var file = this.files[0];
				var reader = new FileReader();
				reader.onload = function() {
					var url = reader.result;setImageURL(url);
				};
				reader.readAsDataURL(file);});
				var image = $("#previewImg")[0];
				function setImageURL(url) {image.src = url;} 
				
			var la = $("#large");
			la.hide();
			
			$("#previewImg").mousemove(function(e){
				la.css({
					top : e.pageY,
					left : e.pageX
				}).html('<img src = "' + this.src + '" />').show();
			}).mouseout(function(){
				la.hide();
			});
		});	
		
	</script>
  </head>
  
  <body>
  <%String isbns=(String)request.getAttribute("isbns"); %>
		
  	 <img id="previewImg" src="static/img/preview.jpg" width="80" height="80" />
  	 <form action="UploadServlet?isbns=<%=isbns%>" method="post" enctype="multipart/form-data">
  		请选择图片：<input id="myfile" name="myfile" type="file" onchange="showPreview(this)"/>
  		<input type="submit" value="提交"  />${result}
  	</form>
  	
  	<div id="large"></div>
  	
  </body>
</html>
