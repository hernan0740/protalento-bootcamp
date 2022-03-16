<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.List"%>
<html>
	<head>
		<title>Clase36 - Inicio java web</title>
	</head>
	<body>
		<h1>Clase36</h1>
		
		
		<!-- 
		quiero capturar el listado que envio el servlet bajo el 
		nombre LISTADO
		-->
		
		<% //SCRIPTLET >CODIGO JAVA
		   //Dentro de la jsp tengo un objeto implicito llamado request
		   
		   //PRIMERO
		   Object listadoObject=request.getAttribute("LISTADO");
		   
		//puedo castear
		List<Articulos> listado = (List<Articulos>)listadoObject;
		%>
		
		<%
		//recorrer el listado e ir construyendo el codigo en un parrafo
		for(Articulos art: listado){
		%>	
		<!-- puedo poner html puro y usar el objeto art -->	
		<p><%=art.getTitulo()%></p>
		<%	
		}
		%>
		
	</body>
</html>