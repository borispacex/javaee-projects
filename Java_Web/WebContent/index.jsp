<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My title example</title>
</head>
<body>
	<h1>Hello World</h1>
	<a href="MyServlet">Creamos una petición de tipo GET</a>
	</br>
	<a href="MyServlet?var1=2&var2=6">Creamos una petición de tipo GET con parametros</a>
	</br>
	<form action="MyServlet" method="post">
		<label>Nombre: </label>
		<input type="text" name="nombre" placeholder="Escriba su nombre">
		<button type="submit">Enviar</button>
	</form>
</body>
</html>