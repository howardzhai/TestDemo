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
<script type="text/javascript" src="<c:url value="/resources/js/procedure.js" />"> </script> 
	
	<link href="<c:url value="/resources/css/procedure.css" />" rel="stylesheet">
</head>
<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">
		<div class="procedure">
			<header>
				<h4><a title="CreateProcedure">Step 2: Procedure</a></h4>				
			</header>
			<footer>
				<h2><a title="definition">Definition: Add procedure to your checklist</a></h2>
			</footer>						
						
			
			<form:form method="POST" modelAttribute="procedurestep" action="procedurestepAction" enctype="multipart/form-data">
				<table>
 				
			<div class="procedure_step" id="procedure_step" >
				
					<tr>
						<td><form:label path="step_title">Step Title:</form:label></td>
						<td><form:input path="step_title" id="step_title"/></td>
						<td><form:errors path="step_title" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="step_details">Step Details:</form:label></td>
						<td><form:input path="step_details" id="step_details" /></td>
						<td><form:errors path="step_details" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="procedure_file">Add your procedure file:</form:label></td>
						<td><form:input type="file" path="procedure_file" id="procedure_file"/></td>
						<td><form:errors path="procedure_file" cssClass="error" /></td>
					</tr>	
		
				</div>	

					<tr>
						<td><form:label path="tutoriol_video_url">Tutorial Video URL</form:label></td>
						<td><form:input path="tutoriol_video_url" id="tutoriol_video_url" placeholder="Embed a link to your procedure"/></td>
						<td><form:errors path="tutoriol_video_url" cssClass="error" /></td>
					</tr>
					
					<tr>	
					    <td><input  class="green button"  type="button" onclick="javascript:history.back(-1);" value="return"></td>	
						<td><input class="green button" type="submit" value="Next->" ></td>
					</tr> 	
					
				</table>				
			</form:form>
			
					<input class="green button" type="button" value="Add More Steps" id="add_procedure_button" />
					<input  id="delete_procedure_button" class="green button" type="button" value="Delete Last Step" id="delete_procedure_button" />		 		
		</div>
		<div class="footer" id="footer"></div>		
		</div>
	</div>
</body>
</html>