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
             'DatabaseControllers',
             'DatabaseServices',
             'DetailInfo',
             'SystemMonitor',
             'ChartServices'
			 ]);
	
	app.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/system', {
            templateUrl: 'partials/system_monitor.html',
            controller:'ComputerStateCtrl'
		}).when('/databaseMonitor', {
            templateUrl: 'partials/databaseMonitor.html',
            controller: 'ComputerStateCtrl'
        }).when('/databasedetail/:computerID',{
            templateUrl: 'partials/database_detail_info.html',
            controller:  'DatabaseController',
            controller:  'ShowComputerIDCtrl'
        }).when('/detail/:computerID', {
            templateUrl: 'partials/computer_detail_info.html',
            controller:'CPUTicksCtrl',
            controller:'RAMTicksCtrl',
            controller:'ComputerInfo',
            controller:'ShowComputerIDCtrl'
        }).when('/dashboard', {
            templateUrl : 'partials/dashboard.html',
            controller:'UserController'
        }).otherwise({
			redirectTo : '/system'
		});
	} ]);

})();