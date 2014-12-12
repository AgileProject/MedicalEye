var webRoot = "/eye/";
var resourceWebRoot ="/eye/rest/";
(function() {
	var app = angular.module('App', 
			[
			 'ngRoute',
			 'UserControllers',
			 'UserServices',
			 'MenuServices',
			 'CommonControllers',
			 'LinesChart',



			 ]);
	
	app.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/dashboard', {
			templateUrl : 'partials/dashboard.html',
			controller:'UserController'
		}).when('/warnings', {
			templateUrl : 'partials/warnings.html'
		}).when('/personsettings', {
			templateUrl : 'partials/personsettings.html'
		}).when('/data', {
			templateUrl : 'partials/data.html',
			controller:'CPUTicksCtrl'

		}).otherwise({
			redirectTo : '/dashboard'
		});
	} ]);



})();