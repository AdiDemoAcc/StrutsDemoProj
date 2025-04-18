$(document).ready(function () {
	
	var contextPath = window.location.pathname.split('/')[1];
	
	$.ajax({
		url: '/' + contextPath + '/bldng/getAllBldng',
		method: 'GET',
		success: function(response) {
			if(response.status === 'success') {
				
			}
		}
	})
})