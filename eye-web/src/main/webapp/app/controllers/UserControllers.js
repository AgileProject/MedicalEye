(function() {
	var app = angular.module('UserControllers',[ ]);

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

	app.controller("BarCtrl",function ($scope) {
		$scope.labels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
		$scope.series = ['Series A', 'Series B'];
		$scope.data = [
			[65, 59, 80, 81, 56, 55, 40],
			[28, 48, 40, 19, 86, 27, 90]
		];
	});
})();