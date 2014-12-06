/**
 * 
 */

(function() {
	var app = angular.module('ComputerServices', [ 'ngResource' ]);

	app.factory('Computer', [ '$resource', function($resource) {
		return $resource(resourceWebRoot+'system/computers');
	} ]);
})();