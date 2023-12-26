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
	
	ddto.setDepartment_id(Integer.parseInt(id));
	if(request.getParameter("department_name") != null){
		ddto.setDepartment_name(request.getParameter("department_name"));		
	}else{
		ddto.setDepartment_name(ddto.getDepartment_name());
	}
	if(request.getParameter("manager_id") != null){
		ddto.setManager_id(Integer.parseInt(request.getParameter("manager_id")));	
	}else{
		ddto.setManager_id(ddto.getManager_id());
	}
	if(request.getParameter("location_id") != null){
		ddto.setLocation_id(Integer.parseInt(request.getParameter("location_id")));		
	}else{
		ddto.setLocation_id(ddto.getLocation_id());
	}
	
	int result = ddao.update(ddto);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Process</h1>
	<script type="text/javascript">
		let result = <%= result%>
		if(result > 0){
			alert("수정 성공");
		}else{
			alert("수정 실패");
		}
		location.href="./detail.jsp?department_id=<%=request.getParameter("department_id")%>";
	</script>
</body>
</html>