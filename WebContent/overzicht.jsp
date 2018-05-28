<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="nl.project.*, static nl.project.web.IndexServlet.slotList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Overzicht</title>
</head>
<body>

<h1>Werknemers:</h1>
	<ul>
	<% for (Werknemer w :  nl.project.web.IndexServlet.werknemerList) { %>
		<li><%= w.getNaam() %></li>
	<% } %>
	</ul>

<h1>Slots:</h1>

	<ul>
	<% for (Slot s :  slotList) { %>
		<li><%= s.geefInfo()%></li>
	<% } %>
	</ul>
	
<p><a href="/Project/index.html">Terug naar de beginpagina</a>

</body>
</html>