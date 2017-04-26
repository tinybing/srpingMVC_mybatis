<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<title>My JSP 'addDept.jsp' starting page</title>
	</head>

	<body>
		<form action="<%=path %>/DeptController/addDept.do" method="POST">
			<table>
				<tr>
					<td>id:</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>dept:</td>
					<td><input type="text" name="dept"></td>
				</tr>


				<tr>
					<td>
						<input type="submit" value="Save">
					</td>
					<td>
						<input type="reset" value="Reset">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
