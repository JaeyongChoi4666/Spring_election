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
<title>지난 선거결과 보기</title>
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
				<div class="hbjinfo">
					<h1>${univ_name} ${election_name}</h1>
					<div class="card-group">
						<div class="card">
							<div class="card-header text-center card-title1">
							    <h3>기호${selected.hbj1_num} ${selected.hbj1_name}</h3>
							</div>
							<img src="${pageContext.request.contextPath}/election/image1?univ_name=${univ_name}&election_name=${election_name}" class="card-img-top" style="height:450px; opacity: 0.3" id="pic1" >
							<ul class="list-group list-group-flush">
						    	<li class="list-group-item">${selected.hbj1_gender}</li>
						    	<li class="list-group-item">${selected.hbj1_grade}학년</li>
						    	<li class="list-group-item">${selected.hbj1_prom1}</li>
						    	<li class="list-group-item">${selected.hbj1_prom2}</li>
						    	<li class="list-group-item">${selected.hbj1_prom3}</li>
						  	</ul>
							<div class="card-body text-center">
								<h3>득표수 ${selected.hbj1_vote}</h3>
							</div>
						</div>
						<div class="card">
							<div class="card-header text-center card-title2">
							    <h3>기호${selected.hbj2_num} ${selected.hbj2_name}</h3>
							</div>
							<img src="${pageContext.request.contextPath}/election/image2?univ_name=${univ_name}&election_name=${election_name}" class="card-img-top" style="height:450px; opacity: 0.3" id="pic2">
							<ul class="list-group list-group-flush">
						    	<li class="list-group-item">${selected.hbj2_gender}</li>
						    	<li class="list-group-item">${selected.hbj2_grade}학년</li>
						    	<li class="list-group-item">${selected.hbj2_prom1}</li>
						    	<li class="list-group-item">${selected.hbj2_prom2}</li>
						    	<li class="list-group-item">${selected.hbj2_prom3}</li>
						  	</ul>
							<div class="card-body text-center">
								<h3>득표수 ${selected.hbj2_vote}</h3>
							</div>
						</div>
						<div class="card">
							<div class="card-header text-center card-title3">
							    <h3>기호${selected.hbj3_num} ${selected.hbj3_name}</h3>
							</div>
							<img src="${pageContext.request.contextPath}/election/image3?univ_name=${univ_name}&election_name=${election_name}" class="card-img-top" style="height:450px; opacity: 0.3" id="pic3">
							<ul class="list-group list-group-flush">
						    	<li class="list-group-item">${selected.hbj3_gender}</li>
						    	<li class="list-group-item">${selected.hbj3_grade}학년</li>
						    	<li class="list-group-item">${selected.hbj3_prom1}</li>
						    	<li class="list-group-item">${selected.hbj3_prom2}</li>
						    	<li class="list-group-item">${selected.hbj3_prom3}</li>
						  	</ul>
							<div class="card-body text-center">
								<h3>득표수 ${selected.hbj3_vote}</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" value="${selected.election_winner}" id="winner">
	<input type="hidden" value="${selected.hbj1_name}" id="name1">
	<input type="hidden" value="${selected.hbj2_name}" id="name2">
	<input type="hidden" value="${selected.hbj3_name}" id="name3">
	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.min.js"></script>
	<script>
		$(function(){
			var winner = '${selected.election_winner}';
			if(winner=='${selected.hbj1_name}'){
				$("#pic1").css("opacity","1");
			}else if(winner == '${selected.hbj2_name}'){
				$("#pic2").css("opacity","1");
			}else if(winner == '${selected.hbj3_name}'){
				$("#pic3").css("opacity","1");
			}
		});
	</script>
</body>
</html>