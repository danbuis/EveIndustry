<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Blueprint</title>
</head>
<body>
	<div id="global">
		<form:form commandName = "player" action="delete_blueprint_verify" method="post">
			<fieldset>
				<legend>Select Blueprint to Delete</legend>
				<p>
					<form:select path ="blueprints" items="${blueprintList}"
					itemLabel="name" multiple="false"/>
				</p>
					<p id="buttons">
					<input id="submit" type="submit" tabindex="1" name="confirmDelete" value="Delete">
					<input id="submit" type="submit" tabindex="2" name="cancelDelete" value="Cancel">
				</p>
			</fieldset>
		</form:form>
	</div>

</body>
</html>