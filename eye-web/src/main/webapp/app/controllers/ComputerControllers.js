(function() {
	var app = angular.module('ComputerControllers', []);

	app.controller('ComputerController', [ '$scope', 'Computer',
			function($scope, Computer) {
				$scope.computers = Computer.get();
				$scope.showDetail = function(computer) {
					$scope.computer = computer
					$('#myModal').modal('show');
				}
			} ]);
})();