(function() {
    var app = angular.module('ComputersControllers', []);

    app.controller('ComputersController', [ '$scope', 'Computers',
        function($scope, Computers) {
            //控制器属性
            $scope.computers = Computers.get();

        } ]);



})();