<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/pages/header.jsp"%>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>

<!-- @Author - Karan Thakker -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<div class="clear"></div>

<!-- Datepicker application using jquery -->
<div class="m15">
	Select date: <input type="text" id="datepicker"
		value="${not empty is_date_passed ? date_selected :Null}">
	<button type="button" id="submit_date" class="btn btn-info">Go</button>
	<a href="<c:url value='/cancel'/>" >
	<button type="button" id="cancel" class="btn btn-info" style="float: right;width:100px">Cancel</button></a>
</div>

<h2>Midnight hours:</h2>


<table class="table reservation">
	<tr>
		<th>00.00 - 00.30</th>
		<th>00.30 - 01.00</th>
		<th>01.00 - 01.30</th>
		<th>01.30 - 02.00</th>
		<th>02.00 - 02.30</th>
		<th>02.30 - 03.00</th>
		<th>03.00 - 03.30</th>
		<th>03.30 - 04.00</th>
		<th>04.00 - 04.30</th>
		<th>04.30 - 05.00</th>
		<th>05.00 - 05.30</th>
		<th>05.30 - 06.00</th>

	</tr>
	
	<!-- The logic behind displaying whether the time slots are not available, booked or reserved is that
	1. First it checks the session time at which the user tries to look upto the available slots to book at
	2. It then shows only the time slots which lie ahead on that day and the one's past are shown as not avaailable
	3. Depending on the flag used from the class TimeSlot i.e. isAvailable or notAvaible shows the button available or booked
	depending on the values of the flags looped over all the time slots.
	4. Booked buttons are not clickable, i.e. it can not be selected whereas
	5. Available buttons have on click functions and clicking on it displays that the time slot is reserved.    -->
	<tr>
		<c:forEach var="timeSlot" items="${timeSlots}" begin="0" end="11"
			varStatus="time">
			<c:choose>
				<c:when test="${timeSlot.available}">

					<td class="available"><button type="button" id="${time.index}"
							style="width: 81px; height: 18px; background: #dff0d8"
							onClick="booking(id)">Available</button></td>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${timeSlot.notAvailable}">
							<td><button type="button" id="${time.index}"
									style="width: 81px; height: 18px background:#12dddd"
									disabled="true">NA</button></td>

						</c:when>
						<c:otherwise>
							<td class="booked"><button type="button" id="${time.index}"
									style="width: 81px; height: 18px background:#f2dede"
									disabled="true">Booked</button></td>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:forEach>

	</tr>
</table>

<br />
<h2>Morning hours:</h2>

<table class="table reservation">
	<tr>
		<th>06.00 - 06.30</th>
		<th>06.30 - 07.00</th>
		<th>07.00 - 07.30</th>
		<th>07.30 - 08.00</th>
		<th>08.00 - 08.30</th>
		<th>08.30 - 09.00</th>
		<th>09.00 - 09.30</th>
		<th>09.30 - 10.00</th>
		<th>10.00 - 10.30</th>
		<th>10.30 - 11.00</th>
		<th>11.00 - 11.30</th>
		<th>11.30 - 12.00</th>
	<tr>
		<c:forEach var="timeSlot" items="${timeSlots}" begin="12" end="23"
			varStatus="time">
			<c:choose>


				<c:when test="${timeSlot.available}">

					<td class="available"><button type="button" id="${time.index}"
							style="width: 81px; height: 18px; background: #dff0d8"
							onClick="booking(id)">Available</button></td>
				</c:when>


				<c:otherwise>
					<c:choose>
						<c:when test="${timeSlot.notAvailable}">
							<td><button type="button" id="${time.index}"
									style="width: 81px; height: 18px background:#12dddd"
									disabled="true">NA</button></td>

						</c:when>
						<c:otherwise>
							<td class="booked"><button type="button" id="${time.index}"
									style="width: 81px; height: 18px background:#f2dede"
									disabled="true">Booked</button></td>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:forEach>


	</tr>
</table>

<br />
<h2>Afternoon hours:</h2>

<table class="table reservation">
	<tr>
		<th>12.00 - 12.30</th>
		<th>12.30 - 13.00</th>
		<th>13.00 - 13.30</th>
		<th>13.30 - 14.00</th>
		<th>14.00 - 14.30</th>
		<th>14.30 - 15.00</th>
		<th>15.00 - 15.30</th>
		<th>15.30 - 16.00</th>
		<th>16.00 - 16.30</th>
		<th>16.30 - 17.00</th>
		<th>17.00 - 17.30</th>
		<th>17.30 - 18.00</th>
	<tr>
		<c:forEach var="timeSlot" items="${timeSlots}" begin="24" end="35"
			varStatus="time">
			<c:choose>
				<c:when test="${timeSlot.available}">

					<td class="available"><button type="button" id="${time.index}"
							style="width: 81px; height: 18px; background: #dff0d8"
							onClick="booking(id)">Available</button></td>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${timeSlot.notAvailable}">
							<td><button type="button" id="${time.index}"
									style="width: 81px; height: 18px background:#12dddd"
									disabled="true">NA</button></td>

						</c:when>
						<c:otherwise>
							<td class="booked"><button type="button" id="${time.index}"
									style="width: 81px; height: 18px background:#f2dede"
									disabled="true">Booked</button></td>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:forEach>


	</tr>
</table>

<br />
<h2>Evening hours:</h2>

<table class="table reservation">
	<tr>
		<th>18.00 - 18.30</th>
		<th>18.30 - 19.00</th>
		<th>19.00 - 19.30</th>
		<th>19.30 - 20.00</th>
		<th>20.00 - 20.30</th>
		<th>20.30 - 21.00</th>
		<th>21.00 - 21.30</th>
		<th>21.30 - 22.00</th>
		<th>22.00 - 22.30</th>
		<th>22.30 - 23.00</th>
		<th>23.00 - 23.30</th>
		<th>23.30 - 24.00</th>
	<tr>
		<c:forEach var="timeSlot" items="${timeSlots}" begin="36" end="47"
			varStatus="time">
			<c:choose>
				<c:when test="${timeSlot.available}">

					<td class="available"><button type="button" id="${time.index}"
							style="width: 81px; height: 18px; background: #dff0d8"
							onClick="booking(id)">Available</button></td>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${timeSlot.notAvailable}">
							<td><button type="button" id="${time.index}"
									style="width: 81px; height: 18px background:#12dddd"
									disabled="true">NA</button></td>

						</c:when>
						<c:otherwise>
							<td class="booked"><button type="button" id="${time.index}"
									style="width: 81px; height: 18px background:#f2dede"
									disabled="true">Booked</button></td>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:forEach>


	</tr>
</table>


<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'yy-mm-dd',
			minDate : 0
		})
	});

	$('#submit_date').click(
			function() {

				var date_val = $('#datepicker').val();

				if (date_val != null) {
					window.location = window.location.toString().split("?")[0]
							+ '?d=' + date_val + '&buttonType=' + 'Go';
				}
			});

	function booking(bookingId) {
		if (bookingId != null) {
			window.location = window.location.toString().split("?")[0] + '?d='
					+ bookingId + '&buttonType=' + 'Available';
		}
	}
	

</script>

