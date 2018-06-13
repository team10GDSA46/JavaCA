<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${sessionScope.Login eq '1'}">
	<ul>
		<c:choose>
			<c:when test="${sessionScope.Role eq 'admin' }">
				<li><spring:url value="/facility/list" var="phistory"
						htmlEscape="true" /> <a href="${phistory}"> <spring:message
							code="menu.listFacility" />
				</a></li>
								<li><spring:url value="facility/booking/history" var="phistory"
						htmlEscape="true" /> <a href="${phistory}"> <spring:message
							code="menu.listBooking" />
				</a></li>
								<li><spring:url value="/user/list" var="phistory"
						htmlEscape="true" /> <a href="${phistory}"> <spring:message
							code="menu.listUser" />
				</a></li>
				<li><spring:url value="/facility/maintenance" var="apply"
						htmlEscape="true" /> <a href="${apply}"> <spring:message
							code="menu.bookMaintenance" />
				</a></li>
				<li><spring:url value="/logout" var="logout"
						htmlEscape="true" /> <a href="${logout}"> <spring:message
							code="menu.logout" />
				</a></li>
			</c:when>
			<c:when test="${sessionScope.Role eq 'member' }">
				<li><spring:url value="/facility/booking/history" var="phistory"
						htmlEscape="true" /> <a href="${phistory}"> <spring:message
							code="menu.bookingHistory" />
				</a></li>
				<li><spring:url value="/facility/booking" var="apply"
						htmlEscape="true" /> <a href="${apply}"> <spring:message
							code="menu.newFacBooking" />
				</a></li>
				<li><spring:url value="/user/edit/${sessionScope.UserID}" var="apply"
						htmlEscape="true" /> <a href="${apply}"> <spring:message
							code="menu.manageProfile" />
				</a></li>
				<li><spring:url value="/logout" var="logout"
						htmlEscape="true" /> <a href="${logout}"> <spring:message
							code="menu.logout" />
				</a></li>
			</c:when>
		</c:choose>
	</ul>
</c:if>
