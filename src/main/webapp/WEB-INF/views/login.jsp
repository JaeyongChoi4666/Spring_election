<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/custom.css" rel="stylesheet" />
<meta charset="UTF-8">
<title>로그인</title>
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
		<div class="row">
			<div class="col-4" style="padding:0px">
				<img src="${pageContext.request.contextPath}/resources/pic/banner.png" style="width:100%; height:auto">
			</div>
			<div class="col-4 basefont">
				<h1>로그인</h1>
				<form action="${pageContext.request.contextPath}/loginProcess" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="form-floating mb-3">
					  	<input type="text" class="form-control"placeholder=" " name="id">
					  	<label>회원ID</label>
					</div>
					<div class="form-floating mb-3">
					  	<input type="password" class="form-control"placeholder=" " name="pw">
					  	<label>비밀번호</label>
					</div>
					<button type="submit" class="btn btn-primary mb-3">로그인</button>
				</form>
				<security:authorize access="isAuthenticated()">
					이미 <security:authentication property="principal.id"/>님이 로그인 되어 있습니다
				</security:authorize>
			</div>
			<div class="col-4" style="padding:0px">
				<img src="${pageContext.request.contextPath}/resources/pic/banner2.png" style="width:100%; height:auto">
			</div>
		</div>
	</div>
</body>
</html>