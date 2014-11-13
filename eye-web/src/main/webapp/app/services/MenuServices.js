/**
 * 
 */

(function() {
	var app = angular.module('MenuServices', [ 'ngResource' ]);

	app.factory('Menus', [ '$resource', function($resource) {
		return $resource('data/:name.json', {}, {
			query : {
				method : 'GET',
				isArray : true
			}
		});
	} ]);
})();