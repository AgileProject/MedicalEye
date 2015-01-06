/**
 * Created by Mark on 2014/12/6.
 */
(function () {
    var app = angular.module("DetailInfo", ["chart.js", "ui.bootstrap"]);

    app.controller('HardwareInfoCtrl', [ '$scope', 'hardwareData', '$interval',
        function($scope, hardwareData, $interval) {
            $interval(function () {
                getHardwareData();
            }, 1000);

            function getHardwareData() {
                var promise = hardwareData.query();
                promise.then(function(data) {
                    $scope.hardwares = data;
                }, function(data) {
                    $scope.hardwares = {error: '数据不存在'};
                });
            }
//            $scope.hardwares = Hardware.get();
        } ]);

    app.controller('ctrl.show.tab', function ($scope) {
        var vm = $scope.vm = {};
    });

    app.controller("ComputerInfo", ['$scope','Hardware',
        function ($scope, Hardware) {
            $scope.hardwares = Hardware.get();
    }]);

    app.controller("TimeCtrl", function ($scope) {
        $scope.person = {name: "Ari Lerner"};

        var updateClock = function () {
            $scope.clock = new Date();
        };

        var timer = setInterval(function () {
            $scope.$apply(updateClock);
        }, 2000);

    });

    app.controller('TabsDemoCtrl', function ($scope, $window) {
        $scope.tabs = [
            {title: 'Dynamic Title 1', content: 'Dynamic content 1'},
            {title: 'Dynamic Title 2', content: 'Dynamic content 2', disabled: true}
        ];
    });

    app.controller("ShowComputerIDCtrl", function ($scope, $routeParams) {
        $scope.computerID = $routeParams.computerID;
    });

    app.controller("CPUTicksCtrl", ['$scope', '$interval', 'hardwareData', function ($scope, $interval, hardwareData) {
        var maximum = document.getElementById("container-cpu").clientWidth / 5 || 300;
        $scope.data = initData(maximum);
        $scope.labels = initLabel(maximum);
        $scope.options = {
            animation: false,
            showScale: true,
            showTooltips: false,
            pointDot: false,
            datasetStrokeWidth: 1,
            scaleOverride: true,
            // Number - The number of steps in a hard coded scale
            scaleSteps: 10,
            // Number - The value jump in the hard coded scale
            scaleStepWidth: 10,
            // Number - The scale starting value
            scaleStartValue: 0
        };



        // Update the dataset at 25FPS for a smoothly-animating chart
        $interval(function () {
            getLiveChartData();
        }, 1000);

        function getLiveChartData() {
            if ($scope.data[0].length) {
                $scope.labels = $scope.labels.slice(1);
                $scope.data[0] = $scope.data[0].slice(1);
            }
            $scope.labels.push('');
            //$scope.data[0].push(getRandomValue($scope.data[0]));
            $scope.data[0].push(getCpuData());
        }

            function getCpuData () {
                var promise = hardwareData.query();
                promise.then(function(data) {
                    $scope.cpu = data;
                }, function(data) {
                    $scope.cpu = {error: '数据不存在'};
                });
                return $scope.cpu.data.cpuUtilzation;
        }

    }]);

    app.controller("RAMTicksCtrl", ['$scope', '$interval','hardwareData' ,function ($scope, $interval, hardwareData) {
        var maximum = document.getElementById("container-ram").clientWidth / 5 || 300;
        $scope.data = initData(maximum);
        $scope.labels = initLabel(maximum);
        $scope.options = {
            animation: false,
            showScale: true,
            showTooltips: false,
            pointDot: false,
            datasetStrokeWidth: 1,
            scaleOverride: true,
            // Number - The number of steps in a hard coded scale
            scaleSteps: 10,
            // Number - The value jump in the hard coded scale
            scaleStepWidth: 10,
            // Number - The scale starting value
            scaleStartValue: 0
        };

        // Update the dataset at 25FPS for a smoothly-animating chart
        $interval(function () {
            getLiveChartData();
        }, 1000);

        function getLiveChartData() {
            if ($scope.data[0].length) {
                $scope.labels = $scope.labels.slice(1);
                $scope.data[0] = $scope.data[0].slice(1);
            }
//            $scope.labels.push('');
//            $scope.data[0].push(getRandomValue($scope.data[0]));
            var promise = hardwareData.query();
            promise.then(function(data) {
                $scope.ram = data;
            }, function(data) {
                $scope.ram = {error: '数据不存在'};
            });

            $scope.labels.push('');
            $scope.data[0].push($scope.ram.data.ramUsedpercent);
        }
    }]);

    function initData(number) {
        var data = [[]];
        for (var i = 0; i < number; i++) {
            data[0].push(0);
        }
        return data;
    }

    function initLabel(number) {
        var labels = [];
        for (var i = 0; i < number; i++) {
            labels.push('');
        }
        return labels;
    }

    function getRandomValue(data) {
        var l = data.length, previous = l ? data[l - 1] : 50;
        var y = previous + Math.random() * 10 - 5;
        return y < 0 ? 0 : y > 100 ? 100 : y;
    }
})();