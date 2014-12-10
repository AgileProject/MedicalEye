/**
 * Created by DL on 2014/12/7.
 */
(function() {
    var app = angular.module('DatabaseControllers', []);

    app.controller('DatabaseController', [ '$scope', 'Database',
        function($scope, Database) {
            $scope.databases = Database.get();
            $scope.showDetail = function(database) {
                $scope.database = database
            }
        } ]);
})();