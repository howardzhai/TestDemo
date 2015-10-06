<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
	<link href="<c:url value="/resources/css/create_checklist.css" />" rel="stylesheet">
	
</head>
<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">		
		<div class="checklist_info">
			<header>
				<h4><a title="CreateChecklist">Create Checklist</a></h4>				
			</header>										

			<form:form method="POST" modelAttribute="checklist" action="createChecklistAction">
				<table>
					<tr>
						<td><form:label path="category_id">Select Category</form:label></td>
						<td><form:select class="dropdown" path="category_id" id="category_id" disabled="disabled">
						    	<c:forEach items="${category}" var="category">
						          <form:option value="${category.category_id}">${category.category_name}</form:option>
						        </c:forEach>
						    </form:select>
						</td>
						<td><form:errors path="category_id" cssClass="error" /></td>
					</tr>	
					<tr>
						<td><form:label path="subcategory_id">Select SubCategory</form:label></td>
						<td><form:select class="dropdown" path="subcategory_id" id="subcategory_id" disabled="true">
						    	<form:option value="">Select Subcategory</form:option>
						    </form:select>
						</td>
						<td><form:errors path="subcategory_id" cssClass="error" /></td>
					</tr>	
				
					<tr>
						<td><form:label path="title">Suggest Category</form:label></td>
						<td><form:input path="title" id="title"/></td>
						<td><form:errors path="title" cssClass="error" /></td>
					</tr>			
					<tr>
						<td><form:label path="title">Title</form:label></td>
						<td><form:input path="title" id="title"/></td>
						<td><form:errors path="title" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="brief_info">Brief Info</form:label></td>
						<td><form:textarea path="brief_info" id="brief_info" placeholder="Write a short description of your checklist (Max:150 ch.)" rows="3" maxlength="150"/></td>
						<td><form:errors path="brief_info" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="keywords">Keywords</form:label></td>
						<td><form:input path="keywords" id="keywords" placeholder="Ex: Auto, Construction etc." rows="3" maxlength="150"/></td>
						<td><form:errors path="keywords" cssClass="error" /></td>
					</tr>	
					<tr>
						<td><form:input path="share" id="share" type="hidden" value="0"/></td>
						<td><form:errors path="share" cssClass="error" /></td>
					</tr>		
					<tr>		
						<td><input class="green button "type="submit" value="Next->" ></td>
					</tr> 		
				</table>
				
			</form:form>	

		<div class="videotut">
			<iframe width="400" height="225" src="http://www.youtube.com/embed/Ryu-m-5oG_c"></iframe>
		</div>			
		</div>
		<div class="footer" id="footer"></div>		
	</div>	
	</div>
</body>
</html>