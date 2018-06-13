<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Facility List page</h3>
<c:url value="/css/simple.css" var="ss" />
<c:if test="${fn:length(facilityList) gt 0}">
	<a
	href="${pageContext.request.contextPath}/facility/create.html">Create New Facility</a>
	<table style="cellspacing: 2; cellpadding: 2; border: 1;width: 75%;">
		<thead>
			<tr class="listHeading">
				<th><h4 align="center"><spring:message code="Fac Name" /></h4></th>
				<th><h4><spring:message code="caption.edit" /></h4></th>
				<th><h4><spring:message code="caption.delete" /></h4></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="facility" items="${facilityList}">
				<tr class="listRecord">
					<td align="center">${facility.name}</td>
					<td><a
						href="${pageContext.request.contextPath}/facility/edit/${facility.facilityid}.html"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/facility/delete/${facility.facilityid}.html"><spring:message
								code="caption.delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>