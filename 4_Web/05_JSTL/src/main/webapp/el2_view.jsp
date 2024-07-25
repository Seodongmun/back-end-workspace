<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1) 기존 방식</h2>
	<%= request.getParameter("id") %><br>
	<% String[] hoddyList = request.getParameterValues("hobby"); 
		for(String hobby : hoddyList){
	%>
		- <%=hobby%><br>
	<% } %>
	
	<%-- EL은 반복문 사용 불가능 --%>
	<h2>2) EL </h2>
	${param.id}<br>
	- ${paramValues.hobby[0]} <br>
	- ${paramValues.hobby[1]} <br>
	- ${paramValues.hobby[2]} <br>
	- ${paramValues.hobby[3]} <br>
</body>
</html>