<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/pages/header.jsp"%>


<table style="width: 100%">
	<tr>
		<th align="left">Time of Reservation</th>
		<th align="center">Cancel Reservation</th>

	</tr>



	<c:forEach var="reservationSlots" items="${siteReservationList}"
		varStatus="reservation">
		<tr>
			<th align="left">${reservationSlots.startTime}:
				${reservationSlots.endTime}</th>
			<th align="center">
				<button type="button"
					style="width: 81px; height: 18px; background: #f2dede" id ="${reservationSlots.reservation.id}"
					onclick ="CancelReservation(id)">Cancel</button>
			</th>
		</tr>
	</c:forEach>

</table>

<script>
	function CancelReservation (reservationId)
	{
		window.location = window.location.toString().split("?")[0]
		+ '?reservationId=' + reservationId ;
	}
</script>