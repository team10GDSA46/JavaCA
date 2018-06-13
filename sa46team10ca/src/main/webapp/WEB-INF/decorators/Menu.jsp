<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${sessionScope.Login eq '1'}">
	<ul>
		<c:choose>
			<c:when test="${sessionScope.Role eq 'admin' }">
				<li><spring:url value="/staff/history" var="phistory"
						htmlEscape="true" /> <a href="${phistory}"> <spring:message
							code="menu.personalHistory" />
				</a></li>
				<li><spring:url value="/staff/course/create" var="apply"
						htmlEscape="true" /> <a href="${apply}"> <spring:message
							code="menu.courseSubmit" />
				</a></li>
				<li><spring:url value="/staff/logout" var="logout"
						htmlEscape="true" /> <a href="${logout}"> <spring:message
							code="menu.logout" />
				</a></li>
			</c:when>
			<c:when test="${sessionScope.Role eq 'member' }">
				<li><spring:url value="/staff/history" var="phistory"
						htmlEscape="true" /> <a href="${phistory}"> <spring:message
							code="menu.personalHistory" />
				</a></li>
				<li><spring:url value="/staff/logout" var="logout"
						htmlEscape="true" /> <a href="${logout}"> <spring:message
							code="menu.logout" />
				</a></li>
			</c:when>
		</c:choose>
	</ul>
</c:if>
