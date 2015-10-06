<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<title>Mojoping | Create Checklist</title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
	
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
	
	<script type="text/javascript" src="<c:url value="/resources/js/header.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/create_checklist.js" />"> </script>	
	<script type="text/javascript" src="<c:url value="/resources/js/footer.js" />"> </script>
    <script type="text/javascript" src="<c:url value="/resources/js/garbage.js" />"> </script>  
	
	<link href="<c:url value="/resources/css/procedure.css" />" rel="stylesheet">
</head>
<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">
		<div class="procedure">
			<header>
				<h4><a title="CreateGarbage">Step 6: Garbage</a></h4>				
			</header>
			<footer>
				<h2><a title="definition">Definition: Add Garbage to your checklist</a></h2>
			</footer>						
					
			
			<form:form method="POST" modelAttribute="garbage" action="garbageAction" enctype="multipart/form-data">
				<table>
 				
			 <div class="garbage_step" id="garbage_step" > 
				
					<tr>
						<td><form:label path="garbage_cost">Garbage Cost:</form:label></td>
						<td><form:input path="garbage_cost" id="garbage_cost"/></td>
						<td><form:errors path="garbage_cost" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="garbage_detail">Garbage Detail:</form:label></td>
						<td><form:input path="garbage_detail" id="garbage_detail" /></td>
						<td><form:errors path="garbage_detail" cssClass="error" /></td>
					</tr>
		
</div>
		
				<br>
					
					<tr>	
					    <td><input  class="green button"  type="button" onclick="javascript:history.back(-1);" value="return"></td>	
						<td><input class="green button" type="submit" value="Next->" ></td>
					</tr> 	
					
				</table>				
			</form:form>
			
					<input class="green button" type="button" value="Add More Steps" id="add_garbage_button" />
					<input  id="delete_garbage_button" class="green button" type="button" value="Delete Last Step" id="delete_garbage_button" />		 		
		</div>
		<div class="footer" id="footer"></div>		
		</div>
	</div>
</body>
</html>