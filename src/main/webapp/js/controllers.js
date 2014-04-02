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

springFunControllers.controller('NewMessageController', function($scope, $http) {
    $scope.sendMessage = function() {
        var message = $scope.message;
        var params = JSON.stringify(message);
        $http.post('/message/create', params, {
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data, status, headers, config) {
            if(data.created) {
                $scope.messages.push(data.newMessage);
                $scope.message = {};
                $scope.errorMessage = null;
            } else {
                $scope.errorMessage = "Sending message failed!"
            }
        }).error(function (data, status, headers, config) {
            $scope.errorMessage = "Sending message failed!"
        });
    };
});