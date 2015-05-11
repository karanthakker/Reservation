<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/pages/header.jsp"%>

<div class="clear"></div>
<div class="m15">
	Select date: <input type="text" id="datepicker"
		value="${not empty is_date_passed ? date_selected :""}">
	<button type="button" id="submit_date" class="btn btn-info">Go</button>
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
	<tr>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="booked">Booked</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="booked">Booked</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="booked">Booked</td>
		<td class="available">Available</td>
	</tr>
</table>

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
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="booked">Booked</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="booked">Booked</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="booked">Booked</td>
		<td class="available">Available</td>
	</tr>
</table>
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
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="booked">Booked</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="booked">Booked</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="booked">Booked</td>
		<td class="available">Available</td>
	</tr>
</table>
<h2>Evening hours:</h2>

<table class="table reservation">
	<tr>
        <th>18.00 - 18.30</th>
		<th>19.30 - 19.00</th>
		<th>19.00 - 19.30</th>
		<th>20.30 - 20.00</th>
		<th>20.00 - 20.30</th>
		<th>20.30 - 21.00</th>
        <th>21.00 - 21.30</th>
        <th>21.30 - 22.00</th>
        <th>22.00 - 22.30</th>
        <th>22.30 - 23.00</th>
        <th>23.00 - 23.30</th>
        <th>23.30 - 24.00</th>
	<tr>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="booked">Booked</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="booked">Booked</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="available">Available</td>
		<td class="booked">Booked</td>
		<td class="available">Available</td>
	</tr>
</table>

<script>
  $(function() {
	  $( "#datepicker" ).datepicker({ minDate: 0 })
  });
  
  $('#submit_date').click(function(){
	  
	  var date_val = $('#datepicker').val();
	  
	  if(date_val != null){
		  window.location = window.location.toString().split("?")[0] + '?d=' + date_val;
	  }
  })
  
  </script>

