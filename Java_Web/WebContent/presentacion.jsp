<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Presentación</title>
</head>
<body>
	<h2>Esta es la página de presentacion.jsp</h2>
	
	<h3>Esta es la variable recibida de Servlet (Atributo): ${name1}</h3>
	<h3>Esta es la variable recibida de Servlet (Sesion): ${name2}</h3>
	<h3>Esta es la variable recibida de Servlet (Contexto): ${name3}</h3>
	
	<a href="presentacion2.jsp">Llevar a presentacion2.jsp</a>
	
	</br>
	
	<% 
		// scriptlets
		int a = 3;
		int b = 5;
		int c = a + b;
		out.print(c);
	%>
	</br>
	<%= request.getAttribute("name1") %>
	</br>
	<%= request.getSession().getAttribute("name2") %>
	</br>
	<%= getServletContext().getAttribute("name3") %>
</body>
</html>