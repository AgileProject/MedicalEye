/**
 * Created by DL on 2014/12/7.
 */
(function() {
    var app = angular.module('HardwareControllers', []);

    app.controller('HardwareController', [ '$scope', 'Hardware',
        function($scope, Hardware) {
            $scope.hardwares = Hardware.get();
            $scope.showDetail = function(hardware) {
                $scope.hardware = hardware
            }
        } ]);
})();