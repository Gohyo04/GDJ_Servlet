<%@page import="com.gohyo.app.departments.DepartmentDTO"%>
<%@page import="com.gohyo.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	DepartmentDAO ddao = new DepartmentDAO();
	DepartmentDTO ddto = new DepartmentDTO();	
	String id = request.getParameter("department_id");
	
	ddto.setDepartment_id(Integer.parseInt(id));
	
	ddto = ddao.getDetail(ddto);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Department Update Page</h1>
	<form action="./updateProcess.jsp">
		<div>
			ID : <input type="text" readOnly name="department_id" value=<%=ddto.getDepartment_id() %>>
		</div>
		<div>
			Name : <input type="text" name="department_name" value=<%=ddto.getDepartment_name() %>>
		</div>
		<div>
			매니저ID : <input type="text" name="manager_id" value=<%=ddto.getManager_id() %>>
		</div>
		<div>
			Location_ID : <input type="text" name="location_id" value=<%=ddto.getLocation_id() %>>
		</div>
		<button>수정</button>
	</form>
</body>
</html>