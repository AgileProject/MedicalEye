(function() {
	var app = angular.module('UserControllers', []);

	app.controller('UserController', [ '$scope', 'User',
			function($scope, User) {
				$scope.users = User.get();
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