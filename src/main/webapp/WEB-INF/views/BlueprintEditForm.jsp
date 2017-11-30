<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%-- import for jsp tags --%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%-- import for spring form tags --%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blueprint Edit Form</title>
</head>
<body>
	<div id="global">
		<form:form commandName="blueprint" action="${pageContext.request.contextPath}/blueprint_update" method="post">
			<fieldset>
				<legend>${blueprint.name}</legend>
				<form:hidden path="id"/>
				<p>
					<label for="name">Name: </label>
					<form:input path="name"/> 
				</p>
				<p>
					<label for="productionEfficiency">Production Efficiency: </label>
					<form:input id="productionEfficiency" path="productionEfficiency"/>
				</p>
				<p>
					<label for="materialEfficiency">Material Efficiency: </label>
					<form:input id="materialEfficiency" path="materialEfficiency"/>
				</p>
				
				
				<legend>Materials Required</legend> 
				<c:forEach items="${blueprint.resources}" var="resource" varStatus="stat">	
				
				<table>
					<tr>
						<td><form:input  path="resources[${stat.index}].type"/></td>
						<td><form:input  path="resources[${stat.index}].quantity"/></td>
					</tr>
				</table>
				</c:forEach>
				 
				<p id="buttons">
					<input id="reset" type="reset" tabindex="1">
					<input id="submit" type="submit" tabindex="2" name="updateComplete" value="Update">
					<input id="submit" type="submit" tabindex="3" name="addResource" value="Add a resource">
				</p>
				
			</fieldset>
		</form:form> 
	</div>
</body>
</html>