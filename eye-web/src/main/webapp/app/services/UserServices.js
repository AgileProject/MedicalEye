/**
 * 
 */

(function() {
	var app = angular.module('UserServices', [ 'ngResource' ]);

	app.factory('User', [ '$resource', function($resource) {
		return $resource(resourceWebRoot+'system/users');
	} ]);
})();