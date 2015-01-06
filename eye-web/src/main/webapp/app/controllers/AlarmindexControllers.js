/**
 * Created by DL on 2014/12/7.
 */
(function() {
    var app = angular.module('AlarmindexControllers', []);

    app.controller('AlarmindexController', [ '$scope', 'Alarmindex',
        function($scope, Alarmindex) {
            $scope.alarmindexs = [];
//            $scope.alarmDBindexs=[];
//            getAlarmDBindexsData ();
            //获取报警指标数据
            Alarmindex.get(function (data) {
                $scope.alarmindexs = data;
            });

//            //获取数据库指标数据
//            function getAlarmDBindexsData () {
//                var j = 0;
//                for (var i = 0; i < $scope.alarmindexs.data.length; i++) {
//                    if($scope.alarmindexs.data[i].databaseName != null){
//                    $scope.alarmDBindexs.data[j] = $scope.alarmindexs.data[i];
//                        j++;
//                    }
//                }
//            }
            //修改报警指标
            $scope.update = function () {
                Alarmindex.update($scope.alarmindexs.data, function () {
                    alert("修改成功");
                });
            };


            // 设置分页参数
            $scope.currentPage = 0;
            $scope.pageSize = 6;

            //获取页数
            $scope.numberOfPages = function () {
                return Math.ceil($scope.alarmindexs.data.length / $scope.pageSize) - 1;
            };

            //设置当前页数
            $scope.setCurrentPage = function (currentPage) {
                $scope.currentPage = currentPage;
            };

            //前一页
            $scope.previousPage = function () {
                if ($scope.currentPage > 0) {
                    $scope.currentPage--;
                }
            };

            //前一页失效
            $scope.previousPageDisabled = function () {
                return $scope.currentPage === 0 ? "disabled" : "";
            };

            //后一页
            $scope.nextPage = function () {
                if ($scope.currentPage < $scope.numberOfPages()) {
                    $scope.currentPage++;
                }
            };
            //后一页失效
            $scope.nextPageDisabled = function () {
                return $scope.currentPage === $scope.numberOfPages() ? "disabled" : "";
            };


            //转到第一页
            $scope.turnFirstPage = function () {
                $scope.currentPage = 0;
            };

            //转到最后一页
            $scope.turnLastPage = function () {
                $scope.currentPage = $scope.numberOfPages();
            }


            //数据库报警指标显示
            $scope.setDBdisplay = function () {
                document.getElementById("CPUAlarmindexs").style.display = "none";
                document.getElementById("DBAlarmindexs").style.display = "inline";
                $scope.currentPage=0;
            }

            //电脑报警指标显示
            $scope.setCPUdisplay = function () {
                document.getElementById("CPUAlarmindexs").style.display = "inline";
                document.getElementById("DBAlarmindexs").style.display = "none";
                $scope.currentPage=0;
            }


        }

    ]);
})();