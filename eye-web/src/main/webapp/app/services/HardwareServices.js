/**
 *
 */

(function() {
    var app = angular.module('HardwareServices', [ 'ngResource' ]);

    app.factory('Hardware', [ '$resource', function($resource) {
        return $resource(resourceWebRoot+'system/hardwares/com11')
    } ]);
})();