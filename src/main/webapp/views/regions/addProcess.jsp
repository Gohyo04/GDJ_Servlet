<%@page import="com.gohyo.app.regions.RegionDTO"%>
<%@page import="com.gohyo.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	RegionDAO rdao = new RegionDAO();
    	RegionDTO rdto = new RegionDTO();
    	
    	String id = request.getParameter("region_id");
    	String name = request.getParameter("region_name");
    	
    	int intId = Integer.parseInt(id);
    	rdto.setRegion_id(intId);
    	rdto.setRegion_name(name);
    	
    	int result = rdao.add(rdto);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Process</h1>
	
	<script type="text/javascript">
		let result = '<%= result%>';
		if(result > 0){
			alert('등록 성공');
		}else{
			alert('등록 실패');
		}
		/* 위치로이동 */
		window.location.href = "./list.jsp";
		
	</script>
</body>
</html>