<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>Facility</title>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#user').DataTable();
	});
</script>
</head>
<body>


<h3>Employee List page</h3>

<c:if test="${fn:length(userList) gt 0}">
	<a
	href="${pageContext.request.contextPath}/user/create.html">Create New User</a>

	<table id="user" class="display" style="width: 100%">
      <thead>
			<tr class="listHeading">
<th><spring:message code="User Num" /></th>
				<th><spring:message code="Name" /></th>
				<th><spring:message code="NRIC" /></th>
				<th><spring:message code="Role" /></th>
				<th><spring:message code="User Name" /></th>
				<th><spring:message code="Password" /></th>
				<th><spring:message code="DOB" /></th>
				<th><spring:message code="Phone" /></th>
				<th><spring:message code="Address" /></th>
				<th><spring:message code="Email" /></th>
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr class="listRecord">
					<td>${user.userid}</td>
					<td>${user.name}</td>
					<td>${user.nric}</td>
					<td>${user.role}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.dob}</td>
					<td>${user.phone}</td>
					<td>${user.address}</td>
					<td>${user.email}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/user/edit/${user.userid}.html"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/user/delete/${user.userid}.html"><spring:message
								code="caption.delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	  </table>
	</c:if>
	
	</body>
	</html>