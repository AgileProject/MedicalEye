(function() {
	var app = angular.module('UserControllers',[ ]);

	app.controller('UserController', [ '$scope', 'User',
			function($scope, User) {
				$scope.users = User.get();
				$scope.showDetail = function(user) {
					$scope.user = user;
					$('#myModal').modal('show');
				};
                $scope.updata = function() {
                    User.updata($scope.users.data[0], function() {
                        alert("修改成功" );
                    });
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

	//app.controller("BarCtrlPro", function ($scope) {
	//	$scope.labels = ['','服务器','', '数据库',''];
	//	$scope.data = [
	//		[null,3,null,1,null]
	//	];
	//});
	app.controller("BarCtrlPro", function ($scope) {

		$scope.labels = ['','服务器','', '数据库',''];
		$scope.data = [
			[null,4,null,2,null]
		];

	});

	app.controller("BarCtrlWar", function ($scope) {
		$scope.labels = ['','服务器','', '数据库',''];
		$scope.data = [
			[null,4,null,1,null]
		];
	});

})();