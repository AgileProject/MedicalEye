/**
 * Created by ling on 2014/12/10.
 */

(function() {
    var app = angular.module('ChartServices', [ 'ngResource' ]);

//    app.factory('cpuUtilzation', [ '$resource', function($resource) {
////        var Cpu = $resource(resourceWebRoot+'system/hardwares/com11/cpuUtilzation');
////        var cpudata = Cpu.get();
////        return cpudata;
//        return $resource(resourceWebRoot+'system/hardwares/com11/cpuUtilzation');
//
//
//    } ]);

    app.factory('hardwareData',['$http', '$q', '$routeParams', function($http, $q, $routeParams){
        return{
            query:function() {
                var deferred = $q.defer();
                $http({method:'GET', url:resourceWebRoot+'system/hardwares/' + $routeParams.computerID}).
                    success(function(data,status,headers,config) {
                        deferred.resolve(data);
                    }).error(function(data,status,headers,config) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            }

        };
    }]);

    app.factory('cpuUtilzation',['$http', '$q', function($http, $q){
        return{
            query:function() {
                var deferred = $q.defer();
                $http({method:'GET', url:resourceWebRoot+'system/hardwares/com1/cpuUtilzation'}).
                    success(function(data,status,headers,config) {
                        deferred.resolve(data);
                    }).error(function(data,status,headers,config) {
                        deferred.reject(data);
                    });
                return deferred.promise;
            }

        };
    }]);

    app.factory('ramUsedpercent',['$http', '$q', function($http, $q){
        return{
            query:function() {
                var deferred = $q.defer();
                $http({method:'GET', url:resourceWebRoot+'system/hardwares/com11/ramUsedpercent'}).
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