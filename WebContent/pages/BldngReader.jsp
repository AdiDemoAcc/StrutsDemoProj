<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap-4.5.3-dist/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap-4.5.3-dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/popper.min.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/dashboard.css">
<title>Building List</title>
</head>
<body>
	<div class="container custom-bldng-reader-container mt-5">
		<div class="card custom-building-card mt-3 p-4">
			<s:if test="hasActionErrors()">
				<div class="alert alert-danger">
					<s:actionerror />
				</div>
			</s:if>
			<%-- <p>Total Buildings: <s:property value="bldngList.size()" /></p> --%>
			<table class="table table-bordered table-hover text-center">
				<thead>
					<tr class="bg-primary text-light">
						<th>Building Name</th>
						<th>Building Block</th>
						<th>No. of Apartments</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="bldngList" var="bldng">
						<tr>
							<td><s:property value="#bldng.bldngName" /></td>
        					<td><s:property value="#bldng.bldngBlock" /></td>
        					<td><s:property value="#bldng.noOfApartments" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>