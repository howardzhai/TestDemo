<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<head>
	<title>MOJOPING | Confirm your identity</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
	
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>	
	<script type="text/javascript" src="<c:url value="/resources/js/confirmation.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/header.js" />"> </script>
	
	<link href="<c:url value="/resources/css/confirmation.css" />" rel="stylesheet">
	

</head>

<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">		
		<div id="lead">
			<div id="lead-confirmaton" class="confirmation-body">
				
				<label>PLEASE CONFIRM YOUR IDENTITY!</label>
				
				<form:form method="POST" modelAttribute="confirmation" action="confirm_user">
					<table>
						<tr>
							<td><form:label path="username">Username</form:label></td>
							<td><form:input path="username" id="username" value="" /></td>
							<td><form:errors path="username" cssClass="error" /></td>
						</tr>
						<tr>
							<td><form:label path="confirmation_id">Confimation Code</form:label></td>
							<td><form:input path="confirmation_id" id="confirmation_id" value="" />	</td>
							<td><form:errors path="confirmation_id" cssClass="error" /></td>
						</tr>	
						<tr>			
	 						<td><input class="button green" type="submit" value="Submit" > </td>
	 					</tr>
	 				</table> 
				</form:form>				
					
				<div id="result"></div>
			</div>		
		</div>
		
</div>
	</div>
</body>
</html>
