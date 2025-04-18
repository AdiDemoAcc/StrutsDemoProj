/**
 * 
 */

function loadPage(url) {
	var contextPath = window.location.pathname.split('/')[1];
	$('#dashboardMainContent').html('<p>Loading</p>');
	
	$.ajax({
		url: '/'+contextPath+url,
		type: 'GET',
		success: function(response) {
			$('#dashboardMainContent').html(response);
		},
		error: function(xhr,status,error) {
			$('#dashboardMainContent').html('<p>Something went wrong. Please try again after some time.');
		}
	})
}


$(document).ready(function() {
	var contextPath = window.location.pathname.split('/')[1];
	var menuUrl = '/'+ contextPath + '/login/getMenu';
	
	$.ajax({
		url : menuUrl,
		type: 'GET',
		success: function(response) {
			if(response.status === 'success') {
				
				var menuheaderList = response.menuHeaders;
				var menuOptionList = response.menuOptions;
				
				var sidebarHtml = '';
				
				menuheaderList.forEach(function (header) {
					
					var filteredOptions = menuOptionList.filter(function (option) {
						return option.menuId === header.menuId;
					});
					
					debugger;
					
					var headerId = 'menuHeaderId_'+header.menuTabId;
					
					sidebarHtml += `
						<div class="menu-section">
							<h5 class="menu-header" data-toggle="collapse" data-target="#${headerId}">
								${header.menuName}
							</h5>
							<div class="collapse" id="${headerId}">
								<ul class="menu-options">
					`;
					
					filteredOptions.forEach(function (option) {
						sidebarHtml += `
							<li>
								<a href="javascript:void(0)" onclick="loadPage('${option.itemMenuAction}')">
									${option.menuItemName}
								</a>
							</li>
						`;
					});
					
					sidebarHtml += '</ul></div></div>'
					
				});
				
				$('#sidebar').html(sidebarHtml);
			}
		},
		
		error: function() {
			$('#sidebar').html('<p>Error Loading Menu</p>');
		}
	})
	
})