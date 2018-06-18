<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="STYLESHEET" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-ui.theme.css" />

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat: 'dd/mm/yy',
			minDate: '+1d'
		}).val();
	});
</script>
</head>

<h3>Please make your bookings here</h3>
<form:form method="POST" modelAttribute="booking"
	action="${pageContext.request.contextPath}/facility/bookingslot.html">
	<table>
		<tr>
			<td><h4>Select your Facility</h4></td>
			<td><select name="facId" class="form-control">
					<c:forEach items="${flist}" var="fac">
						<option value="${fac.facilityid}">${fac.name}</option>
					</c:forEach>
			</select></td>
		</tr>

		<tr>
			<td><h4>Select Your Date</h4></td>
			<td><form:input path="date" id="datepicker"
					cssClass="form-control" /></td>
		</tr>

		<tr>
			<td>
			<td colspan="2" align="left">
			<input type="submit" value="Submit" class="btn btn-success">
			</td>
		</tr>
	</table>
</form:form>