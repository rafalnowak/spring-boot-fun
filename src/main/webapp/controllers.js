var springFunControllers = angular.module('springFunControllers', []);

springFunControllers.controller('MessagesController', function($scope, $http) {
    $scope.messages = [];
    var futureResponse = $http.get('/message/all');
    futureResponse.success(function (data, status, headers, config) {
        $scope.messages = data;
    });
    futureResponse.error(function (data, status, headers, config) {
        $scope.errorMessage = "Error occured while connecting to application!";
    });
});