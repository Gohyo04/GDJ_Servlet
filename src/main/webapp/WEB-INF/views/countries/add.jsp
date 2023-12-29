<%@page import="com.gohyo.app.countries.CountryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Country_add</h1>
	<form action="./addProcess.jsp">
		<div>
			ID : <input type="text" name="country_id">
		</div>
		<div>
			Name : <input type="text" name="country_name">
		</div>
		<div>
			regionId : <input type="text" name="region_id">
		</div>
		
		<button>추가</button>
	</form>
</body>
</html>