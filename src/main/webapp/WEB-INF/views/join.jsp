<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
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
				<h1>회원가입</h1>
				<form action="${pageContext.request.contextPath}/join" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="form-floating mb-3">
					  	<input type="text" class="form-control" placeholder=" " name="id">
					  	<label>회원ID</label>
					</div>
					<div class="form-floating mb-3">
					  	<input type="password" class="form-control"placeholder=" " name="pw">
					  	<label>비밀번호</label>
					</div>
					<div class="form-floating mb-3">
						<select class="form-select" id="univ" name="univ_name">
							<c:forEach var="vo" items="${univList}">
									<option value="${vo.univ_name}">${vo.univ_name}</option>
								</c:forEach>
						</select>
					  	<label>대학교</label>
					</div>
					<div class="form-floating mb-3">
						<select class="form-select" id="dept" name="dept_name">
							<c:forEach var="vo" items="${deptList}">
								<option class="${vo.univ_name}" value="${vo.dept_name}">${vo.dept_name}</option>
							</c:forEach>
						</select>
					  	<label>학과</label>
					</div>	
					<div class="form-floating mb-3">
					  	<input type="text" class="form-control"placeholder=" " name="stu_name">
					  	<label>이름</label>
					</div>
					<div class="form-floating mb-3">
					  	<input type="text" class="form-control"placeholder=" " name="stu_num">
					  	<label>학번</label>
					</div>
					<div class="form-floating mb-3">
						<select class="form-select" name="stu_grd">
							<option value="1">1학년
							<option value="2">2학년
							<option value="3">3학년
							<option value="4">4학년
						</select>
					  	<label>학년</label>
					</div>
					<div class="form-floating mb-3">
						<select class="form-select" id="auth" name="auth">
							<option value="student">학생
							<option value="manager">관리자
						</select>
					  	<label>권한</label>
					</div>
					<div class="form-floating mb-3">
					  	<input type="text" class="form-control"placeholder=" " disabled id="code" name="code">
					  	<label>관리자코드</label>
					</div>
					<button type="submit" class="btn btn-primary mb-3">회원가입</button>
				</form>
			</div>
			<div class="col-4" style="padding:0px">
				<img src="${pageContext.request.contextPath}/resources/pic/banner2.png" style="width:100%; height:auto">
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>
	<script src='//rawgit.com/tuupola/jquery_chained/master/jquery.chained.min.js'></script>
	<script>
		$(function() {
			$("#auth").change( function() {
				var auth = $('#auth').val();
				if(auth == "student"){
					$("#code").attr("disabled",true);
				}
				if(auth == "manager"){
					$("#code").attr("disabled",false);
				}
			});
		});
		$("#dept").chained("#univ");
	</script>
</body>
</html>