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
                'ComputerControllers',
                'ComputerServices',
                'AlarmControllers',
                'AlarmServices',
                'AlarmindexControllers',
                'AlarmindexServices',
                'HardwareControllers',
                'HardwareServices',
                'DatabaseControllers',
                'DatabaseServices',
                'LinesChart',
			 ]);
	
	app.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/dashboard', {
			templateUrl : 'partials/dashboard.html',
			controller:'UserController'
		}).when('/statistics', {
			templateUrl : 'partials/statistics.html'
        }).when('/alarms', {
            templateUrl : 'partials/alarms.html'
        }).when('/personsettings', {
            templateUrl : 'partials/personsettings.html'
        }).when('/alarmsettings', {
            templateUrl : 'partials/alarmsettings.html'
        }).when('/test', {
            templateUrl : 'partials/test.html'
		}).otherwise({
			redirectTo : '/dashboard'
		});
	} ]);

})();