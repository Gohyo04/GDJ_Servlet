<%@page import="com.gohyo.app.countries.CountryDTO"%>
<%@page import="com.gohyo.app.countries.CountryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	CountryDAO cdao = new CountryDAO();
	CountryDTO cdto = new CountryDTO();	

	String countryId = request.getParameter("country_id");
	String countryName = request.getParameter("country_name");
	String regionId = request.getParameter("region_id");
	
	cdto.setCountry_id(countryId);
	cdto.setCountry_name(countryName);
	cdto.setRegion_id(Integer.parseInt(regionId));
	
	int result = cdao.add(cdto);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Country Process</h1>
	
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