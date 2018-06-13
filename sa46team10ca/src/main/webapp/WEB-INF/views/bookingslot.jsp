<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form
	action="${pageContext.request.contextPath}/facility/booking/process.html"
	method="post" modelAttribute="booking">
	<form:hidden path="bookingid" />
	<form:hidden path="timeslot" />
	<form:hidden path="date" />
	<form:hidden path="status" />
	<form:hidden path="facility.facilityid" />
	<%-- <form:hidden path="user"/> --%>

	<div>
		Facility : ${booking.facility.name } Date :
		<fmt:formatDate value="${booking.date }" pattern="dd-MM-yyyy" />
	</div>
	<c:forEach items="${tslist}" var="ts">
		<input type="checkbox" value="${ts.id}" name="ts" />${ts.timeslot}<br />
	</c:forEach>
	<input type="submit" value="submit" />
</form:form>