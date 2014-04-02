var springFunControllers = angular.module('springFunControllers', []);

springFunControllers.controller('MessagesController', function($scope, $http) {
    $scope.messages = [];
    $http.get('/message/all').success(function (data, status, headers, config) {
        $scope.messages = data;
    }).error(function (data, status, headers, config) {
        $scope.errorMessage = "Can't retrieve messages list!";
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

springFunControllers.controller('DeleteMessageController', function($scope, $http) {
    $scope.deleteMessage = function(id) {
        $http.delete('/message/delete/' + id).success(function (data, status, headers, config) {
            $scope.messages = $scope.messages.filter(function(message) {
                    return message.id != id;
                }
            );
        }).error(function (data, status, headers, config) {
            $scope.errorMessage = "Can't delete message!";
        });
    };
});
