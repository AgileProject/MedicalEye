(function() {
    var app = angular.module('DatabaseControllers', []);

    app.controller('DatabaseController', [ '$scope', 'Database',
        function($scope, Database) {
            $scope.databases = Database.get();
        } ]);
})();