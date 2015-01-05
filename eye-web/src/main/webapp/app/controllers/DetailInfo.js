/**
 * Created by Mark on 2014/12/6.
 */
(function () {
    var app = angular.module("DetailInfo", ["chart.js", "ui.bootstrap"]);

    app.controller('HardwareInfoCtrl', [ '$scope', 'Hardware',
        function($scope, Hardware) {
            $scope.hardwares = Hardware.get();
        } ]);

    app.controller('ctrl.show.tab', function ($scope) {
        var vm = $scope.vm = {};
    });

    app.controller("ComputerInfo", ['$scope', function ($scope) {
        $scope.informations = [];

        for (var i = 0; i < 3; i++) {
            $scope.informations.push({id: i, info: "Computer" + i});
        }
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
            showScale: false,
            showTooltips: false,
            pointDot: false,
            datasetStrokeWidth: 0.5
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
            showScale: false,
            showTooltips: false,
            pointDot: false,
            datasetStrokeWidth: 0.5
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