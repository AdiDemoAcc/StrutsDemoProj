$(document).ready(function() {
	var contextPath = window.location.pathname.split('/')[1];
	
	$('#registerBldngBtn').click(function () {
		var bldngName = $('#bldngName');
		var bldngBlock = $('#bldngBlock');
		var noOfApartments = $('#noOfApartments');
		var noOfFloors = $('#noOfFloors');
		var noOfLifts = $('#noOfLifts');
		var reception = $('#reception');
		
		var formData = {
			"building.bldngName" : bldngName.val(),
			"building.bldngBlock" : bldngBlock.val(),
			"building.noOfApartments" : noOfApartments.val(),
			"building.noOfFloors" : noOfFloors.val(),
			"building.noOfLifts" : noOfLifts.val(),
			"building.reception" : reception.val()
		}
		
		console.log("formdata: ",formData );
		
		$.ajax({
			url: "/" + contextPath +"/bldng/makerAction",
			method: 'POST',
			data: formData,
			success:  function(response) {
				
			} 
		})
	});
	
	
	
	
})

function isDigit(event) {
	var charCode = event.which ? event.which : event.keyCode;
	var charStr = String.fromCharCode(charCode);
		
	if(!/^[0-9]$/.test(charStr)) {
		event.preventDefault();
	}
};
	
function validateNumInput() {
	this.value = this.value.replace(/[^0-9]/g, '');
};