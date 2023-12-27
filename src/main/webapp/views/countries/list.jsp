<%@page import="com.gohyo.app.countries.CountryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gohyo.app.countries.CountryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// java
	CountryDAO cdao = new CountryDAO();
	
	ArrayList<CountryDTO> ar = cdao.getList();
	System.out.println(ar.get(0).getCountry_id());
%>
<html>
<head>
<meta charset="UTF-8">
<title>Countries List</title>
</head>
<body>
	<table>
		<thead>
			<th>국가ID</th>
			<th>국가명</th>
			<th>대륙번호</th>
		</thead>
		<tbody>
			<%for(CountryDTO cdto : ar){%>
			<tr>
				<td><%=cdto.getCountry_id() %></td>
				<td><a href="./detail.jsp?country_id=<%=cdto.getCountry_id()%>"><%=cdto.getCountry_name() %></a></td>
				<td><%=cdto.getRegion_id() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>