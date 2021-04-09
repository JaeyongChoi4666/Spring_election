<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
		<!-- 참고 : https://sweetalert2.github.io/ -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
	<script>
	$(function () {
		Swal.fire({
			position: 'center',
			icon: '${icon}',
			title: '${message}',
			showConfirmButton: false,
			timer : 1500,
		}).then((result) => {
			location.replace('${pageContext.request.contextPath}/election?univ_name='+'${univ_name}');
		});
	});
	</script>
</head>
</html>