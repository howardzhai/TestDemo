<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
<head>
	<title>MOJOPING | Create your checklist</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
	
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
	<link href="<c:url value="/resources/css/register.css" />" rel="stylesheet">
	
	<script type="text/javascript" src="<c:url value="/resources/js/register.js" />"> </script>	
	<script type="text/javascript" src="<c:url value="/resources/js/header.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/footer.js" />"> </script>
</head>
<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">		
		<div id="lead" >
			<div id="lead-register" class="register-body">
				<sec:authorize access="isAnonymous()">
					<form:form method="POST" modelAttribute="user" action="register_user" >
						<table>
							<tr>
								<td><form:label path="username">Username</form:label></td>
								<td><form:input path="username" id="username"/></td>
								<td><form:errors path="username" cssClass="error" /></td>
								
							</tr>		
							<tr>
								<td><form:label path="firstname">First Name</form:label></td>
								<td><form:input path="firstname" id="firstname"/></td>
								<td><form:errors path="firstname" cssClass="error" /></td>
							</tr>	
							<tr>
								<td><form:label path="lastname">Last Name</form:label></td>
								<td><form:input path="lastname" id="lastname"/></td>
								<td><form:errors path="lastname" cssClass="error" /></td>
							</tr>	
							<tr>
								<td><form:label path="gender">Gender</form:label></td>
								<td><form:select path="gender" id="gender">
								    	<form:option value="" label="--- Select ---" />
								    	<form:option value="male" label="Male" />
								    	<form:option value="female" label="Female" />
								    </form:select>
								</td>
								<td><form:errors path="gender" cssClass="error" /></td>
							</tr>	
							<tr>
								<td><form:label path="email">Email</form:label></td>
								<td><form:input type="email" path="email" id="email" /></td>
								<td><form:errors path="email" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="password">Password</form:label></td>
								<td><form:input type="password" path="password" id="password" /></td>
								<td><form:errors path="password" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="contact_number">Contact Number</form:label></td>
								<td><form:input path="contact_number" id="contact_number" /></td>
								<td><form:errors path="contact_number" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="date_of_birth">Date of Birth</form:label></td>
								<td><form:input path="date_of_birth" id="date_of_birth" placeholder="MM/DD/YYYY" /></td>
								<td><form:errors path="date_of_birth" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="skills">Skills</form:label></td>
								<td><form:input path="skills" id="skills" /></td>
								<td><form:errors path="skills" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="occupation">Occupation</form:label></td>
								<td><form:input path="occupation" id="occupation" /></td>
								<td><form:errors path="occupation" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="address_1">Address Line - 1</form:label></td>
								<td><form:input path="address_1" id="address_1" /></td>
								<td><form:errors path="address_1" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="address_2">Address Line - 2</form:label></td>
								<td><form:input path="address_2" id="address_2" /></td>
								<td><form:errors path="address_2" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="city">City</form:label></td>
								<td><form:input path="city" id="city" /></td>
								<td><form:errors path="city" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="state">State</form:label></td>
								<td><form:input path="state" id="state" /></td>
								<td><form:errors path="state" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="zipcode">Zipcode</form:label></td>
								<td><form:input path="zipcode" id="zipcode" /></td>
								<td><form:errors path="zipcode" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="country">Country</form:label></td>
								<td><form:input path="country" id="country" /></td>
								<td><form:errors path="country" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="twitter_url">Twitter URL</form:label></td>
								<td><form:input path="twitter_url" id="twitter_url" /></td>
								<td><form:errors path="twitter_url" cssClass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="facebook_url">Facebook URL</form:label></td>
								<td><form:input path="facebook_url" id="facebook_url" /></td>
								<td><form:errors path="facebook_url" cssClass="error" /></td>
							</tr>	
											
							<tr>		
		 						<td><input class="green button" type="submit" value="Register to Mojoping!" ></td>
		 					</tr>  
						</table>
					</form:form>	
				</sec:authorize>	
				
				<sec:authorize access="isAuthenticated()">
					<p>You are already our one of valuable member ! </p>
		    
				</sec:authorize>		
					
			</div>		
		</div>
		<div class="footer" id="footer"></div>

</div>
	</div>
</body>
</html>
