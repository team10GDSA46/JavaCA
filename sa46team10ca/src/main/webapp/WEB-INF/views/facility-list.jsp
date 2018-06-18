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
		$('#facility').DataTable();
	});
</script>
</head>
<body>



<h3>Facility List page</h3>
<c:url value="/css/simple.css" var="ss" />
<c:if test="${fn:length(facilityList) gt 0}">
	<a
	href="${pageContext.request.contextPath}/facility/create.html">Create New Facility</a>
	<table id="facility" class="display" style="width: 100%">
		<thead>
			<tr class="listHeading">
			<%-- 	<th><spring:message code="Fac Num" /></th> --%>
				<th><spring:message code="Fac Name" /></th>
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="facility" items="${facilityList}">
				<tr class="listRecord">
				<%-- 	<td ${facility.facilityid}</td> --%>
					<td>${facility.name}</td>
					<td align="center"><a
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
</body>
</html>
