/**
 *
 */

(function() {
    var app = angular.module('DatabaseServices', [ 'ngResource' ]);

    app.factory('Database', [ '$resource', function($resource) {
        return $resource(resourceWebRoot+'system/databases')
    } ]);
})();