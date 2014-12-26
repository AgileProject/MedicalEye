/**
 * Created by Mark on 2014/12/9.
 */
(function () {
    var app = angular.module("SystemMonitor", []);

    app.controller("ComputerStateCtrl", ['$scope', '$interval', function ($scope, $interval) {
        $scope.computers = [];

        for (var i = 0; i < 3; i++) {
            $scope.computers.push({name: i, ip: "192.168.0." + i, cpu: "20%", ram: "10%"});
        }

        $interval(function () {
            $scope.computers[1].cpu = "30%";
        }, 1000);
    }]);
})();