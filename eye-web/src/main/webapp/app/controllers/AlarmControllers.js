/**
 * Created by DL on 2014/12/7.
 */
(function() {
    var app = angular.module('AlarmControllers', []);

    app.controller('AlarmController', [ '$scope', 'Alarm',
        function($scope, Alarm) {
            $scope.alarms = Alarm.get();
        } ]);
})();