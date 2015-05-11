<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>SecCharge</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    	<![endif]-->

<!-- Fav icons -->
<link rel="shortcut icon" href="images/seccharge_logo.ico">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<link rel="stylesheet" href="css/style.css">

<script src="js/jquery-1.9.0.js"></script>
<script src="js/bootstrap.js"></script>


</head>
<!--
<body style="background: url('images/bg_lib.jpg') #000 no-repeat center center fixed; background-size: cover; filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='/sites/default/files/background/smcscampussnowyy010714.jpg', sizingMethod='scale'); ">
  -->
<body>
<body
	style="background-size: cover; filter: progid :       DXImageTransform.Microsoft.AlphaImageLoader (       src =       '/sites/default/files/background/smcscampussnowyy010714.jpg', sizingMethod =       'scale' );">

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">

			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" id="logo" href="#"></a>
				<div class="nav-collapse collapse">

					<ul class="nav pull-right">
						<li><a href="/seccharge/">Home</a></li>
						<li><a href="/seccharge/logout">Log Out</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>