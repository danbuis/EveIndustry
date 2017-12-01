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
<title>Update Resource Market Values</title>
</head>
<body>
	<div id="global">
		<form:form commandName="player" action="resource_update" method="post">
			<fieldset>
				<legend>Update Resource Market Values</legend>

				<c:forEach items="${player.marketValues}" var="resource" varStatus="stat">	
				
				<table>
					<tr>
						<td><form:input  path="marketValues[${stat.index}].type"/></td>
						<td><form:input  path="marketValues[${stat.index}].value"/></td>
					</tr>
				</table>
				</c:forEach>
				 
				<p id="buttons">
					<input id="reset" type="reset" tabindex="1">
					<input id="submit" type="submit" tabindex="2" value="Update Values">
				</p>
								
			</fieldset>
		</form:form> 
	</div>
</body>
</html>