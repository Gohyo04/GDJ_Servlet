<%@page import="com.gohyo.app.regions.RegionDTO"%>
<%@page import="com.gohyo.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	RegionDAO regionDAO = new RegionDAO();
    	RegionDTO regionDTO = new RegionDTO();
    	// parameter 값을 가져와서
    	String n = request.getParameter("region_id");
    	// 숫자로 변환
    	int num = Integer.parseInt(n);
    	regionDTO.setRegion_id(num);
    	regionDTO = regionDAO.getDetail(regionDTO);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Region Detail</h1>
	<h3><%=regionDTO.getRegion_name()%></h3>
	<input id="rId" type="hidden" value="<%= regionDTO.getRegion_id()%>">
	<button id="btn">수정</button>
	<button id="btn2">삭제</button>
	
	<script type="text/javascript">
		let btn = document.getElementById('btn');
		let v = document.getElementById("rId");
		/* call back 함수 */
		btn.addEventListener('click',()=>{
			alert(v.value);
			window.location.href = "./update.jsp?region_id="+v.value;
		});
	</script>
</body>
</html>