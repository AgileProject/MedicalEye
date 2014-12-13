(function(){
    var app = angular.module('AuthenticationControllers', []);

    app.controller('AuthenticationController', [ '$location','Authentication',
        function($location,Authentication) {
            this.login = function() {
            	Authentication.login(this.user, function(result) {
            		window.location = webRoot+"app/index.html";
                }, function(result) {
                    alert("登录失败:" + result.data.message);
                });
            };
        } ]);
    
})();