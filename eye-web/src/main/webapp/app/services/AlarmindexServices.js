/**
 * Created by DL on 2014/12/7.
 */

(function() {
    var app = angular.module('AlarmindexServices', [ 'ngResource' ]);

    app.factory('Alarmindex', [ '$resource', function($resource) {
        return $resource(resourceWebRoot+'system/alarmindexs',{}, {
            update : {
                method : 'put'
            }
        });
    } ]);

//    app.factory('Alarmindex',['$http', '$q', function($http, $q){
//        return{
//            query:function() {
//                var deferred = $q.defer();
//                $http({method:'GET', url:resourceWebRoot+'system/alarmindexs'}).
//                    success(function(data,status,headers,config) {
//                        deferred.resolve(data);
//                    }).error(function(data,status,headers,config) {
//                        deferred.reject(data);
//                    });
//                return deferred.promise;
//            }
//        };
//    }]);

})();