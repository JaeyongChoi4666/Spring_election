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
<title>후보 추가 및 수정</title>
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
					<form class="row g-4" action="${pageContext.request.contextPath}/manager/updatecandidate" method="post" enctype="multipart/form-data">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<input type="hidden" value="${univ_name}" name="univ_name"/>
						<input type="hidden" value="${election_name}" name="election_name"/>
						<div class="col-4 form4">
							<h4>후보자1</h4>
							<div class="input-group">
								<label class="input-group-text">사진추가</label>
								<input type="file" class="form-control" name="pic1" >
							</div>
						</div>
						<div class="col-4 form4">
							<h4>후보자2</h4>
							<div class="input-group">
								<label class="input-group-text">사진추가</label>
								<input type="file" class="form-control" name="pic2" >
							</div>
						</div>
						<div class="col-4 form4">
							<h4>후보자3</h4>
							<div class="input-group">
								<label class="input-group-text">사진추가</label>
								<input type="file" class="form-control" name="pic3" >
							</div>
						</div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
								<input type="text" class="form-control"placeholder=" " name="hbj1_name" value="${selectedOne.hbj1_name}">
								<label>이름</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
								<input type="text" class="form-control"placeholder=" " name="hbj2_name" value="${selectedOne.hbj2_name}">
								<label>이름</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
								<input type="text" class="form-control"placeholder=" " name="hbj3_name" value="${selectedOne.hbj3_name}">
								<label>이름</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
								<select class="form-select" name="hbj1_gender">
									<option value="남성" <c:if test="${selectedOne.hbj1_gender eq '남성'}">selected</c:if>>남성
									<option value="여성" <c:if test="${selectedOne.hbj1_gender eq '여성'}">selected</c:if>>여성
								</select>
								<label>성별</label>
							</div>	
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
								<select class="form-select" name="hbj2_gender">
									<option value="남성" <c:if test="${selectedOne.hbj2_gender eq '남성'}">selected</c:if>>남성
									<option value="여성" <c:if test="${selectedOne.hbj2_gender eq '여성'}">selected</c:if>>여성
								</select>
								<label>성별</label>
							</div>	
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
								<select class="form-select" name="hbj3_gender">
									<option value="남성" <c:if test="${selectedOne.hbj3_gender eq '남성'}">selected</c:if>>남성
									<option value="여성" <c:if test="${selectedOne.hbj3_gender eq '여성'}">selected</c:if>>여성
								</select>
								<label>성별</label>
							</div>	
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating mb-2">
								<select class="form-select" name="hbj1_grade">
									<option value="1" <c:if test="${selectedOne.hbj1_grade eq '1'}">selected</c:if>>1학년
									<option value="2" <c:if test="${selectedOne.hbj1_grade eq '2'}">selected</c:if>>2학년
									<option value="3" <c:if test="${selectedOne.hbj1_grade eq '3'}">selected</c:if>>3학년
									<option value="4" <c:if test="${selectedOne.hbj1_grade eq '4'}">selected</c:if>>4학년
								</select>
								<label>학년</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
								<select class="form-select" name="hbj2_grade">
									<option value="1" <c:if test="${selectedOne.hbj2_grade eq '1'}">selected</c:if>>1학년
									<option value="2" <c:if test="${selectedOne.hbj2_grade eq '2'}">selected</c:if>>2학년
									<option value="3" <c:if test="${selectedOne.hbj2_grade eq '3'}">selected</c:if>>3학년
									<option value="4" <c:if test="${selectedOne.hbj2_grade eq '4'}">selected</c:if>>4학년
								</select>
								<label>학년</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
								<select class="form-select" name="hbj3_grade">
									<option value="1" <c:if test="${selectedOne.hbj3_grade eq '1'}">selected</c:if>>1학년
									<option value="2" <c:if test="${selectedOne.hbj3_grade eq '2'}">selected</c:if>>2학년
									<option value="3" <c:if test="${selectedOne.hbj3_grade eq '3'}">selected</c:if>>3학년
									<option value="4" <c:if test="${selectedOne.hbj3_grade eq '4'}">selected</c:if>>4학년
								</select>
								<label>학년</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
								<input type="text" class="form-control"placeholder=" " name="hbj1_num" value="${selectedOne.hbj1_num}">
								<label>기호</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
								<input type="text" class="form-control"placeholder=" " name="hbj2_num" value="${selectedOne.hbj2_num}">
								<label>기호</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
								<input type="text" class="form-control"placeholder=" " name="hbj3_num" value="${selectedOne.hbj3_num}">
								<label>기호</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
							  	<textarea class="form-control" placeholder=" " style="height: 100px" name="hbj1_prom1">${selectedOne.hbj1_prom1}</textarea>
							  	<label for="floatingTextarea2">공약1</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
							  	<textarea class="form-control" placeholder=" " style="height: 100px" name="hbj2_prom1">${selectedOne.hbj2_prom1}</textarea>
							  	<label for="floatingTextarea2">공약1</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
							  	<textarea class="form-control" placeholder=" " style="height: 100px" name="hbj3_prom1">${selectedOne.hbj3_prom1}</textarea>
							  	<label for="floatingTextarea2">공약1</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
							  	<textarea class="form-control" placeholder=" " style="height: 100px" name="hbj1_prom2">${selectedOne.hbj1_prom2}</textarea>
							  	<label for="floatingTextarea2">공약2</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
							  	<textarea class="form-control" placeholder=" " style="height: 100px" name="hbj2_prom2">${selectedOne.hbj2_prom2}</textarea>
							  	<label for="floatingTextarea2">공약2</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
							  	<textarea class="form-control" placeholder=" " style="height: 100px" name="hbj3_prom2">${selectedOne.hbj3_prom2}</textarea>
							  	<label for="floatingTextarea2">공약2</label>
							</div>
						 </div>
						 <div class="col-4 form4">
						 	<div class="form-floating">
							  	<textarea class="form-control" placeholder=" " style="height: 100px" name="hbj1_prom3">${selectedOne.hbj1_prom3}</textarea>
							  	<label for="floatingTextarea2">공약3</label>
							</div>
						</div>
						<div class="col-4 form4">
							<div class="form-floating">
								<textarea class="form-control" placeholder=" " style="height: 100px" name="hbj2_prom3">${selectedOne.hbj2_prom3}</textarea>
							  	<label for="floatingTextarea2">공약3</label>
							</div>
						</div>
						<div class="col-4 form4">
							<div class="form-floating">
								<textarea class="form-control" placeholder=" " style="height: 100px" name="hbj3_prom3">${selectedOne.hbj3_prom3}</textarea>
							  	<label for="floatingTextarea2">공약3</label>
							</div>
						</div>
					<button type="submit" class="btn btn-blue form4" style="width: 100px; margin-left: 10px">후보추가</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>