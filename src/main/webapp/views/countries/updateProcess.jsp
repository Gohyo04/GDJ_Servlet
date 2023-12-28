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
	cdto.setCountry_id(id);
	
	int result = cdao.update(cdto);
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
			location.href="./detail.jsp?country_id=<%=request.getParameter("country_id")%>";
		</script>
</body>
</html>