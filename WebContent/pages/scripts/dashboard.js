/**
 * 
 */

$(document).ready(function() {
	/*var menuHeadersList = JSON.parse(document.getElementById("menuHeadersJson").textContent);
	var menuOptionsList = JSON.parse(document.getElementById("menuOptionsJson").textContent);*/

	var contextPath = window.location.pathname.split('/')[1];
	var url = '/' + contextPath + '/login/getMenu';

	$.ajax({
		url: url,
		method: 'GET',
		success: function(response) {
			if (response.status === "success") {
				var menuHeadersList = response.menuHeaders;
				var menuOptionsList = response.menuOptions;

				var navContainer = $('#dashboardNavButtonTab');

				navContainer.empty();

				menuHeadersList.forEach(menuHeader => {
					var dropDownItem = `
								 <div class="nav-item dropdown custom-dashboard-nav-item-dropdown">
								 	<button class="btn nav-link dropdown-toggle custom-dashboard-nav-button" href="#" id="custom${menuHeader.menuTabId}Dropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${menuHeader.menuName}</button>
									<ul class="dropdown-menu" aria-labelledby="custom${menuHeader.menuTabId}Dropdown"> 
							`;

					var filterOptions = menuOptionsList.filter(function(option) {
						return option.menuId === menuHeader.menuId;
					});

					filterOptions.forEach(function(option) {
						dropDownItem += `
									<li><a class="dropdown-item" href="#" id="custom${option.menuItemNameId}">${option.menuItemName}</a></li>
								`;
					});

					dropDownItem += '</ul></li>';

					navContainer.append(dropDownItem);
				});

			} else {
				console.error(response.message);
			}
		},
		error: function(xhr, status, error) {
			console.error("Error fetching menu: " + error);
		}
	});

});