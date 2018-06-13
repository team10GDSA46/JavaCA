<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Booking page</h3>
<!-- insertion for date picker -->
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  	$( function() {
    $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
  	} );
  </script>
 <!-- end of insertion for date picker -->
<form:form method="POST" modelAttribute="booking"
	action="${pageContext.request.contextPath}/booking/edit/${booking.bookingid}.html">
	<table>
	<thead>
	</thead>
		<tbody>
		<form:hidden path="booking"/>
			<tr>
				<td><spring:message code="BookingID" /></td>
				<td><form:input path= "${booking.bookingid.ToString()}"/></td>
				<td><form:errors path="bookingid" cssStyle="color: red;" /></td>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>