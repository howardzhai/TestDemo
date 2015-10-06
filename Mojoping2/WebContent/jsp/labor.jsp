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
    <script type="text/javascript" src="<c:url value="/resources/js/labor.js" />"> </script> 
	
	<link href="<c:url value="/resources/css/labor.css" />" rel="stylesheet">
</head>
<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">
		<div class="procedure">
			<header>
				<h4><a title="CreateLabors">Step 3: Labors</a></h4>				
			</header>
			<footer>
				<h2><a title="definition">Definition: Add Labor to your checklist</a></h2>
			</footer>						
						
			
			<form:form method="POST" modelAttribute="labor" action="laborAction" enctype="multipart/form-data">
				<table>
 				
			 <div class="labor_step" id="labor_step" > 
				
					<tr>
						<td><form:label path="labor_task">Task:</form:label></td>
						<td><form:input path="labor_task" id="labor_task"/></td>
						<td><form:errors path="labor_task" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="labor_num_people">Number of People:</form:label></td>
						<td><form:input path="labor_num_people" id="labor_num_people" /></td>
						<td><form:errors path="labor_num_people" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="labor_num_hour">Number of Hour:</form:label></td>
						<td><form:input path="labor_num_hour" id="labor_num_hour" /></td>
						<td><form:errors path="labor_num_hour" cssClass="error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="labor_hourly_cost">Hourly Cost:</form:label></td>
						<td><form:input path="labor_hourly_cost" id="labor_hourly_cost" /></td>
						<td><form:errors path="labor_hourly_cost" cssClass="error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="labor_insurance">Labor Insurance:</form:label></td>
						<td><form:input path="labor_insurance" id="labor_insurance" /></td>
						<td><form:errors path="labor_insurance" cssClass="error" /></td>
					</tr>
					
					<tr>
						<td><form:label path="labor_detail">Details:</form:label></td>
						<td><form:input path="labor_detail" id="labor_detail" /></td>
						<td><form:errors path="labor_detail" cssClass="error" /></td>
					</tr>

		         </div>
				<br>
					
					<tr>	
					    <td><input  class="green button"  type="button" onclick="javascript:history.back(-1);" value="return"></td>	
						<td><input class="green button" type="submit" value="Next->" ></td>
					</tr> 	
					
				</table>				
			</form:form>
			
					<input class="green button" type="button" value="Add More Steps" id="add_labor_button" />
					<input  id="delete_labor_button" class="green button" type="button" value="Delete Last Step" id="delete_labor_button" />		 		
		</div>
		<div class="footer" id="footer"></div>		
		</div>
	</div>
</body>
</html>