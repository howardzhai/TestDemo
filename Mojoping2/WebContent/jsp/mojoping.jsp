<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<head>
	<title>MOJOPING | Create your checklist</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
	
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
	<link href="<c:url value="/resources/css/mojoping.css" />" rel="stylesheet">
	
	<script type="text/javascript" src="<c:url value="/resources/js/mojoping.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/header.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/footer.js" />"> </script>
	

</head>

<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">
		<div id="welcome">
		<p>
		Welcome to Mojoping!<br>
		WASHINGTON — President Obama will put forward his strategy for confronting Islamic State militants this week, meeting with congressional leaders Tuesday and giving a televised address Wednesday.

"This is not going to be an announcement about U.S. ground troops. This is not the equivalent of the Iraq War," he said on NBC's Meet the Press Sunday. "What this is is similar to the kinds of counterterrorism campaigns that we've been engaging in consistently over the last five, six, seven years."

Obama gave few details on his "game plan," other than to say the United States would "start going on some offense" against the Islamic militant group, also referred to by the acronyms ISIL (Islamic State of Iraq and the Levant) or ISIS (Islamic State of Iraq and Syria).
		</p>
		</div>
		
		<div id="lead">
			<div id="lead-search" class="search-body">
			
				<form:form method="POST"  modelAttribute="category" action="search_category">
					<table>
						<tr>
						    <td><select class="green button" style="height:50px" NAME="category_search" id="category_search" >  
  									<option value ="1">All</option>  
  									<option value ="2">Category</option>  
  									<option value="3">SubCategory</option>  
  									<option value="4">Checklist</option> 
  									<option value="5">Procedure</option>  
  									<option value="6">Material</option>  
  									<option value="7">Labor</option>  
								</select>  </td> 
							<td><form:input class ="rounded" style="width:500px;height:50px;" path="category_name" id="category_name" value="" placeholder="Search Category"/></td>
							<td><input class="button green big" type="submit" value="Search" ></td>
						</tr>
						<tr>
		 					<td><form:errors path="category_name" cssClass="error" /></td>	
	 					</tr>
 					</table>
				</form:form>				
					
				<div id="result"></div>
			</div>		
		</div>
		<div class="footer" id="footer"></div>
</div>
		
	</div>
</body>
</html>
