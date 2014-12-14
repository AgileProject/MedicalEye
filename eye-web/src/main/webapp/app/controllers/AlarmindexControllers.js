/**
 * Created by DL on 2014/12/7.
 */
(function() {
    var app = angular.module('AlarmindexControllers', []);

    app.controller('AlarmindexController', [ '$scope', 'Alarmindex',
        function($scope, Alarmindex) {
            $scope.alarmindexs = Alarmindex.get();
            $scope.update = function () {
                Alarmindex.update($scope.alarmindexs, function () {
                    alert("修改成功");
                });
            };
        }

    ]);
})();