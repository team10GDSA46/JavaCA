<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form
	action="${pageContext.request.contextPath}/maintenance/maintenance/process.html"
	method="post" modelAttribute="maintenance">
	<form:hidden path="maintenanceid" />
	<form:hidden path="timeslot" />
	<form:hidden path="date" />
	<form:hidden path="facility.facilityid" />
	<%-- <form:hidden path="user"/> --%>
	
	<div>
		Facility : ${maintenance.facility.name } Date :
		<fmt:formatDate value="${maintenance.date }" pattern="dd-MM-yyyy" />
	</div>
	<c:forEach items="${tslist}" var="ts">
		<input type="checkbox" value="${ts.id}" name="ts" />${ts.timeslot}<br />
	</c:forEach>
	<input type="submit" value="submit" />
</form:form>