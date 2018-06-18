<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>All Maintenance Page</h3>

<c:if test="${fn:length(mList) gt 0}">

	<table style="cellspacing: 2; cellpadding: 2; border: 1; width: 75%">
		<thead>
			<tr class="listHeading">
				<th><h4>Facility</h4></th>
				<th><h4>Date</h4></th>
				<th><h4>Time Slot</h4></th>
				<th><h4>Delete</h4></th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="maintenance" items="${mList}">

				<tr class="listRecord">

					<td>${maintenance.facilityid.name }</td>

					<td>${maintenance.date}</td>

					<td>${maintenance.timeslotid.timeslot }</td>

					<td><a
						href="${pageContext.request.contextPath}/maintenance/delete/${maintenance.maintenanceid}.html"><spring:message
								code="caption.delete" /></a></td>

				</tr>


			</c:forEach>

		</tbody>


	</table>
</c:if>