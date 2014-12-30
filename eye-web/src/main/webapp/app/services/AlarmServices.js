/**
 * Created by DL on 2014/12/7.
 */

(function() {
    var app = angular.module('AlarmServices', [ 'ngResource' ]);

//    app.factory('Alarm', [ '$resource', function($resource) {
//        return $resource(resourceWebRoot+'system/alarms');
//    } ]);

    app.factory('Alarm',['$http', '$q', function($http, $q){
        return{
            query:function() {
                var deferred = $q.defer();
                $http({method:'GET', url:resourceWebRoot+'system/alarms'}).
                    success(function(data,status,headers,config) {
                        deferred.resolve(data);
                    }).error(function(data,status,headers,config) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            }

        };
    }]);

})();