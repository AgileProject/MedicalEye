(function() {
	var app = angular.module('CommonControllers', []);

	app.controller('MenuController', [ '$scope', 'Menus',
			function($scope, Menus) {
				$scope.homeMenus = Menus.query({
					name : "homeMenu"
				});
				$scope.selectMenu = function(menu) {
					for ( var o in $scope.homeMenus) {
						var menus = $scope.homeMenus[o].menus;
						for ( var w in menus) {
							if (menus[w].active) {
								menus[w].active = false;
							}
						}
					}
					menu.active = true;
				}
			} ]);

})();