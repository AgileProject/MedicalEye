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
            'LinesChart',
            'SystemMonitor'
        ]);

    app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/dashboard', {
            templateUrl: 'partials/dashboard.html',
            controller: 'UserController'
        }).when('/statistics', {
            templateUrl: 'partials/statistics.html',
            controller:'CPUTicksCtrl',
            controller:'RAMTicksCtrl'
        }).when('/system', {
            templateUrl: 'partials/system_monitor.html',
            controller:'ComputerStateCtrl'
        }).otherwise({
            redirectTo: '/dashboard'
        });
    }]);

})();