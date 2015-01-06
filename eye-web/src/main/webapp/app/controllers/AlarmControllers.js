/**
 * Created by DL on 2014/12/7.
 */
(function () {
    var app = angular.module('AlarmControllers', []);

    app.controller('AlarmController', [ '$scope', '$interval', 'Alarm',
        function ($scope, $interval, Alarm, Alarmpage) {
            $scope.alarms = [];
            getAlarmData();

//            定时获取数据
            $interval(function () {
                getAlarmData ();
            }, 10000);

//             获取数据
            function getAlarmData () {
                var promise = Alarm.query();
                promise.then(function(data) {
                    $scope.alarms = data;
                }, function(data) {
                    $scope.alarms = {error: '数据不存在'};
                });

                return $scope.alarm;
            }


            // 设置分页参数
            $scope.currentPage = 0;
            $scope.pageSize = 8;
            //获取页数
            $scope.numberOfPages = function () {
                return Math.ceil($scope.alarms.data.length / $scope.pageSize)-1;
            };
            //设置当前页数
            $scope.setCurrentPage = function (currentPage) {
                $scope.currentPage = currentPage;
            };

            //前一页
            $scope.previousPage = function () {
                if($scope.currentPage>0){
                $scope.currentPage--;
                }
            };
           //前一页失效
            $scope.previousPageDisabled = function() {
                return $scope.currentPage === 0 ? "disabled" : "";
            };
           //后一页
            $scope.nextPage = function () {
                if($scope.currentPage<$scope.numberOfPages()){
                    $scope.currentPage++;
                }
            };
            //后一页失效
            $scope.nextPageDisabled = function() {
                return $scope.currentPage === $scope.numberOfPages() ? "disabled" : "";
            }


            //转到第一页
            $scope.turnFirstPage = function() {
                $scope.currentPage=0;
            }

            //转到最后一页
            $scope.turnLastPage = function() {
                $scope.currentPage=$scope.numberOfPages();
            }

        } ]);

    app.filter('startFrom', function() {
        return function (input, start) {
            start = parseInt(start, 10);
            return input.slice(start);
        }
    } );
})();