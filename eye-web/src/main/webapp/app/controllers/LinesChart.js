/**
 * Created by Mark on 2014/12/6.
 */
(function () {
    var app = angular.module("LinesChart", ["chart.js"]);
	
	app.controller("TimeCtrl",['$scope','cpuUtilzation'], function($scope,cpuUtilzation) {
		$scope.person = { name: "Ari Lerner" };


		var updateClock = function() {
//			$scope.clock = new Date();
            $scope.cpuState = cpuUtilzation.get();
		};
		
		var timer = setInterval(function() {
			$scope.$apply(updateClock);
		}, 2000);
		
	});

	app.controller("CPUTicksCtrl", ['$scope', '$interval', 'hardwareData', function ($scope, $interval, hardwareData) {
		var maximum = document.getElementById("container-cpu").clientWidth / 5 || 300

		$scope.data = [[]];
		$scope.labels = [];
		$scope.options = { animation: false, showScale : false, showTooltips : false, pointDot: false, datasetStrokeWidth : 0.5 };

//        $scope.cpuState = hardwareData.query();
//        $scope.show = function(cpuUtilzation) {
//            $scope.cpuState = cpuUtilzation.get();
//        };


		while ($scope.data[0].length < maximum) {
            $scope.labels.push('');
            $scope.data[0].push(getRandomValue($scope.data[0]));
        }


        //getLiveChartData();
		// Update the dataset at 25FPS for a smoothly-animating chart
		$interval(function () {
			getLiveChartData();
		}, 1000);
		
		function getLiveChartData () {
			if ($scope.data[0].length) {
				$scope.labels = $scope.labels.slice(1);
				$scope.data[0] = $scope.data[0].slice(1);
			}
//            var cpuState = cpuUtilzation.get();
//            var cpudata = $scope.cpuState.data;
//            $scope.show(cpuUtilzation);

//            var promise = hardwareData.query();
//            promise.then(function(data) {
//                $scope.cpu = data;
//            }, function(data) {
//                $scope.cpu = {error: '数据不存在'};
//            });

            $scope.labels.push('');
//            $scope.data[0].push($scope.cpu.data.cpuUtilzation);
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
	
	app.controller("RAMTicksCtrl", ['$scope', '$interval', 'hardwareData', function ($scope, $interval, hardwareData) {
		var maximum = document.getElementById("container-ram").clientWidth / 5 || 300;
		$scope.data = [[]];
		$scope.labels = [];
		$scope.options = { animation: false, showScale : false, showTooltips : false, pointDot: false, datasetStrokeWidth : 0.5 };

		while ($scope.data[0].length < maximum) {
            $scope.labels.push('');
            $scope.data[0].push(0);
        }
		
		// Update the dataset at 25FPS for a smoothly-animating chart
		$interval(function () {
			getLiveChartData();
		}, 60000);
		
		function getLiveChartData () {
			if ($scope.data[0].length) {
				$scope.labels = $scope.labels.slice(1);
				$scope.data[0] = $scope.data[0].slice(1);
			}


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

    function getRandomValue(data) {
        var l = data.length, previous = l ? data[l - 1] : 50;
        var y = previous + Math.random() * 10 - 5;
        return y < 0 ? 0 : y > 100 ? 100 : y;
    }

})();