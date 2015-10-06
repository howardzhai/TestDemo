<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
	<title>Mojoping | Checklists</title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">		
	
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>
	<link href="<c:url value="/resources/css/detail.css" />" rel="stylesheet">
	
	<script type="text/javascript" src="<c:url value="/resources/js/header.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/detail.js" />"> </script>
</head>
<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">
	     <h style="font-size:30px;margin-left: 45% ">Checklist:</h>
		 <button id="change_map" class="green button" style="margin-left: 30%;">Change Map</button>
		
<div id="check_list" >

<div id="single_list" class="single_list" style="padding-top:20px;">
        
<sec:authorize access="isAuthenticated()">        
<form  id = "checklist_form" name ="checklist_form" method="POST" modelAttribute="editchecklistobject" action="edit_checklist_action"> 

				<h style="font-size:30px"> Checklist:</h><br>
				<table>
				
					<tr>
					<td><input  name="user_match" id="user_match" type="hidden" value="${user_match}" /></td>
						
					</tr> 
					<tr>
					<td><input  name="username" id="username" type="hidden" value="${checkList.username}" /></td>
						
					</tr> 
				
					<tr>
					<td><input  name="checklist_id" id="checklist_id" type="hidden" value="${checkList.checklist_id}" /></td>
						
					</tr> 
				
					<tr>
						<td><label for="title">Title: </label></td>
						<td><label class="edit_label" >${checkList.title}</label></td>
						<td><input class="input-edit" name="title" id="title" value="${checkList.title}" /></td>
						
					</tr> 
					
					<tr>
						<td><label for="brief_info">Brief Info:</label></td>
						<td><label class="edit_label" >${checkList.brief_info}</label></td>
						<td><input class="input-edit" name="brief_info" id="brief_info" value="${checkList.brief_info}" /></td>
					
					</tr>
					
					<tr>
						<td><label for="keywords">Keywords:</label></td>
						<td><label class="edit_label" >${checkList.keywords}</label></td>
						<td><input class="input-edit" name="keywords" id="keywords" value="${checkList.keywords}" /></td>
						
					</tr>
				</table>
				
				
				<h style="font-size:20px"> Procedure:</h><br>
				<table>
				<c:forEach var="p" items="${procedureList}">
					<tr>
						<td><label for="step_title">Step Title: </label></td>
						<td><label class="edit_label" >${p.step_title}</label></td>
						<td><input class="input-edit" name="step_title" id="step_title" value="${p.step_title}" /></td>
					
					</tr> 
					
					<tr>
						<td><label for="step_details">Step Detail:</label></td>
						<td><label class="edit_label">${p.step_details}</label></td>
						<td><input class="input-edit" name="step_details" id="step_details" value="${p.step_details}" /></td>
					
					</tr>
					
					<tr>
						<td><label for="tutoriol_video_url">Tutorial Video URL:</label></td>
						<td><label class="edit_label" >${p.tutoriol_video_url}</label></td>
						<td><input class="input-edit" name="tutoriol_video_url" id="tutoriol_video_url" value="${p.tutoriol_video_url}" /></td>
						
					</tr>
					
					<tr></tr>
					</c:forEach>
				</table>
				<h style="font-size:20px"> Material:</h>
				
				<table>	
				<c:forEach var="m" items="${materialList}">
					<tr>
						<td><label for="material_name">Material name: </label></td>
						<td><label class="edit_label">${m.material_name}</label></td>
						<td><input class="input-edit" name="material_name" id="material_name" value="${m.material_name}" /></td>
						
					</tr> 
					
					<tr>
						<td><label for="coverage"> Material coverage:</label></td>
						<td><label class="edit_label">${m.coverage}</label></td>
						<td><input class="input-edit" name="coverage" id="coverage" value="${m.coverage}" /></td>
						
					</tr>
					
					<tr>
						<td><label for="quantity">Material quantity: </label></td>
						<td><label class="edit_label">${m.quantity}</label></td>
						<td><input class="input-edit" name="quantity" id="quantity" value="${m.quantity}" /></td>
					
					</tr>
	
					</c:forEach>
				</table>	
					
				<h style="font-size:20px"> Labor:</h><br>	
				<table>							
				<c:forEach var="la" items="${laborList}">
					<tr>
						<td><label for="labor_task">Task name: </label></td>
						<td><label class="edit_label">${la.labor_task}</label></td>
						<td><input class="input-edit" name="labor_task" id="labor_task" value="${la.labor_task}" /></td>
						
					</tr> 
					
					<tr>
						<td><label for="labor_num_people">Number of People: </label></td>
						<td><label class="edit_label" >${la.labor_num_people}</label></td>
						<td><input class="input-edit" name="labor_num_people" id="labor_num_people" value="${la.labor_num_people}" /></td>
						
					</tr>
					
					<tr>
						<td><label for="labor_num_hour"> Number of Hour: </label></td>
						<td><label class="edit_label" >${la.labor_num_hour} </label></td>
						<td><input class="input-edit" name="labor_num_hour" id="labor_num_hour" value="${la.labor_num_hour}" /></td>
					
					</tr>
					
					<tr>
						<td><label for="labor_hourly_cost"> Hourly Cost:</label></td>
						<td><label class="edit_label" > ${la.labor_hourly_cost}  </label></td>
						<td><input class="input-edit" name="labor_hourly_cost" id="labor_hourly_cost" value="${la.labor_hourly_cost}" /></td>
					
					</tr>
					
					<tr>
						<td><label for="labor_insurance">Labor Insurance: </label></td>
						<td><label class="edit_label" > ${la.labor_insurance}  </label></td>
						<td><input class="input-edit" name="labor_insurance" id="labor_insurance" value="${la.labor_insurance}" /></td>
					
					</tr>
					
					<tr>
						<td><label for="labor_detail">Detail:  </label></td>
						<td><label class="edit_label" > ${la.labor_detail}</label></td>
						<td><input class="input-edit" name="labor_detail" id="labor_detail" value="${la.labor_detail}" /></td>
					
					</tr>
					
					</c:forEach>
					</table>
					
					<h style="font-size:20px"> Overhead:</h><br>
					<table>
					<c:forEach var="ov" items="${overheadList}">
					<tr>
						<td><label for="overhead_cost"> Overhead Cost:</label></td>
						<td><label class="edit_label"> ${ov.overhead_cost}</label></td>
						<td><input class="input-edit" name="overhead_cost" id="overhead_cost" value="${ov.overhead_cost}" /></td>
						
					</tr> 
					
					<tr>
						<td><label for="overhead_detail"> Overhead Details: </label></td>
						<td><label class="edit_label"> ${ov.overhead_detail} </label></td>
						<td><input class="input-edit" name="overhead_detail" id="overhead_detail" value="${ov.overhead_detail}" /></td>
						
					</tr>
					
				
					</c:forEach>
					</table>
					
					<h style="font-size:20px"> Garbage:</h><br>
					<table>
					<c:forEach var="ga" items="${garbageList}">
					<tr>
						<td><label for="garbage_cost">Garbage Cost:</label></td>
						<td><label class="edit_label">  ${ga.garbage_cost} </label></td>
						<td><input class="input-edit" name="garbage_cost" id="garbage_cost" value="${ga.garbage_cost}" /></td>
						
					</tr> 
					
					<tr>
						<td><label for="garbage_detail"> Garbage Details: </label></td>
						<td><label class="edit_label">  ${ga.garbage_detail} </label></td>
						<td><input class="input-edit" name="garbage_detail" id="garbage_detail" value="${ga.garbage_detail}" /></td>
						
					</tr>			
					</c:forEach>
					</table>
					
					<h style="font-size:20px"> Insurance:</h><br>
					<table>	
					<c:forEach var="in" items="${insuranceList}">
					<tr>
						<td><label for="insurance_amount">Insurance Amount:</label></td>
						<td><label class="edit_label"> ${in.insurance_amount} </label></td>
						<td><input class="input-edit" name="insurance_amount" id="insurance_amount" value="${in.insurance_amount}" /></td>
						
					</tr> 
					
					<tr>
						<td><label for="insurance_detail">Insurance Details:  </label></td>
						<td><label class="edit_label"> ${in.insurance_detail} </label></td>
						<td><input class="input-edit" name="insurance_detail" id="insurance_detail" value="${in.insurance_detail}" /></td>
						
					</tr>			
					</c:forEach>
					</table>
					
					<h style="font-size:20px"> Profit:</h><br>
					<table>		
					<c:forEach var="pro" items="${profitList}">
					<tr>
						<td><label for="profit_amount"> Profit Amount:</label></td>
						<td><label class="edit_label"> ${pro.profit_amount} </label></td>
						<td><input class="input-edit" name="profit_amount" id="profit_amount" value="${pro.profit_amount}" /></td>
						
					</tr> 
					
					<tr>
						<td><label for="profit_detail">Profit Details: </label></td>
						<td><label class="edit_label"> ${pro.profit_detail} </label></td>
						<td><input class="input-edit" name="profit_detail" id="profit_detail" value="${pro.profit_detail}" /></td>
						
					</tr>			
					</c:forEach>
					</table>
					
					<h style="font-size:20px"> Total:</h><br>
					<table>		
					<c:forEach var="tl" items="${totalList}">
					<tr>
						<td><label for="total_cost"> Total Cost:</label></td>
						<td><label class="edit_label">${tl.total_cost} </label></td>
						
					</tr> 
					
					<tr>
						<td><label for="profit_detail">Total Profit: </label></td>
						<td><label class="edit_label"> ${tl.total_profit} </label></td>
						
					</tr>			
					</c:forEach>
					</table>
					
		 <sec:authorize access="isAuthenticated()">  
		 <input type="button" id="modify_checklist" class="green button" value="Edit Checklist" />
	 
   		 <input id="submit_modify" type="submit" class="green button" value="Submit Edit Checklist"/>
		 
		 <input id="modify_copy" type="button" class="green button" value="Copy Checklist"/>
		 </sec:authorize>
		
	
				
</form>	

</sec:authorize>

<sec:authorize access="isAnonymous()">
        ${checkList.title} </h>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        Keywords: ${checkList.keywords}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        Info:${checkList.brief_info}<p> 
        <h style="font-size:20px"> Procedure:</h><br> 
		<c:forEach var="p" items="${procedureList}">
		
        Procedure title:   ${p.step_title}<p>
        Procedure detail:  ${p.step_details}<p>
        Procedure video url:  ${p.tutoriol_video_url}<p>
        
		</c:forEach>


		<h style="font-size:20px"> Material:</h><br>
		<c:forEach var="m" items="${materialList}">
		
        Material name:${m.material_name}<p>
        Material coverage: ${m.coverage}<p>
        Material quantity: ${m.quantity}<p>
        
		</c:forEach>
		
		<h style="font-size:20px"> Labor:</h><br>
		<c:forEach var="la" items="${laborList}">
		
        Task name: ${la.labor_task} <p>
        Number of People: ${la.labor_num_people} <p>
        Number of Hour: ${la.labor_num_hour} <p>
        Hourly Cost: ${la.labor_hourly_cost} <p>
        Labor Insurance: ${la.labor_insurance} <p>
        Detail: ${la.labor_detail} <p>
        
		</c:forEach>
		
		
		<h style="font-size:20px"> Overhead:</h><br>
		<c:forEach var="ov" items="${overheadList}">
		
        Overhead Cost: ${ov.overhead_cost} <p>
        Overhead Details: ${ov.overhead_detail} <p>
        
		</c:forEach>
		
		
		<h style="font-size:20px"> Garbage:</h><br>
		<c:forEach var="ga" items="${garbageList}">
		
        Garbage Cost: ${ga.garbage_cost} <p>
        Garbage Details: ${ga.garbage_detail} <p>
        
		</c:forEach>
		
		
		
		<h style="font-size:20px"> Insurance:</h><br>
		<c:forEach var="in" items="${insuranceList}">
		
        Insurance Amount: ${in.insurance_amount} <p>
        Insurance Details: ${in.insurance_detail} <p>
        
		</c:forEach>
		
		<h style="font-size:20px"> Profit:</h><br>
		<c:forEach var="pro" items="${profitList}">
		
        Profit Amount: ${pro.profit_amount} <p>
        Profit Details: ${pro.profit_detail} <p>
        
		</c:forEach>
		
		<h style="font-size:20px"> Total Calculation:</h><br>
		<c:forEach var="tl" items="${totalList}">
		
        Total Profit: ${tl.total_profit} <p>
        Total Cost: ${tl.total_cost} <p>

		</c:forEach>
</sec:authorize>
	 </div>	 
	 
	 
	 <div id="single_list">
	 <h style="font-size:30px;margin-left: 45% ">Comment</h>
	  <hr>
	 <c:forEach var="ul" items="${usercommentList}">
	  
        User Name:<c:out value="${ul.user_name}"/><p>
        User Comment<c:out value="${ul.comment_text}"/><p>
        <hr>
	 </c:forEach>
	 
	 
	 </div>
	 
	   
	      
	  <div id="comment_area">
	  <h style="font-size:25px;margin-left: 45% ">Comment</h>
	  <sec:authorize access="isAuthenticated()">
			<form:form method="POST" modelAttribute="usercomment" action="usercommentAction" >
				     
				        <c:set var="i" value="${checkList}"/>
						<form:input type="hidden"  path="checklist_id" id="checklist_id" value="${i.checklist_id}"/>
				
					
					<form:label path="comment_text" style="margin-left: 25% ">UserComment:</form:label> 
					<form:textarea rows="5" cols="60" path="comment_text" id="comment_text"/> 
					<form:errors path="comment_text" cssClass="error" /> 
					
		           	
		
				<br>							
					<input  style="margin-left: 680px" class="green button" type="submit" value="Submit" >
	
							
			</form:form>

	 </sec:authorize>
	 <sec:authorize access="isAnonymous()">
	 <p style="font-size:20px;color:red;margin-left: 43% ">you are not login</p>
	 </sec:authorize>
</div>
</div>


	
<div id="check_table" style="display:none">
<c:set var="i" value="${checkList}"/>
<table id="checklist_tab"  width="95%" align="center" cellspacing="0">
<tbody class="check_table">
      <h style="font-size:30px;margin-left: 3% "><c:out value="${i.title}" /></h>
       <tr>
        <td>Material:</td>
		<td><c:forEach var="m" items="${materialList}">
        <c:out value="${m.material_name}"/><br>      
		</c:forEach></td>
		<c:forEach var="tl" items="${totalList}">
		<c:if test="${ tl.checklist_id ==  i.checklist_id}" >
		<td>Subtotal Material:<c:out value="${tl.subtotal_material}"/></td>
        
        </c:if>
		</c:forEach>
       </tr>
         
        <tr>
        <td>Labor:</td>
		<td><c:forEach var="la" items="${laborList}">
        <c:out value="${la.labor_task}"/><br>     
		</c:forEach></td>
		<c:forEach var="tl" items="${totalList}">
		<c:if test="${ tl.checklist_id ==  i.checklist_id}" >
		<td>Subtotal Labor:<c:out value="${tl.subtotal_labor}"/></td>
        
        </c:if>
		</c:forEach>
        </tr>
         
        <tr>
        <td>Overhead:</td>
		<td><c:forEach var="ov" items="${overheadList}">
        Cost:<c:out value="${ov.overhead_cost}"/><br>  
		</c:forEach></td>
		<c:forEach var="tl" items="${totalList}">
		<c:if test="${ tl.checklist_id ==  i.checklist_id}" >
		<td>Subtotal Overhead:<c:out value="${tl.subtotal_overhead}"/></td>
        
        </c:if>
		</c:forEach>
        </tr>
         
   
         
                 <tr>
        <td>Garbage:</td>
		<td><c:forEach var="ga" items="${garbageList}">
        Cost:<c:out value="${ga.garbage_cost}"/><br>   
		</c:forEach></td>
		<c:forEach var="tl" items="${totalList}">
		<c:if test="${ tl.checklist_id ==  i.checklist_id}" >
		<td>Subtotal Garbage:<c:out value="${tl.subtotal_garbage}"/></td>
        
        </c:if>
		</c:forEach>
         </tr>
         
                          <tr>
        <td>Insurance:</td>
		<td><c:forEach var="in" items="${insuranceList}">
        Amount:<c:out value="${in.insurance_amount}"/><br>    
		</c:forEach></td>
		<c:forEach var="tl" items="${totalList}">
		<c:if test="${ tl.checklist_id ==  i.checklist_id}" >
		<td>Subtotal Insurance:<c:out value="${tl.subtotal_insurance}"/></td>
        
        </c:if>
		</c:forEach>
         </tr>
         
                       <tr>
        <td>Profit:</td>
        <td></td>
		<td><c:forEach var="pro" items="${profitList}">
        Amount:<c:out value="${pro.profit_amount}"/><br> 
		</c:forEach></td>
		
         </tr>
         
         
        <tr>
        <td>Total Calculation:</td>
		<c:forEach var="tl" items="${totalList}">
		<td>Total Cost:<c:out value="${tl.total_cost}"/></td>
        <td>Total Profit:<c:out value="${tl.total_profit}"/></td>
		</c:forEach>
		</tr>
	      
  </tbody>
</table>

</div>		


</div>


		
</div>
</body>
</html>