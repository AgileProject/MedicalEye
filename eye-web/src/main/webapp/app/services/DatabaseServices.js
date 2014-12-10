/**
 * Created by DL on 2014/12/7.
 */
(function() {
    var app = angular.module('DatabaseServices', [ 'ngResource' ]);

    app.factory('Database', [ '$resource', function($resource) {
        return $resource(resourceWebRoot+'system/databases');
    } ]);
})();