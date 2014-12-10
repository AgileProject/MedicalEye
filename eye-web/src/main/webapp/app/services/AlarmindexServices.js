/**
 * Created by DL on 2014/12/7.
 */

(function() {
    var app = angular.module('AlarmindexServices', [ 'ngResource' ]);

    app.factory('Alarmindex', [ '$resource', function($resource) {
        return $resource(resourceWebRoot+'system/alarmindexs');
    } ]);

})();