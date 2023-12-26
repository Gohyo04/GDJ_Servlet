<%@page import="java.util.ArrayList"%>
<%@page import="com.gohyo.app.departments.DepartmentDTO"%>
<%@page import="com.gohyo.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// java
	DepartmentDAO ddao = new DepartmentDAO();
	ArrayList<DepartmentDTO> ar = ddao.getList(); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<th>DEPARTMENT_ID</th>
			<th>DEPARTMENT_NAME</th>
			<th>MANAGER_ID</th>
			<th>LOCATION_ID</th>
		</thead>
		<tbody>
		<%for(DepartmentDTO ddto : ar){ %>
			<tr>
				<td><%=ddto.getDepartment_id()%></td>
				<td><a href="./detail.jsp?department_id=<%=ddto.getDepartment_id()%>"><%=ddto.getDepartment_name() %></a></td>
				<td><%=ddto.getManager_id() %></td>
				<td><%=ddto.getLocation_id() %></td>
			</tr>
		<%}%>
		</tbody>
	</table>
	<a href="./add.jsp">추가</a>
</body>
</html>