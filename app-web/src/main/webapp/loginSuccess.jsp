<%@page import="ar.com.educacionit.domain.Users" %>
<%
Users user=(Users)session.getAttribute("usuario");
%>


<html>

	<head>
	
	</head>
	
	<body>
	
		<main>
			<h1>Username:  <%=user.getUsername() %></h1>
			<h2>Nombre:  <%=user.getSocio().getNombre() %></h2>
			<h3>Apellido:  <%=user.getSocio().getApellido() %></h3>
			<a href="<%=request.getContextPath()%>/BuscarProductosServlet">Ver listado</a>
		</main>
	</body>
</html>