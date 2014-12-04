/**
 *
 */

(function() {
    var app = angular.module('ComputersServices', [ 'ngResource' ]);

    app.factory('Computers', [ '$resource', function($resource) {
        return $resource(resourceWebRoot+'system/computers');
    } ]);
})();