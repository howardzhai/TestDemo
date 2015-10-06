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
	
	<script type="text/javascript" src="<c:url value="/resources/js/profile.js" />"> </script>	
	<script type="text/javascript" src="<c:url value="/resources/js/header.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/footer.js" />"> </script>
</head>

<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">
		<div id="profile-body">
		<sec:authorize access="isAuthenticated()">
			<form:form method="POST"  modelAttribute="fileUpload" action="edit_picture" enctype="multipart/form-data">	
				<tr>
					<td><img src="${profilePicture}" height="100" width="100"/></td>				
					<td><label>Change profile picture:</label></td> 
					<td><input type="file" name="file" id="file"></td>
					<td><input class="button green" type="submit" value="upload" ></td>
					<td><form:errors path="file" cssClass="error" /></td>
				</tr>									 
			</form:form>			
			<form:form method="POST" modelAttribute="user" action="edit_user">
				<table>						
					<tr>
						<td><form:label path="username">Username</form:label></td>
						<td><form:label class="profile-label" path="username" id="username">${user.username}</form:label></td>
						<td><form:input class="profile-input-edit" path="username" id="username" value="${user.username}" readonly="t"/></td>
						<td><form:errors path="username" cssClass="error" /></td>
					</tr>		
					<tr>
						<td><form:label path="firstname">First Name</form:label></td>
						<td><form:label class="profile-label" path="firstname" id="firstname">${user.firstname}</form:label></td>
						<td><form:input class="profile-input-edit" path="firstname" id="firstname" placeholder="${user.firstname}" /></td>
						<td><form:errors path="firstname" cssClass="error" /></td>
					</tr>	
					<tr>
						<td><form:label path="lastname">Last Name</form:label></td>
						<td><form:label class="profile-label" path="lastname" id="lastname">${user.lastname}</form:label></td>
						<td><form:input class="profile-input-edit" path="lastname" id="lastname" placeholder="${user.lastname}" /></td>
						<td><form:errors path="lastname" cssClass="error" /></td>
					</tr>	
					<tr>
						<td><form:label path="gender">Gender</form:label></td>
						<td><form:label class="profile-label" path="gender" id="gender">${user.gender}</form:label></td>
						<td><form:select class="profile-input-edit" path="gender" id="gender" placeholder="${user.gender}" >
						    	<form:option value="" label="--- Select ---" />
						    	<form:option value="male" label="Male" />
						    	<form:option value="female" label="Female" />
						    </form:select>
						</td>
						<td><form:errors path="gender" cssClass="error" /></td>
					</tr>	
					<tr>
						<td><form:label path="email">Email</form:label></td>
						<td><form:label class="profile-label" type="email" path="email" id="email">${user.email}</form:label></td>
						<td><form:input class="profile-input-edit" path="email" id="email" placeholder="${user.email}" /></td>
						<td><form:errors path="email" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="password">Password</form:label></td>
						<td><form:label class="profile-label" type="password" path="password" id="password">****</form:label></td>
						<td><form:input class="profile-input-edit" path="password" id="password" placeholder="${user.password}" /></td>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="contact_number">Contact Number</form:label></td>
						<td><form:label class="profile-label" path="contact_number" id="contact_number">${user.contact_number}</form:label></td>
						<td><form:input class="profile-input-edit" path="contact_number" id="contact_number" placeholder="${user.contact_number}" /></td>
						<td><form:errors path="contact_number" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="date_of_birth">Date of Birth</form:label></td>
						<td><form:label class="profile-label" path="date_of_birth" id="date_of_birth">${user.date_of_birth}</form:label></td>
						<td><form:input class="profile-input-edit" path="date_of_birth" id="date_of_birth" placeholder="${user.date_of_birth}" /></td>
						<td><form:errors path="date_of_birth" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="skills">Skills</form:label></td>
						<td><form:label class="profile-label" path="skills" id="skills">${user.skills}</form:label></td>
						<td><form:input class="profile-input-edit" path="skills" id="skills" placeholder="${user.skills}" /></td>
						<td><form:errors path="skills" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="occupation">Occupation</form:label></td>
						<td><form:label class="profile-label" path="occupation" id="occupation">${user.occupation}</form:label></td>
						<td><form:input class="profile-input-edit" path="occupation" id="occupation" placeholder="${user.occupation}" /></td>
						<td><form:errors path="occupation" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="address_1">Address Line - 1</form:label></td>
						<td><form:label class="profile-label" path="address_1" id="address_1">${user.address_1}</form:label></td>
						<td><form:input class="profile-input-edit" path="address_1" id="address_1" placeholder="${user.address_1}" /></td>
						<td><form:errors path="address_1" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="address_2">Address Line - 2</form:label></td>
						<td><form:label class="profile-label" path="address_2" id="address_2">${user.address_2}</form:label></td>
						<td><form:input class="profile-input-edit" path="address_2" id="address_2" placeholder="${user.address_2}" /></td>
						<td><form:errors path="address_2" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="city">City</form:label></td>
						<td><form:label class="profile-label" path="city" id="city">${user.city}</form:label></td>
						<td><form:input class="profile-input-edit" path="city" id="city" placeholder="${user.city}" /></td>
						<td><form:errors path="city" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="state">State</form:label></td>
						<td><form:label class="profile-label" path="state" id="state">${user.state}</form:label></td>
						<td><form:input class="profile-input-edit" path="state" id="state" placeholder="${user.state}" /></td>
						<td><form:errors path="state" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="zipcode">Zipcode</form:label></td>
						<td><form:label class="profile-label" path="zipcode" id="zipcode">${user.zipcode}</form:label></td>
						<td><form:input class="profile-input-edit" path="zipcode" id="zipcode" placeholder="${user.zipcode}" /></td>
						<td><form:errors path="zipcode" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="country">Country</form:label></td>
						<td><form:label class="profile-label" path="country" id="country">${user.country}</form:label></td>
						<td><form:input class="profile-input-edit" path="country" id="country" placeholder="${user.country}" /></td>
						<td><form:errors path="country" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="twitter_url">Twitter URL</form:label></td>
						<td><form:label class="profile-label" path="twitter_url" id="twitter_url">${user.twitter_url}</form:label></td>
						<td><form:input class="profile-input-edit" path="twitter_url" id="twitter_url" placeholder="${user.twitter_url}" /></td>
						<td><form:errors path="twitter_url" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="facebook_url">Facebook URL</form:label></td>
						<td><form:label class="profile-label" path="facebook_url" id="facebook_url">${user.facebook_url}</form:label></td>
						<td><form:input class="profile-input-edit" path="facebook_url" id="facebook_url" placeholder="${user.facebook_url}" /></td>
						<td><form:errors path="facebook_url" cssClass="error" /></td>
					</tr>
					
					<tr>
						<td><form:label  path="user_money">User account</form:label></td>
						<td><form:label class="profile-label" path="user_money" id="user_money">${user.user_money}</form:label></td>						
						<td><form:input class="profile-input-edit" path="user_money" id="user_money" placeholder="${user.user_money}" /></td>
						<td><form:errors path="user_money" cssClass="error" /></td>
						
					</tr>
					<tr>		
		 				<td><input class="button green" type="button" value="Edit" id="edit-profile" ></td>
		 				<td><input class="button green" type="submit" value="Submit" id="submit-profile" ></td>
		 			</tr>  
				</table>
			</form:form>	
		</sec:authorize>
		
		<sec:authorize access="isAnonymous()">
			<p>Please sign in or register to see your profile! </p>
		</sec:authorize>
		</div>
			<div class="footer" id="footer"></div>
		</div>
	</div>
</body>