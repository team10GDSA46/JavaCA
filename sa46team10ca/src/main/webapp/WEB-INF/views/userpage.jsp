<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Member List page</h3>

<c:if test="${fn:length(userList) gt 0}">
	<a href="${pageContext.request.contextPath}/user/create.html">Create
		New User</a>
	<table style="cellspacing: 2; cellpadding: 2; border: 1; width: 75%;">
		<thead>
			<tr class="listHeading">
				<th><h4>Name</h4></th>
				<th><h4>NRIC</h4></th>
				<th><h4>Role</h4></th>
				<th><h4>Phone</h4></th>
				<th><h4>Address</h4></th>
				<th><h4>Email</h4></th>
				<th><h4>Edit</h4></th>
				<th><h4>Delete</h4></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr class="listRecord">
					<td>${user.name}</td>
					<td>${user.nric}</td>
					<td>${user.role}</td>
					<td>${user.phone}</td>
					<td>${user.address}</td>
					<td>${user.email}</td>
					<td><a
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