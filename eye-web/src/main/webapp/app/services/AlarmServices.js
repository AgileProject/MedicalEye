/**
 * Created by DL on 2014/12/7.
 */

(function() {
    var app = angular.module('AlarmServices', [ 'ngResource' ]);

    app.factory('Alarm', [ '$resource', function($resource) {
        return $resource(resourceWebRoot+'system/alarms');
    } ]);

})();