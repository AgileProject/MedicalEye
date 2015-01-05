/**
 *
 */

(function() {
    var app = angular.module('HardwareServices', ['ngResource']);

    app.factory('Hardware', [ '$resource','$routeParams', function($resource, $routeParams) {
        return $resource(resourceWebRoot+'system/hardwares/'+$routeParams.computerID);
    } ]);
})();



