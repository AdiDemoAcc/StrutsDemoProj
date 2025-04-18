<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Building Maker</title>
</head>
<body>
	<div class="container custom-building-maker-container">
		<div class="card">
			<div>
				<s:if test="hasActionErrors()">
					<div class="alert alert-danger">
						<s:actionerror />
					</div>
				</s:if>
			</div>
			<form action="">
				<div class="form-control">
					<label class="form-label" id="buildingNameLabel" for="bldngName">Building Name</label>
					<input class="form-control" type="text" name="bldngName" id="bldngName" >
				</div>
				<div>
					<label class="form-label"></label>
				</div>
			</form>
		</div>
	</div>
</body>
</html>