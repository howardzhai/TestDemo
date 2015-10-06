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
    <script type="text/javascript" src="<c:url value="/resources/js/overhead.js" />"> </script> 
	
	<link href="<c:url value="/resources/css/procedure.css" />" rel="stylesheet">
</head>
<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">
		<div class="procedure">
			<header>
				<h4><a title="CreateOverhead">Step 4: Overhead</a></h4>				
			</header>
			<footer>
				<h2><a title="definition">Definition: The indirect costs or fixed expenses of operating a business</a></h2>
			</footer>						
							
			
			<form:form method="POST" modelAttribute="overhead" action="overheadAction" enctype="multipart/form-data">
				<table>
 				
			 <div class="overhead_step" id="overhead_step" > 
				
					<tr>
						<td><form:label path="overhead_cost">Overhead Cost:</form:label></td>
						<td><form:input path="overhead_cost" id="overhead_cost"/></td>
						<td><form:errors path="overhead_cost" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="overhead_detail">Overhead Detail:</form:label></td>
						<td><form:input path="overhead_detail" id="overhead_detail" /></td>
						<td><form:errors path="overhead_detail" cssClass="error" /></td>
					</tr>
		
</div>
		
				<br>
					
					<tr>	
					    <td><input  class="green button"  type="button" onclick="javascript:history.back(-1);" value="return"></td>	
						<td><input class="green button" type="submit" value="Next->" ></td>
					</tr> 	
					
				</table>				
			</form:form>
			
					<input class="green button" type="button" value="Add More Steps" id="add_overhead_button" />
					<input  id="delete_overhead_button" class="green button" type="button" value="Delete Last Step" id="delete_overhead_button" />		 		
		</div>
		<div class="footer" id="footer"></div>		
		</div>
	</div>
</body>
</html>