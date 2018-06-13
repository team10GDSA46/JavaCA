<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<form:form
	action="${pageContext.request.contextPath}/facility/booking/process.html"
	method="post" modelAttribute="booking">
	<form:hidden path="bookingid" />
	<form:hidden path="timeslot" />
	<form:hidden path="date" />
	<form:hidden path="status" />
	<form:hidden path="facility.facilityid" />
	<div class="col-xs-5 col-md-5 col-sm-5" align="right">
		Facility :<br /><br /> Date :
	</div>
	<div class="col-xs-5 col-md-5 col-sm-5">
		${booking.facility.name } <br /><br />
		<fmt:formatDate value="${booking.date }" pattern="dd-MM-yyyy" />
	</div>
	<br /><br /><br />
	<hr/>
	<c:forEach items="${tslist}" var="ts">
		<div class="[ form-group ] col-xs-4 col-md-4 col-sm-4">
			<input type="checkbox" name="ts" value="${ts.id }" id="${ts.id }"
				autocomplete="off" />
			<div class="[ btn-group ]">
				<label for="${ts.id }" class="[ btn btn-success ]"> <span
					class="[ glyphicon glyphicon-ok ]"></span> <span> </span>
				</label> <label for="${ts.id }" style="width: 120px"
					class="[ btn btn-default active ]"> ${ts.timeslot } </label>
			</div>
		</div>
	</c:forEach>
	<div class="col-xs-12 col-md-12 col-sm-12"
		style="margin-left: 40%; margin-top: 30px;">
		<input type="submit" value="submit" class="btn btn-success" />
	</div>
</form:form>