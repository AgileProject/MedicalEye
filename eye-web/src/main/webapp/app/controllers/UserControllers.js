(function() {
	var app = angular.module('UserControllers', []);
	app.controller('UserController', [ '$scope', 'User',
			function($scope, User) {
				$scope.users = User.get();
				$scope.showDetail = function(user) {
					$scope.user = user;
					$('#myModal').modal('show');
				};
                $scope.save = function(user) {
                    alert(user.employeeName);
//                    alert("修改成功");
                }
			} ]);

	app.filter('userStatusFilter', function() {
		return function(value) {
			if (value == 1)
				return "启动";
			else {
				return "未启动"
			}
		}
	});

})();