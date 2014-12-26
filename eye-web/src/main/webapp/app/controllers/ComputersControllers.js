(function() {
    var app = angular.module('ComputersControllers', []);

    app.controller('ComputersController', [ '$scope', 'Computer',
        function($scope, Computer) {
            //控制器属性
            $scope.computers = Computer.get();

        } ]);



})();