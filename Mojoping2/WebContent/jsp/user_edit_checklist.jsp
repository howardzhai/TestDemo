<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<title>Mojoping | Checklists</title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
	
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
	<link href="<c:url value="/resources/css/user_edit_checklist.css" />" rel="stylesheet">
	
	<script type="text/javascript" src="<c:url value="/resources/js/header.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/user_edit_checklist.js" />"> </script>
</head>
<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">
<div id="check_list">
		
		
<form action="edit_checklist" method="Post">
		 <h style="font-size:30px;margin-left: 45%">Checklist:</h>
		 <button id="reset" class="green button" style="margin-left: 33%;">reset</button>
		 <input type="submit"  value="Submit" class="green button" id="submit"/>
		<c:forEach var="i" items="${checkList}">
		<div id="single_list" class="single_list" style="padding-top:20px;">
		<h style="font-size:22px">
        <c:out value="${i.title}" /></h><p>
        Keywords: <c:out value="${i.keywords}"/><p>
        Info:<c:out value="${i.brief_info}"/>
        <input style="font-size:30px;margin-left: 70%" type="checkbox" name="delete"  value="0"/>Delete
        <input type="hidden" value="0" name="deletevalue" />
        <input type="checkbox" name="share" value="${i.share}" />Share Public
        <input type="hidden" value="0" name="sharevalue" />
        <input type="text" style="height:10px;width:40px" value="${i.share_value}" name="value_need" />
		</div>
	    </c:forEach>
</form>	
	
		</div>
</div>
		
	</div>
</body>
</html>