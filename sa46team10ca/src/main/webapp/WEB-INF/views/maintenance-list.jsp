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
				<th><h4>Edit</h4></th>
				<th><h4>Delete</h4></th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="maintenace" items="${mList}">

				<tr class="listRecord">

					<td>${maintenace.facilityid.name }</td>

					<td>${maintenace.date}</td>

					<td>${maintenace.timeslotid.timeslot }</td>

					<td><a
						href="${pageContext.request.contextPath}/booking/edit/${booking.bookingid}.html"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/booking/delete/${booking.bookingid}.html"><spring:message
								code="caption.delete" /></a></td>

				</tr>


			</c:forEach>

		</tbody>


	</table>
</c:if>