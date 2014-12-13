/**
 * 
 */

(function() {
	var app = angular.module('AuthenticationServices', [ 'ngResource' ]);

	app.factory('Authentication', [ '$resource', function($resource) {
		return $resource(resourceWebRoot+'authentication', {}, {
			login : {
				method : 'post'
			}
		});
	} ]);
})();