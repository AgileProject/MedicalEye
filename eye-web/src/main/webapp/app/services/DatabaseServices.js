/**
 * Created by DL on 2014/12/7.
 */
(function() {
    var app = angular.module('DatabaseServices', [ 'ngResource' ]);
    app.factory('Database', [ '$resource','$routeParams', function($resource, $routeParams) {
        return $resource(resourceWebRoot+'system/databases/'+$routeParams.computerID)
    } ]);
})();