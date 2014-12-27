var webRoot = "/eye/";
var resourceWebRoot = "/eye/rest/";
(function () {
    var app = angular.module('App',
        [
            'ngRoute',
            'UserControllers',
            'UserServices',
            'MenuServices',
            'CommonControllers',
            'DetailInfo',
            'SystemMonitor'
        ]);

    app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/dashboard', {
            templateUrl: 'partials/dashboard.html',
            controller: 'UserController'
        }).when('/statistics/:computerID', {
            templateUrl: 'partials/computer_detail_info.html',
            controller:'CPUTicksCtrl',
            controller:'RAMTicksCtrl',
            controller:'ShowComputerIDCtrl'
        }).when('/system', {
            templateUrl: 'partials/system_monitor.html',
            controller:'ComputerStateCtrl'
        }).otherwise({
            redirectTo: '/dashboard'
        });
    }]);

})();