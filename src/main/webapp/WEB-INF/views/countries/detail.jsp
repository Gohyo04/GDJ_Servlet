<%@page import="com.gohyo.app.countries.CountryDTO"%>
<%@page import="com.gohyo.app.countries.CountryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	//java
	/* CountryDAO cdao = new CountryDAO();
	CountryDTO cdto = new CountryDTO();	

	String s = request.getParameter("COUNTRY_ID");
	cdto.setCountry_id(s);
	
	cdto = cdao.getCountry(cdto);
	System.out.println(cdto.getCountry_id());
	System.out.println(cdto.getCountry_name()); */
%>
<html>
<head>
<meta charset="UTF-8">
<title>Country Detail</title>
</head>
<body>
	<h1>Country Detail</h1>
	<h3>$requestScope.dto.country_id></h3>
	<h3>$requestScope.dto.country_name</h3>
	<h3>$requestScope.dto.region_id</h3>
</body>
</html>