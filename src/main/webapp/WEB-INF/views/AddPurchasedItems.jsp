<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%-- import for spring form tags --%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Purchased Items</title>
</head>
<body>
	<h1>Add Purchased Item</h1>
	<div id="global">
		<form:form commandName="stack" action="update_resource_stacks" method="post">
			<p>
			<label for="type">Name of item: </label>
			<form:input path="type"/>
			</p>
			<p>
			<label for="quantity">Quantity: </label>
			<form:input path="quantity"/>
			</p>
			<p>
			<label for="value">Total Cost: </label>
			<form:input path="value"/>
			</p>
			<p id="buttons">
				<input id="reset" type="reset" tabindex="1">
				<input id="submit" type="submit" tabindex="2"  value="Add item to assets">				
			</p>		
		</form:form>
	</div>
</body>
</html>