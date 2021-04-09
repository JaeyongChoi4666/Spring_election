<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/custom.css" rel="stylesheet" />
<meta charset="UTF-8">
<title>대학교 전자투표 시스템</title>
</head>
<body>
	<div class="container" >
		<div class="row" style="background-color: #12887A">
			<div class="col-4">
				<a href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/resources/pic/logo.png" style="width:300px; height:auto"></a>
			</div>
			<div class="col-5"></div>
			<div class="col-3">	
				<a href="${pageContext.request.contextPath}/login" id="menu"><img src="${pageContext.request.contextPath}/resources/pic/login.png"></a>
				<a href="${pageContext.request.contextPath}/join" id="menu"><img src="${pageContext.request.contextPath}/resources/pic/join.png"></a>
			</div>
		</div>	
		<div class="row">
			<div class="col-6" style="background-color: #3CCBDA;height:20px"></div>
			<div class="col-2" style="background-color: #00558C;height:20px"></div>
			<div class="col-4" style="background-color: #DDE5ED;height:20px"></div>
		</div>
		<div class="row" style="background-color: #ACD5EE">
			<img src="${pageContext.request.contextPath}/resources/pic/mainpage.png">		
		</div>
	</div>
</body>
</html>