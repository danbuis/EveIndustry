<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Player assets</title>
</head>
<body>
	<div id="global">
		<h1>Minerals and Components</h1>
		<table>
		<tr>
			<th>Resource Type</th>
			<th>Quantity</th>
			<th>Value</th>
		</tr>
		<c:forEach items="${resources}" var ="resource">
		<tr>
			<td>${resource.type}</td>
			<td>${resource.quantity}</td>
			<td>${resource.value}</td>
		</tr>
		</c:forEach>
		</table>
		<table>
		<tr>
			<td><a href="ore_refine">Refine Ores </a></td>
			<td><a href="items_purchase">Add Purchased Items </a></td>
			<td><a href="nerd">Set Market Values</a></td>
		</tr>
		</table>
		
		<h1>Blueprints</h1>
		<a href="<c:url value="/new_blueprint"/>">Add Blueprint</a>
		<table>
		<tr>
			<th>Name</th>
			<th>Production Efficiency</th>
			<th>Material Efficiency</th>
			<th>&nbsp</th>
		</tr>
		<c:forEach items="${blueprints}" var ="blueprint">
		<tr>
			<td>${blueprint.name}</td>
			<td>-${blueprint.productionEfficiency}%</td>
			<td>-${blueprint.materialEfficiency}%</td>
			<td><a href="blueprint_edit/${blueprint.id}">Edit </a></td>
		</tr>
		</c:forEach>	
		</table>
	</div>
</body>
</html>