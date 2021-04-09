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
<title>선거 목록</title>
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
			<div class="col-10" style="padding-right:0px">
				<div class="electioninfo">
					<h1>진행중인 선거</h1>
					<div style="height:330px; overflow: scroll;">
					<table class="table align-middle">
						<thead>
							<tr>
								<th>선거이름</th>
								<th>후보자 보기</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="vo1" items="${processList}">
								<tr>
									<td>${vo1.univ_name} ${vo1.election_name}</td>
									<td><a href="${pageContext.request.contextPath}/election/process?univ_name=${vo1.univ_name}&election_name=${vo1.election_name}" class="btn btn-blue">후보자 보기</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
				</div>
				<div class="electioninfo">
					<h1>지난 선거 결과보기</h1>
					<div style="height:320px; overflow: scroll;">
					<table class="table align-middle">
						<thead>
							<tr>
								<th>선거이름</th>
								<th>상세보기</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="vo2" items="${closeList}">
								<tr>
									<td>${vo2.univ_name} ${vo2.election_name}</td>
									<td><a href="${pageContext.request.contextPath}/election/close?univ_name=${vo2.univ_name}&election_name=${vo2.election_name}" class="btn btn-blue">결과 보기</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>