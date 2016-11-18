angular.module('App.Service')
	.service('ShoppingCartService', ['$http', '$cookies', 'BackendCfg',
        function ( $http, $cookies, BackendCfg) {
            var service = this;          

            service.productsGet = function (callback) {
            	$http.get(BackendCfg.url + '/api/test/products')
                	.success(function (response) {
                        callback(response);
                    }).error (function (erro) {
                    	
                    });
            };
            
            service.shoppingcartGet = function (callback) {
            	$http.get(BackendCfg.url + '/api/test/shoppingcart')
                	.success(function (response) {
                        callback(response);
                    }).error (function (erro) {
                    	
                    });
            };
            
            service.shoppingcartItemsPost = function (product_id, index, callback) {
            	//TODO Remover o uso de jQuery
            	$http.post(BackendCfg.url + '/api/test/shoppingcart/items?product_id=' + product_id + "&quantity=" + jQuery("#quantity_" + index).val())
                	.success(function (response) {
                        callback(response);
                    }).error (function (erro) {
                    	
                    });
            };
            
            service.shoppingcartItemsIdDelete = function (commerceItem_id, callback) {
            	$http.delete(BackendCfg.url + '/api/test/shoppingcart/items/' + commerceItem_id)
                	.success(function (response) {
                        callback(response);
                    }).error (function (erro) {
                    	
                    });
            };
            
            service.updateShoppingCartCookies = function (shoppingCart) {
            	$cookies.shoppingCart = JSON.stringify(shoppingCart);
            }
            
            service.getShoppingCartCookies = function () {
            	return ($cookies.shoppingCart ? JSON.parse($cookies.shoppingCart) : $cookies.shoppingCart);
            }
            
            return service;
    }]);