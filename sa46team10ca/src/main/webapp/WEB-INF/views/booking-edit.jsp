<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="STYLESHEET" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-ui.theme.css" />

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>

<h3>Edit Booking page</h3>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			minDate: '+1d',
			dateFormat: 'dd/mm/yy'
		}).val();
	});
  </script>


<form:form method="POST" modelAttribute="booking"
	action="${pageContext.request.contextPath}/booking/edit/${booking.bookingid}.html">


	<table>
		<tbody>
			<form:hidden path="bookingid" />
			<form:hidden path="userid" />
			<tr>
				<td><spring:message code="facility" /></td>
				<td><select name="facId" class="form-control">
						<c:forEach items="${flist}" var="fac">
							<option value="${fac.facilityid}">${fac.name}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td><spring:message code="date" /></td>
				<td><form:input path="date" id="datepicker" /></td>
				<td><form:errors path="date" cssStyle="color: red;" /></td>
			</tr>
			
		</tbody>
	</table>

<br /><br /><br /><br /><br />


<c:forEach items="${tslist}" var="ts">
				<div class="[ form-group ] col-xs-4 col-md-4 col-sm-4">
					<input type="checkbox" name="ts" value="${ts.id }" id="${ts.id }"
						autocomplete="off" />
					<div class="[ btn-group ]">
						<label for="${ts.id }" class="[ btn btn-success ]"> <span
							class="[ glyphicon glyphicon-ok ]"></span> <span> </span>
						</label> <label for="${ts.id }" style="width: 120px"
							class="[ btn btn-default active ]"> ${ts.timeslot } </label>
					</div>
				</div>
			</c:forEach>
<div class="col-xs-12 col-md-12 col-sm-12"
		style="margin-left: 40%; margin-top: 30px;">
		<input type="submit" value="submit" class="btn btn-success" />
	</div>
</form:form>