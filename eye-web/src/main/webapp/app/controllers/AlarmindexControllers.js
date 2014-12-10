/**
 * Created by DL on 2014/12/7.
 */
(function() {
    var app = angular.module('AlarmindexControllers', []);

    app.controller('AlarmindexController', [ '$scope', 'Alarmindex',
        function($scope, Alarmindex) {
            $scope.alarmindexs = Alarmindex.get();
        } ]);
})();