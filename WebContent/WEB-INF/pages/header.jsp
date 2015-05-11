<html>
<head>
<title>Sec Charge</title>
<!-- SecCharge icons -->
<link rel="shortcut icon" href="images/seccharge_logo.ico">

<link rel="stylesheet" href="css/bootstrap-responsive.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/stylesheet.css'/>" />
</head>
<body>
	<div id="wreppar">
		<div id="wrepparmain">
			<div id="header">
				<div id="logo">
					<img src="<c:url value='/images/367763.png'/>" />
				</div>
				<div id="name">secCharge</div>
				<div id="login">
					<span id="loginsearch"><input type="text" name=""
						style="margin-left: 70px;" /><input type="button" name=""
						value="search"
						style="margin-left: 5px; margin-right: 5px; background-color: #C0C0C0; border: 2px solid #A9A4A4; float: right;" /></span>
					<span id="sing">Logged in as ${currentUser.username} (<a
						href="<c:url value="/logout"/>">Logout</a>)
					</span> <span id="resister">&nbsp;</span>
				</div>
			</div>

			<div id="menu">
				<ul>
					<li><a href="/seccharge/">Home</a></li>
					<li><a href="#">EV User</a></li>
					<li><a href="#">Administrator User</a></li>
					<li><a href="#">About</a></li>
					<li><a href="/seccharge/logout">Log Out</a></li>
				</ul>
			</div>