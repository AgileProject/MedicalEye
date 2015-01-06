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
                'DetailInfo',
                'SystemMonitor',
                'ChartServices'
			 ]);
	
	app.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/dashboard', {
			templateUrl : 'partials/dashboard.html',
			controller:'UserController'
		}).when('/system', {
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