<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Booking History</h3>

<c:forEach items="${history }" var="b">
	<div class="col-xs-5 col-md-5 col-sm-5 well sm-well"
		style="margin: 10px">
		<table class="table table-bordered" style="margin: auto; border-style: none;">
			<tr>
				<th style="width: 33%"></th>
				<th style="width: 33%"></th>
				<th style="width: 33%"></th>
			</tr>
			<tr>
				<td align="right">Booking No :</td>
				<td>${b.bookingid }</td>
				<td></td>
			</tr>
			<tr>
				<td align="right">Facility :</td>
				<td>${b.facility.name }</td>
				<td></td>
			</tr>
			<tr>
				<td align="right">Time Slot :</td>
				<td>${b.timeslot.timeslot }</td>
				<td></td>
			</tr>
			<tr>
				<td align="right">Date :</td>
				<td><fmt:formatDate value="${b.date }" pattern="dd-MM-yyyy" /></td>
				<td rowspan="2"><c:if test="${b.status eq 'ACTIVE' }">
						<a
							href="${pageContext.request.contextPath}/facility/booking/cancel/${b.bookingid }.html">
							<span class="glyphicon glyphicon-remove-sign btn btn-danger"> 	Cancel</span>
						</a>
					</c:if></td>
			</tr>
			<tr>
				<td align="right">Status :</td>
				<td>${b.status }</td>
			</tr>
		</table>
	</div>
</c:forEach>