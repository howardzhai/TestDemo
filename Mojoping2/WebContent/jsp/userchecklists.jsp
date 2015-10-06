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
	<link href="<c:url value="/resources/css/checklists.css" />" rel="stylesheet">
	
	<script type="text/javascript" src="<c:url value="/resources/js/header.js" />"> </script>
	<script type="text/javascript" src="<c:url value="/resources/js/userchecklists.js" />"></script>
</head>
<body class="main-body">
	<div id="container" class="main-container">
		<div class="header" id="header"></div>
<div class="frameIn">
	     <h style="font-size:30px;margin-left: 45% ">MyChecklist:</h>
		 <button id="reset" class="green button" style="margin-left: 20%;">reset</button>
		 <button id="change_map" class="green button" >Change Map</button>
		 <button id="edit_checklist" class="green button"  onclick="javascript:window.location.href='/Mojoping2/user_edit_checklist';">Edit Checklist</button>
<div id="check_list" >
		
		 
		<c:forEach var="i" items="${checkList}">
		<div id="single_list" class="single_list" style="padding-top:20px;">
		<c:set var="id" value="${i.checklist_id}" />
		<a href="detail_${id}"><c:out value="${i.title}" /></a>
		<h style="font-size:22px">
        <c:out value="${i.title}" /></h>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        Keywords: <c:out value="${i.keywords}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        Info:<c:out value="${i.brief_info}"/>
        
        <div id="checklist_detail" class="checklist_detail" style="display:none">
        	<h style="font-size:20px"> Procedure:</h><br>
		<c:forEach var="p" items="${procedureList}">
		<c:if test="${ i.checklist_id == p.checklist_id}" >
        Procedure title:<c:out value="${p.step_title}"/><p>
        Procedure detail:<c:out value="${p.step_details}"/><p>
        Procedure video url:<c:out value="${p.tutoriol_video_url}"/><p>
        </c:if>
		</c:forEach>
		    	<h style="font-size:20px"> Material:</h><br>
		<c:forEach var="m" items="${materialList}">
		<c:if test="${ m.procedure_id ==  i.checklist_id}" >
        Material name:<c:out value="${m.material_name}"/><p>
        Material coverage:<c:out value="${m.coverage}"/><p>
        Material quantity:<c:out value="${m.quantity}"/><p>
        </c:if>
		</c:forEach>
		
			    	<h style="font-size:20px"> Labor:</h><br>
		<c:forEach var="la" items="${laborList}">
		<c:if test="${ la.procedure_id == i.checklist_id}" >
        Task name:<c:out value="${la.labor_task}"/><p>
        Number of People:<c:out value="${la.labor_num_people}"/><p>
        Number of Hour:<c:out value="${la.labor_num_hour}"/><p>
        Hourly Cost:<c:out value="${la.labor_hourly_cost}"/><p>
        Labor Insurance:<c:out value="${la.labor_insurance}"/><p>
        Detail:<c:out value="${la.labor_detail}"/><p>
        </c:if>
		</c:forEach>
		
		
			    	<h style="font-size:20px"> Overhead:</h><br>
		<c:forEach var="ov" items="${overheadList}">
		<c:if test="${ ov.procedure_id ==  i.checklist_id}" >
        Overhead Cost:<c:out value="${ov.overhead_cost}"/><p>
        Overhead Details:<c:out value="${ov.overhead_detail}"/><p>
        </c:if>
		</c:forEach>
		
		
							    	<h style="font-size:20px"> Garbage:</h><br>
		<c:forEach var="ga" items="${garbageList}">
		<c:if test="${ ga.procedure_id ==  i.checklist_id}" >
        Garbage Cost:<c:out value="${ga.garbage_cost}"/><p>
        Garbage Details:<c:out value="${ga.garbage_detail}"/><p>
        </c:if>
		</c:forEach>
		
		
		
									<h style="font-size:20px"> Insurance:</h><br>
		<c:forEach var="in" items="${insuranceList}">
		<c:if test="${ in.procedure_id ==  i.checklist_id}" >
        Insurance Amount:<c:out value="${in.insurance_amount}"/><p>
        Insurance Details:<c:out value="${in.insurance_detail}"/><p>
        </c:if>
		</c:forEach>
		
							    	<h style="font-size:20px"> Profit:</h><br>
		<c:forEach var="pro" items="${profitList}">
		<c:if test="${ pro.procedure_id ==  i.checklist_id}" >
        Profit Amount:<c:out value="${pro.profit_amount}"/><p>
        Profit Details:<c:out value="${pro.profit_detail}"/><p>
        </c:if>
		</c:forEach>
		
		<h style="font-size:20px"> Total Calculation:</h><br>
		<c:forEach var="tl" items="${totalList}">
		<c:if test="${ tl.checklist_id ==  i.checklist_id}" >
        Total Profit:<c:out value="${tl.total_profit}"/><p>
        Total Cost:<c:out value="${tl.total_cost}"/><p>
        </c:if>
		</c:forEach>
	       </div>
		 </div>
	    </c:forEach>
		
	
		</div>
		
<div id="check_table" style="display:none">
<c:forEach var="i" items="${checkList}">
<table width="95%" align="center" cellspacing="0">
<tbody>
        
        
        <h style="font-size:30px;margin-left: 3% "><c:out value="${i.title}" /></h>
         
       <tr>
        <td>Material:</td>
		<td><c:forEach var="m" items="${materialList}">
		<c:if test="${ m.procedure_id ==  i.checklist_id}" >
        <c:out value="${m.material_name}"/><br>   
        </c:if>    
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
		<c:if test="${ la.procedure_id == i.checklist_id}" >
        <c:out value="${la.labor_task}"/><br>  
        </c:if>    
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
		<c:if test="${ ov.procedure_id ==  i.checklist_id}" >
        Cost:<c:out value="${ov.overhead_cost}"/><br>
        </c:if>    
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
		<c:if test="${ ga.procedure_id ==  i.checklist_id}" >
        Cost:<c:out value="${ga.garbage_cost}"/><br>
        </c:if>    
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
		<c:if test="${ in.procedure_id ==  i.checklist_id}" >
        Amount:<c:out value="${in.insurance_amount}"/><br>
        </c:if>    
		</c:forEach></td>
		<c:forEach var="tl" items="${totalList}">
		<c:if test="${ tl.checklist_id ==  i.checklist_id}" >
		<td>Subtotal Insurance:<c:out value="${tl.subtotal_insurance}"/></td>
        
        </c:if>
		</c:forEach>
         </tr>
         
                       <tr>
        <td>Profit:</td>
        
		<td><c:forEach var="pro" items="${profitList}">
		<c:if test="${ pro.procedure_id ==  i.checklist_id}" >
        Amount:<c:out value="${pro.profit_amount}"/><br>
        </c:if>    
		</c:forEach></td>
		<td></td>
         </tr>
         
         
        <tr>
        <td>Total Calculation:</td>
		<c:forEach var="tl" items="${totalList}">
		<c:if test="${ tl.checklist_id ==  i.checklist_id}" >
		 <td>Total Profit:<c:out value="${tl.total_profit}"/></td>
		<td>Total Cost:<c:out value="${tl.total_cost}"/></td>
       
        
        </c:if>
		</c:forEach>
		</tr>
          
  </tbody>
</table>
<br>
        </c:forEach>






</div>

</div>
		
	</div>
</body>
</html>