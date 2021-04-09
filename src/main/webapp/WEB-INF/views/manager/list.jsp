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
<title>등록된 선거목록</title>
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
				<div class="electioninfo" style="height: 800px">
					<h1 style="float: left;">등록된 선거 목록</h1>
					<div style="height:670px; width:1050px; overflow: scroll; margin-bottom: 10px;">
						<table class="table align-middle">
							<thead>
								<tr>
									<th>대학교</th>
									<th>선거이름</th>
									<th>선거상태</th>
									<th>등록후보자수</th>
									<th>후보자</th>
									<th>상태변경</th>
								</tr>
							</thead>					
							<tbody>
								<c:forEach var="vo" items="${electionList}">
									<tr style="background: 
										<c:if test="${vo.status eq 'prepare'}">linear-gradient(to right, #F5E1A4, #F2C75C);</c:if>
										<c:if test="${vo.status eq 'process'}">linear-gradient(to right, #2CC84D, #228848);</c:if>">
										<td>${vo.univ_name}</td>
										<td>${vo.election_name}</td>
										<td>${vo.status}</td>
										<td>${vo.count_candidate}</td>
										<td>
											<a href="${pageContext.request.contextPath}/manager/updatecandidate?univ_name=${vo.univ_name}&election_name=${vo.election_name}" class="btn btn-blue">등록 및 수정</a>
										</td>
										<td>
											<div class="btn-group">
												<a href="${pageContext.request.contextPath}/manager/prepare?univ_name=${vo.univ_name}&election_name=${vo.election_name}" class="btn btn-blue1">준비</a>
												<a href="${pageContext.request.contextPath}/manager/process?univ_name=${vo.univ_name}&election_name=${vo.election_name}" class="btn btn-blue2">시작</a>
												<a href="${pageContext.request.contextPath}/manager/close?univ_name=${vo.univ_name}&election_name=${vo.election_name}" class="btn btn-blue">종료</a>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<a href="${pageContext.request.contextPath}/manager/insert" class="btn btn-blue">선거추가</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>