<%@page import="com.gohyo.app.departments.DepartmentDTO"%>
<%@page import="com.gohyo.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
    	DepartmentDAO ddao = new DepartmentDAO();
    	DepartmentDTO ddto = new DepartmentDTO();
    	String n = request.getParameter("department_id");
    	int num = Integer.parseInt(n);
    	ddto.setDepartment_id(num);
    	ddto = ddao.getDetail(ddto);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Department Detail</h1>
	<h3>${requestScope.dto.department_id}</h3>
	<h3>${requestScope.dto.department_name}</h3>
	<h3>${requestScope.dto.manager_id}</h3>
	<h3>${requestScope.dto.location_id}</h3>
	<input id='rId' type="hidden" value=${requestScope.dto.department_id}>
	<button id='btn'>수정</button>
	<script type="text/javascript">
		let btn = document.getElementById('btn');
		let v = document.getElementById('rId');
		btn.addEventListener('click',()=>{
			alert(v.value);
			window.location.href = "./update.jsp?department_id="+v.value;
		});
	</script>
</body>
</html>