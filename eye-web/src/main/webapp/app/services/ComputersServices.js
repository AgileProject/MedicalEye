/**
 *
 */

(function() {
    var app = angular.module('ComputersServices', [ 'ngResource' ]);

    app.factory('Computer', [ '$resource', function($resource) {
        return $resource(resourceWebRoot+'system/computers')
    } ]);
})();