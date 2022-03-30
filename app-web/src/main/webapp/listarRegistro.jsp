<%@page import="com.google.protobuf.TextFormat.Printer"%>
<%@page import="ar.com.educacionit.domain.RegistroUsuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>

<html>
	<head>
		<title>Usuarios Registrados</title>
	</head>
		<body>
			<h1 align="center">Usuarios Registrados</h1>
			<main>
				<section>
					<table BORDER="1" align="center">
										<% //SCRIPTLET >CODIGO JAVA
					   //Dentro de la jsp tengo un objeto implicito llamado request
					   //PRIMERO
						Object listadoObject=request.getAttribute("Listado");
						//puedo castear
						ArrayList<RegistroUsuario> listado=(ArrayList<RegistroUsuario>)listadoObject;
						String datos=" ";
						for(RegistroUsuario aux: listado){
			
					%>
						<tr><td>
						 <p><%=aux+""%></p></tr> 
						  
					<%	
					}
					%>
					
					</td>
					</table>
					<form action="/app-web/html/registroDatos.html" align="center">
						 <hr>
							 <input type="submit" value="Regresar"></form>
						 <hr>
				</form>
				</section>
			</main>
		</body>
</html>