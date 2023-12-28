<%@page import="com.gohyo.app.countries.CountryDTO"%>
<%@page import="com.gohyo.app.countries.CountryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	CountryDAO cdao = new CountryDAO();
	CountryDTO cdto = new CountryDTO();
	String id = request.getParameter("country_id");
	
	cdto.setCountry_id(id);
	cdto = cdao.getCountry(cdto);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Country Update</h1>
	<form action="./updateProcess">
		<div>
			ID : <input type="text" readOnly name="country_id" value=<%=cdto.getCountry_id()%>>
		</div>
		<div>
			Name : <input type="text" name="country_name" value=<%=cdto.getCountry_name() %>>
		</div>
		<div>
			RegionId : <input type="text" name="region_id" value=<%=cdto.getRegion_id() %>>
		</div>
		<button>수정</button>
	</form>
	
</body>
</html>