var shoppingCartWebModule = angular.module('ShoppingCartWeb',                                    [
                                        //'ngAnimate',
                                        //'ngMessages',
                                        'ngRoute',
                                        'App.Common',
                                        'App.Service',
                                        'App'
                                    ]);

shoppingCartWebModule.config(['$routeProvider',
    function ($routeProvider){
        $routeProvider
        
        	.when('/shoppingcart', {
        		controller: 'AppController',
	            templateUrl: 'webui/views/shoppingCart.html',
	            controllerAs: 'app'
        	})

            .otherwise({ redirectTo: '/shoppingcart' });
    }
]);
