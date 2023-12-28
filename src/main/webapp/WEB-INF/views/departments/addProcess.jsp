<%@page import="com.gohyo.app.departments.DepartmentDTO"%>
<%@page import="com.gohyo.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	DepartmentDAO ddao = new DepartmentDAO();
	DepartmentDTO ddto = new DepartmentDTO();		

	String departmentId = request.getParameter("department_id");
	String departmentName = request.getParameter("department_name");
	String managerId = request.getParameter("manager_id");
	String locationId = request.getParameter("location_id");
	
	ddto.setDepartment_id(Integer.parseInt(departmentId));
	ddto.setDepartment_name(departmentName);
	ddto.setManager_id(Integer.parseInt(managerId));
	ddto.setLocation_id(Integer.parseInt(locationId));
	
	int result = ddao.add(ddto);
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Process</h1>
	
	<script type="text/javascript">
		let result = <%= result%>
		if(result > 0){
			alert('성공');	
		}else{
		 	alert('실패');
		}
		window.location.href = "./list.jsp";
	</script>
</body>
</html>