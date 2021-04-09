<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
		<!-- 참고 : https://sweetalert2.github.io/ -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	<script>
	$(function () {
		Swal.fire({
			position: 'center',
			icon: 'success',
			title: '${message}',
			showConfirmButton: false,
			timer: 1200
		}).then((result) => {
			location.replace('${url}');
		});
	});
	</script>
</head>
</html>