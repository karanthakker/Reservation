<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--  <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> --%>

<%@ include file="/WEB-INF/pages/header.jsp"%>


<div id="mideal">
	<div id="box">
		<div class="imglink">
			<a href="<c:url value='/searchStation'/>"><img
				src="<c:url value='/images/367767.jpg'/>" /></a><span
				class="stationlink"><a href="<c:url value='/searchStation'/>">Search
					Station</a></span>
		</div>
		<div class="imglink">
			<a href="#"><img src="<c:url value='/images/367768.png'/>" /></a><span
				class="stationlink"><a href="#">Battery Status</a></span>
		</div>
		<div class="imglink">
			<a href="<c:url value='/reserveStation'/>"><img src="<c:url value='/images/367769.jpg'/>" /></a><span
				class="stationlink"><a href="<c:url value='/reserveStation'/>"> Reserve Station </a></span>

		</div>
	</div>
	<div id="loginform">Welcome EV user. You have view permission.</div>

<c:forEach var="secchuser" items="${mysecchuser}">
<br />
username: ${secchuser.username}<br />
firstname: ${secchuser.firstname}<br />
lastname: ${secchuser.lastname}<br />
companyname: ${secchuser.companyname}<br />
email: ${secchuser.email}<br />
<br />
	</c:forEach> 
	<%@ include file="/WEB-INF/pages/footer.jsp"%>
