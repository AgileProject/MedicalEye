(function() {
	var app = angular.module('UserControllers', []);

	app.controller('UserController', [ '$scope', 'User',
			function($scope, User) {
                //控制器属性
				$scope.users = User.get();
                //控制器方法
				$scope.showDetail = function(user) {
					$scope.user = user
					$('#myModal').modal('show');
				}
			} ]);

	app.filter('userStatusFilter', function() {
		return function(value) {
			if (value == 1)
				return "启动"
			else {
				return "未启动"
			}
		}
	});

})();