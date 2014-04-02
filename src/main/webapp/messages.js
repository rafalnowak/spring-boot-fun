var springFun = angular.module('springFun', ['ngRoute', 'springFunControllers']);

springFun.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when("/list", {
            templateUrl: 'templates/list.html',
            controller: 'MessagesController'
        }).
        when('/index', {
            templateUrl: 'templates/hello.html'
        }).
        when('/about', {
            templateUrl: 'templates/about.html'
        }).
        otherwise({
            redirectTo: '/index'
        });
}]);
