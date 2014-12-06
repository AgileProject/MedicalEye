var webRoot = "/eye/";
var resourceWebRoot ="/eye/rest/";
(function() {
	var app = angular.module('App', 
			[
			 'ngRoute',
			 'UserControllers',
			 'UserServices',
             'ComputerControllers',
             'ComputerServices',
			 'MenuServices',
			 'CommonControllers'
			 ]);
	
	app.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/dashboard', {
			templateUrl : 'partials/dashboard.html',
			controller:'UserController'
		}).when('/statistics', {
			templateUrl : 'partials/statistics.html',
            controller:'ComputerController'
		}).otherwise({
			redirectTo : '/dashboard'
		});
	} ]);

})();