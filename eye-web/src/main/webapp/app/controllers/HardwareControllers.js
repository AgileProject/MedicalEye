(function() {
    var app = angular.module('HardwareControllers', []);

    app.controller('HardwareController', [ '$scope', 'Hardware',
        function($scope, Hardware) {
            $scope.hardwares = Hardware.get();
            //控制器方法

        } ]);


})();