angular.module('App').controller('AppController', AppController);

AppController.$inject = ['$scope', 'ShoppingCartService'];
function AppController($scope, ShoppingCartService) {
    var app = this;
    
    $scope.showCase = [];
    $scope.commerceItems = [];
    
    $scope.createCommerceItem = function(commerceItem){
   	   	$scope.commerceItems.push(commerceItem);
    } 
    
    $scope.removeCommerceItem = function(commerceItem){
    	var index = $scope.commerceItems.indexOf(commerceItem);
    	$scope.commerceItems.splice(index, 1);
    } 
    
    $scope.getCartTotal = function(){
        var total = 0;
        for(var i = 0; i < $scope.commerceItems.length; i++){
            var commerceItem = $scope.commerceItems[i];
            total += ($scope.commerceItems[i].amount);
        }
        return total;
    }
   	
    
    app.productsGet = function () {
        ShoppingCartService.productsGet(function (response) {
        	$scope.showCase = response.result;
        });
    };
    
    app.shoppingcartGet = function () {
        ShoppingCartService.shoppingcartGet(function (response) {
    		if (!ShoppingCartService.getShoppingCartCookies()) {
    		    console.log("Shopping Cart Created");    		    
    		    return
    		}	
    		//TODO Atualizar oS items do carrinho (backEnd)    		
    		$scope.commerceItems = ShoppingCartService.getShoppingCartCookies();
		    console.log("Shopping Car Cookies\nsize: " + $scope.commerceItems.length);    		    
        });
    };
    
    app.shoppingcartItemsPost = function (product_id, index) {
    	ShoppingCartService.shoppingcartItemsPost(product_id, index, function (response) {
    		//TODO Remover o uso de jQuery
    		jQuery("#quantity_" + index).val('');
        	$scope.createCommerceItem(response.result);
        	ShoppingCartService.updateShoppingCartCookies($scope.commerceItems);
        });
    };
    
    app.shoppingcartItemsIdDelete = function (commerceItem) {
        ShoppingCartService.shoppingcartItemsIdDelete(commerceItem.id, function (response) {
        	console.log(response.result);
        	$scope.removeCommerceItem(commerceItem);
        	ShoppingCartService.updateShoppingCartCookies($scope.commerceItems);
        });
    };
    
   	app.shoppingcartGet(); 
   	app.productsGet();
};