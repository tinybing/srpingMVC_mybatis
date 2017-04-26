<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User list</title>
</head>
<body>
  	<h3>UserList</h3>
  	<a href="<%=path %>/addDept.jsp">Add Dept</a><br/>
	<table border="1" width="70%">
   		<tr>
   			<td>Id</td>
   			<td>dept</td>

   		</tr>
   		<c:forEach items="${deptlist}" var="dept">
   		<tr>
   			<td>${dept.id }</td>
   			<td>${dept.dept}</td>
   		</tr>
   		</c:forEach>
   </table>
   
</body>
</html>