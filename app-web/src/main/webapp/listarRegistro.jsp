<%@page import="ar.com.educacionit.domain.RegistroUsuario"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<html>
	<head>
		<title>Usuarios Registrados</title>
	</head>
	<body>
		<h1>Usuarios</h1>
		
		
		<!-- 
		quiero capturar el listado que envio el servlet bajo el 
		nombre LISTADO
		-->
		
		<% //SCRIPTLET >CODIGO JAVA
		   //Dentro de la jsp tengo un objeto implicito llamado request
		   
		   //PRIMERO
		   Object listadoObject=request.getAttribute("ListadoUsuario");
		   
		//puedo castear
		String usuarios = (String)listadoObject;
		System.out.println(usuarios+listadoObject);
		
		  %>
		  <p><%=usuarios%></p>
	
		<%	
		
		%>
		
	</body>
</html>