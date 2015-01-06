/**
 *
 */

(function() {
    var app = angular.module('DatabaseServices', [ 'ngResource' ]);

    app.factory('Database', [ '$resource','$routeParams', function($resource, $routeParams) {
        return $resource(resourceWebRoot+'system/databases/'+$routeParams.computerID)
    } ]);
})();