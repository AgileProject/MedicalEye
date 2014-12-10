/**
 * Created by DL on 2014/12/7.
 */
(function() {
    var app = angular.module('HardwareServices', [ 'ngResource' ]);

    app.factory('Hardware', [ '$resource', function($resource) {
        return $resource(resourceWebRoot+'system/hardwares');
    } ]);
})();