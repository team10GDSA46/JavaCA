<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Facility page</h3>
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
				<%-- <td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td><spring:message code="Nric" /></td>
				<td><form:input path="nric" /></td>
				<%-- <td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td><spring:message code="Role" /></td>
				<td><form:input path="role" /></td>
				<%-- <td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td><spring:message code="Username" /></td>
				<td><form:input path="username" /></td>
				<%-- <td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td><spring:message code="Password" /></td>
				<td><form:input path="password" /></td>
				<%-- <td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			</tr>			
			<tr>
				<td><spring:message code="Date of Birth" /></td>
 				<td><form:input path="dob" /></td>
				<!-- insertion for date picker -->
				<!--  <td><h4><input type="text" id="datepicker"></h4></td> -->
				<%-- <td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			</tr>						
			<tr>
				<td><spring:message code="Phone" /></td>
				<td><form:input path="phone" /></td>
				<%-- <td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td><spring:message code="Address" /></td>
				<td><form:input path="address" /></td>
				<%-- <td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td><spring:message code="Email" /></td>
				<td><form:input path="email" /></td>
				<%-- <td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			</tr>			
			
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>