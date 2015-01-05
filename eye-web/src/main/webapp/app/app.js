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
             'DetailInfo',
             'SystemMonitor',
             'ChartServices'
			 ]);
	
	app.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/dashboard', {
			templateUrl : 'partials/dashboard.html',
			controller:'UserController'
		}).when('/propertyMonitor',{
            templateUrl:'partials/propertyMonitor.html',
            controller:'HardwareController'
        }).when('/detail/:computerID', {
            templateUrl: 'partials/computer_detail_info.html',
            controller:'CPUTicksCtrl',
            controller:'RAMTicksCtrl',
            controller:'ShowComputerIDCtrl'
        }).when('/system', {
            templateUrl: 'partials/system_monitor.html',
            controller:'ComputerStateCtrl'
        }).otherwise({
			redirectTo : '/dashboard'
		});
	} ]);

})();