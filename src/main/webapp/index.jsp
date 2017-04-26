<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
     Spring core + Spring MVC + MyBatis + mybatis-generator +pagehelper<br>
    <a href="<%=path %>/DeptController/getDeptList.do">Get Dept List</a>
   <br><br>

     文件上传 Demo <br>
    <form action="fileUploadController/uploadFile.do" method="post" enctype="multipart/form-data">
        chose File:<input type="file" name="file">
        <input type="submit" value="上传">
    </form>
  </body>
</html>
