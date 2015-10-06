<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
<head>
	<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.animate-colors-min.js" />"></script>

	<script src="<c:url value="/resources/js/jquery_header.js" />"></script>
	<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
</head>
<header class="header">
	<div id="inner-header">

		<div id="logo">
			<a href="/Mojoping2/" rel="nofollow"> <img src="images/mojoping_logo.png" />
			</a>
		</div>
       		<sec:authorize access="isAuthenticated()">
			<div id="header_user_greeting" class="header-login-box"> 
				<label>Welcome back <span id="head_username"><sec:authentication property="principal.username" /></span> !</label>
				<input class="button green" type="button" value="Profile" onclick="javascript:window.location.href='/Mojoping2/profile';"/>				
 				<input class="button green" type="button" value="Logout" onclick="javascript:window.location.href='/Mojoping2/logout';"/>
 				<input class="button highlight big" type="button" value="Create a Checklist" onclick="javascript:window.location.href='/Mojoping2/create_checklist';"/>		
			
			</div>
 

		    
		</sec:authorize>
        	<sec:authorize access="isAnonymous()">
			<div id="login_box" class="header-login-box">
				<form>
					<form:errors path="loginError" cssClass="error" />
					
					<label for="j_username">Login:</label> 
					<input type="text" id="j_username" name="j_username" placeholder="Username"/> 
					
					<label for="j_password">Password:</label> 
					<input  type="password" id="j_password" name="j_password" placeholder="Password"/> 
					
					<label class="forCheckbox" for='_spring_security_remember_me'> Remember me: 
						<input type='checkbox' id="_spring_security_remember_me" name='_spring_security_remember_me' />
					</label> 
					
					<input class="button green"type="submit" value="Login" onclick="return performLogin();"/>	
                      <!-- <div id="header_register_link" >-->
                    <!-- Add create user account link -->
                     <input class="button green" type="button" value="Create a new account" onclick="javascript:window.location.href='/Mojoping2/register';"/>	
                    <!--<a href="/Mojoping2/register">Create a new account</a>
            </div>	-->	
            		<input class="button big highlight" type="button" value="Create a Checklist" onclick="javascript:window.location.href='/Mojoping2/create_checklist';"/>
            	
            		<div id="header_login_error"><p>Invalid not confirm<p></div>	
				</form>
			
            
            
        	    	
			 <!--<div id="create-checklist" class="header-create-checklist">
				<a href="/Mojoping2/create_checklist">Create a Checklist</a>
			</div>-->	
	
	   </div>
          
		</sec:authorize>

		<div id="nav-drop">
			<nav id="navigation">
			    <hr id="headline" size="2" style="left:0"/>
				<hr  id="headline" size="2" style="right:0"/>
				<sec:authorize access="isAnonymous()"><ul id="menu" style="padding-left: 70px; width:900px;" ></sec:authorize>
				<sec:authorize access="isAuthenticated()"><ul id="menu" style="padding-left: 70px; width:1200px;" ></sec:authorize>
					<li id="menu-home"><a href="/Mojoping2">HOME</a></li>
					<sec:authorize access="isAuthenticated()"><li id="menu-checklists"><a href="/Mojoping2/userchecklists">MyCHECKLISTS</a></li></sec:authorize>
					<li id="menu-checklists"><a href="/Mojoping2/checklists">CHECKLISTS</a></li>
					<li id="menu-about"><a href="#">ABOUT</a></li>
					<li id="menu-contact"><a href="#">CONTACT</a></li>
				</ul>
			</nav>
		</div>
       
      
		
	
<div style="clear:both;width:100%;display:block"></div>   
</div>	
</header>
</html>