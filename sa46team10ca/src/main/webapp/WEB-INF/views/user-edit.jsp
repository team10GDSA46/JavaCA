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
<%-- 			<tr>
				<td><spring:message code="fieldLabel.employeeId" /></td>
				<td><form:input path="id" readonly="true" /></td>
				<td><form:errors path="id" cssStyle="color: red;" /></td>
			</tr> --%>
			<tr>
				<td><spring:message code="fieldLabel.name" /></td>
				<td><form:input path="name" /></td>
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