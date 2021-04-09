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
<title>관리자 선거등록</title>
</head>
<body>
	<div class="container" >
		<div class="row" style="background-color: #12887A">
			<div class="col-4">
				<security:authorize access="isAuthenticated()">
					<a href="${pageContext.request.contextPath}/election?univ_name=<security:authentication property="principal.univ_name"/>"><img src="${pageContext.request.contextPath}/resources/pic/logo.png" style="width:300px; height:auto"></a>
				</security:authorize>
				<security:authorize access="!isAuthenticated()">
					<a href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/resources/pic/logo.png" style="width:300px; height:auto"></a>
				</security:authorize>
			</div>
			<div class="col-5"></div>
			<div class="col-3">	
				<security:authorize access="hasAuthority('manager')">
					<a href="${pageContext.request.contextPath}/manager/list" id="menu"><img src="${pageContext.request.contextPath}/resources/pic/electionlist.png"></a>
				</security:authorize>
			</div>
		</div>	
		<div class="row">
			<div class="col-6" style="background-color: #3CCBDA;height:20px"></div>
			<div class="col-2" style="background-color: #00558C;height:20px"></div>
			<div class="col-4" style="background-color: #DDE5ED;height:20px"></div>
		</div>
		<div class="row basefont">
			<div class="col-2 memberinfo">
				<security:authorize access="isAuthenticated()">
					<h4>회원정보</h4>
					<security:authentication property="principal.univ_name"/><br/>
					<security:authentication property="principal.dept_name"/><br/>
					<security:authentication property="principal.stu_num"/><br/>
					<security:authentication property="principal.stu_grd"/>학년<br/>
					<security:authentication property="principal.stu_name"/><br/>
					<button type="submit" class="btn btn-blue mb-3">졸업</button>
					<a href="${pageContext.request.contextPath}/logout"class="btn btn-blue mb-3">로그아웃</a>
				</security:authorize>
			</div>		
			<div class="col-10">
				<div class="electioninfo" style="height: 300px">
					<h1>등록된 선거 목록</h1>
					<form action="${pageContext.request.contextPath}/manager/insert" method="post" >
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<div class="form-floating mb-3" style="width: 500px">
							<select class="form-select" name="univ_name">
								<c:forEach var="vo" items="${univList}" >
									<option value="${vo.univ_name}">${vo.univ_name}</option>
								</c:forEach>
							</select>
					  		<label>대학교</label>
						</div>					
						<div class="form-floating mb-3">
						  	<input type="text" class="form-control" placeholder=" " style="width: 500px" name="election_name" />
						  	<label>선거이름</label>
						</div>
						<input type="hidden" value="prepare" name="status"/>
						<button type="submit" class="btn btn-blue mb-3">선거추가</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>