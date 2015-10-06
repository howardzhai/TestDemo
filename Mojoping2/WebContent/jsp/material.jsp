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
    <script type="text/javascript" src="<c:url value="/resources/js/material.js" />"> </script> 
	
	<link href="<c:url value="/resources/css/procedure.css" />" rel="stylesheet">
</head>
<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">
		<div class="procedure">
			<header>
				<h4><a title="CreateMaterials">Step 3: Materials</a></h4>				
			</header>
			<footer>
				<h2><a title="definition">Definition: Add Material to your checklist</a></h2>
			</footer>						
			

			<form:form  id="material_form" method="POST" modelAttribute="material" action="materialAction" enctype="multipart/form-data">
				<table>
 				
			 <div class="material_step" id="material_step" > 
				
					<tr>
						<td><form:label path="material_name">Material Name:</form:label></td>
						<td><form:input path="material_name" id="material_name"/></td>
						<td><form:errors path="material_name" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="coverage">Coverage:</form:label></td>
						<td><form:input path="coverage" id="coverage" name="coverage"/></td>
						<td><form:errors path="coverage" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="quantity">Quantity:</form:label></td>
						<td><form:input path="quantity" id="quantity" name="quantity"/></td>
						<td><form:errors path="quantity" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="material_file">Add your material file:</form:label></td>
						<td><form:input type="file" path="material_file" id="material_file"/></td>
						<td><form:errors path="material_file" cssClass="error" /></td>
					</tr>	
		
				<br>
					
					<tr>	
					    <td><input  class="green button"  type="button" onclick="javascript:history.back(-1);" value="return"></td>	
						<td><input class="green button" type="submit" value="Next->" ></td>
					</tr> 	
					
				</table>				
			</form:form>
			
					<input class="green button" type="button" value="Add More Steps" id="add_material_button" />
					<input  id="delete_material_button" class="green button" type="button" value="Delete Last Step" id="delete_procedure_button" />	
							
		</div>
		<div class="footer" id="footer"></div>		
		</div>
	</div>
</body>
</html>