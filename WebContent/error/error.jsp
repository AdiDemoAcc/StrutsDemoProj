<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
<style type="text/css">
.custom-error-background-image {
	background-image:
		url('data:image/png;base64,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');
	background-position: center;
	background-repeat: no-repeat;
}
</style>
</head>
<body class="">
	<div>
		<h1>An Error Occurred</h1>
		<s:if test="hasActionErrors()">
			<div class="alert alert-danger">
				<s:actionerror />
			</div>
		</s:if>
	</div>
</body>
</html>