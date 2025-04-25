<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/bootstrap-4.5.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/style/dashboard.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/style/BuildingMaker.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/popper.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/scripts/BldngMaker.js" type="text/javascript"></script>
<title>Building Maker</title>
</head>
<body>
	<div class="container custom-building-maker-container">
		<div class="card mt-4">
			<div class="card-header text-center">
				<h3>Register New Building</h3>
			</div>
			<div>
				<s:if test="hasActionErrors()">
					<div class="alert alert-danger">
						<s:actionerror />
					</div>
				</s:if>
			</div>
			<div class="card-body">
				<form action="" >
					<div class="row mt-3 mb-3">
						<div class="custom-building-maker-input-row col-6 input-group">
							<!-- <label class="form-label custom-building-maker-form-label col-4" id="buildingNameLabel" for="bldngName">Building Name</label> -->
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-bldngName">Building Name</span>
							</div>
							<input class="form-control col-8" type="text" name="bldngName" id="bldngName" aria-label="Default" aria-describedby="inputGroup-bldngName" required>
						</div>
						<div class="custom-building-maker-input-row col-6 input-group">
							<!-- <label class="form-label custom-building-maker-form-label col-4" id="buildingBlockLabel" for="bldngBlock">Building Block</label> -->
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-bldngBlock">Building Block</span>
							</div>
							<input class="form-control col-8" type="text" id="bldngBlock" name="bldngBlock" aria-label="Default" aria-describedby="inputGroup-bldngBlock" required> 
						</div>
					</div>
					<div class="row mb-3">
						<div class="custom-building-maker-input-row col-6 input-group">
							<!-- <label class="form-label custom-building-maker-form-label col-4" id="buildingBlockLabel" for="bldngBlock">Building Block</label> -->
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-noOfApartments">No of Apartments</span>
							</div>
							<input 
								class="form-control col-8" 
								type="text" 
								id="noOfApartments" 
								name="noOfApartments" 
								aria-label="Default" 
								aria-describedby="inputGroup-noOfApartments"
								onkeypress="return isDigit(event)"
								onchange="validateNumInput"
								required
							> 
						</div>
						<div class="custom-building-maker-input-row col-6 input-group">
							<!-- <label class="form-label custom-building-maker-form-label col-4" id="buildingBlockLabel" for="bldngBlock">Building Block</label> -->
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-noOfFloors">No of Floors</span>
							</div>
							<input 
								class="form-control col-8" 
								type="text" 
								id="noOfFloors" 
								name="noOfFloors" 
								aria-label="Default" 
								aria-describedby="inputGroup-noOfFloors"
								onkeypress="return isDigit(event)"
								onchange="validateNumInput"
								required
							> 
						</div>
					</div>
					<div class="row mb-3">
						<div class="custom-building-maker-input-row col-6 input-group">
							<!-- <label class="form-label custom-building-maker-form-label col-4" id="buildingBlockLabel" for="bldngBlock">Building Block</label> -->
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-noOfLifts">No of Lifts</span>
							</div>
							<input 
								class="form-control col-8" 
								type="text" 
								id="noOfLifts" 
								name="noOfLifts" 
								aria-label="Default" 
								aria-describedby="inputGroup-noOfLifts"
								onkeypress="return isDigit(event)"
								onchange="validateNumInput"
								required
							> 
						</div>
						<div class="custom-building-maker-input-row col-6 input-group">
							<!-- <label class="form-label custom-building-maker-form-label col-4" id="buildingBlockLabel" for="bldngBlock">Building Block</label> -->
							<div class="input-group-prepend">
								<span class="input-group-text" id="inputGroup-reception">Is Receptionist Present</span>
							</div>
							<select class="custom-select col-6" id="reception" name="reception" aria-label="Default" aria-describedby="inputGroup-reception" required>
								<option value="" selected disabled>Select</option>
								<option value="1">Yes</option>
								<option value="0">No</option>
							</select>
						</div>
					</div>
					<div class="text-center">
						<button type="button" id="registerBldngBtn" class="btn btn-outline-success me-3 col-auto">Submit</button>
						<button type="reset" class="btn btn-outline-secondary col-auto">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>