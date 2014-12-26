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
             'ComputersControllers',
             'ComputersServices',
             'HardwareControllers',
             'HardwareServices',
             'ChartServices',
             'LinesChart'

			 ]);
	
	app.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/dashboard', {
			templateUrl : 'partials/dashboard.html',
			controller:'UserController'
		}).when('/statistics', {
            templateUrl: 'partials/statistics.html',
            controller: 'ComputersController'
        }).when('/propertyMonitor',{
            templateUrl:'partials/propertyMonitor.html',
            controller:'HardwareController'
        }).when('/chart', {
            templateUrl:'partials/chart.html',
            controller:'CPUTicksCtrl'
            //controller:'RAMTicksCtrl'
        }).otherwise({
			redirectTo : '/dashboard'
		});
	} ]);

})();