var springFun = angular.module('springFun', []);

springFun.controller('mainController', function($scope, $http) {
    $scope.messages = [];
    var futureResponse = $http.get('/message/list/0');
    futureResponse.success(function (data, status, headers, config) {
        $scope.messages = data;
    });
    futureResponse.error(function (data, status, headers, config) {
        $scope.errorMessage = "Error occured while connecting to application!";
    });
});