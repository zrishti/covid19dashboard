<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,java.util.*,java.sql.*,java.util.Date,com.zrishti.data.*"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>covid19</title>
<link rel = 'stylesheet' type = 'text/css' href = 'resources/styles.css'/>
<link href="//db.onlinewebfonts.com/c/23c0fcab84d99da0de762de7e220a6e1?family=Europa" rel="stylesheet" type="text/css"/>

<style>
@import url(//db.onlinewebfonts.com/c/23c0fcab84d99da0de762de7e220a6e1?family=Europa);
@font-face {font-family: "Europa"; src: url("//db.onlinewebfonts.com/t/23c0fcab84d99da0de762de7e220a6e1.eot"); src: url("//db.onlinewebfonts.com/t/23c0fcab84d99da0de762de7e220a6e1.eot?#iefix") format("embedded-opentype"), url("//db.onlinewebfonts.com/t/23c0fcab84d99da0de762de7e220a6e1.woff2") format("woff2"), url("//db.onlinewebfonts.com/t/23c0fcab84d99da0de762de7e220a6e1.woff") format("woff"), url("//db.onlinewebfonts.com/t/23c0fcab84d99da0de762de7e220a6e1.ttf") format("truetype"), url("//db.onlinewebfonts.com/t/23c0fcab84d99da0de762de7e220a6e1.svg#Europa") format("svg"); }
</style>

<script src="https://d3js.org/d3.v4.js"></script>

</head>
<body>


<div class='navbar'>
	<div class="menu">
		<ul>
		<li><img src="Images/logo.png" id='logoimg'><li>
		<li><a href="index.jsp">Data</a></li>
		<li><a href="NewEntry.jsp">Report Coronavirus Cases</a></li>
		<li><a href="Map.jsp">Map</a></li>
		<li><a href="About.jsp">About</a></li>
		<li><a href="rest">REST</a></li>
		<li> <%@ include file="SearchBox.jsp" %> </li>
		</ul>
	</div>
	
	<!--  <div id=logo><img src="Images/logo.png"></div>-->
	
	<!--
	
	<div id="search"><%@ include file="SearchBox.jsp" %> </div>
	
	-->
	
	
	</div>

	

