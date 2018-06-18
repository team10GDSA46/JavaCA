<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Member page</h3>

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

<form:form method="POST" modelAttribute="user"
	action="${pageContext.request.contextPath}/user/edit/${user.userid}.html">
	<table>
		<tbody>
		<form:hidden path=""/>

<!--  Commented Off
			<tr>
				<td><spring:message code="fieldLabel.name" /></td>
				<td><form:input path="name" /></td>
				<%-- <td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			</tr>
-->
			
			<tr>
				<td><spring:message code="Name" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Nric" /></td>
				<td><form:input path="nric" /></td>
				<td><form:errors path="nric" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Role" /></td>
				<td><form:input path="role" /></td>
				<td><form:errors path="role" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Username" /></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Password" /></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssStyle="color: red;" /></td>
			</tr>		
			<tr>
				<td><spring:message code="Date of Birth" /></td>
 				<td><form:input path="dob" id="datepicker"/></td>
				<td><form:errors path="dob" cssStyle="color: red;" /></td>
			</tr>						
			<tr>
				<td><spring:message code="Phone" /></td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Address" /></td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="Email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssStyle="color: red;" /></td>
			</tr>			
			
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>