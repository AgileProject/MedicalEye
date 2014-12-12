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
             'CommonControllers',
             'ComputerControllers',
                'AlarmControllers',
                'AlarmServices',
                'AlarmindexControllers',
                'AlarmindexServices',
                'HardwareControllers',
                'HardwareServices',
                'DatabaseControllers',
                'DatabaseServices'


			 ]);
	
	app.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/dashboard', {
			templateUrl : 'partials/dashboard.html',
			controller:'UserController'
		}).when('/statistics', {
            templateUrl : 'partials/statistics.html'
        }).when('/data', {
            templateUrl : 'partials/data.html'
        }).when('/alarms', {
            templateUrl : 'partials/alarms.html'
        }).when('/alarmsettings', {
            templateUrl : 'partials/alarmsettings.html'
        }).when('/personsettings', {
            templateUrl : 'partials/personsettings.html'
        }).when('/test', {
            templateUrl : 'partials/test.html'
		}).otherwise({
			redirectTo : '/dashboard'
		});
	} ]);



})();