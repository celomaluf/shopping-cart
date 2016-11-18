package br.com.shoppingCart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.shoppingCart.framework.api.APIResponse;
import br.com.shoppingCart.framework.controller.BaseController;
import br.com.shoppingCart.model.dto.ShoppingCartDTO;
/**
 * @author Marcelo Maluf Teixeira
 *
 */
@Controller
@RequestMapping("test")
public class ShoppingCartController extends BaseController {
	/*
	get /products
	Product Types (productsGet)
	The Products endpoint returns information about the *ShoppingCart* products.
	Return type
	
	array[Product]
	Produces
	
	This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
	application/json
	Responses
	
	200
	
	An array of products
	 */    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody APIResponse productsGet() {
        return APIResponse.toOkResponse(ShoppingCartDTO.productsGet());
    }
	
    /*
    get /shoppingcart
	Returns the current shopping cart for the session. (shoppingcartGet)
	Return type
	
	ShoppingCart
	Produces
	
	This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
	application/json
	Responses
	
	200
	
	The current shopping cart on the session.
     */
    @RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
    public @ResponseBody APIResponse shoppingcartGet() {
    	return APIResponse.toOkResponse(ShoppingCartDTO.getShoppingCart());
    }
    
    /*
    delete /shoppingcart/items/{id}
	Removes an commerce item from the shopping cart, by commerce item id. (shoppingcartItemsIdDelete)
	Path parameters
	
	id (required)
	Path Parameter —
	Produces
	
	This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
	application/json
	Responses
	
	200
	
	Empty resonse. Item was removed from the shopping cart.
     */    
    @RequestMapping(value = "/shoppingcart/items/{id}", method = RequestMethod.DELETE)
    public @ResponseBody APIResponse shoppingcartItemsIdDelete(@PathVariable("id") String commerceItem_id) {
        return APIResponse.toOkResponse(ShoppingCartDTO.shoppingcartItemsIdDelete(commerceItem_id));
    }
    
    /*
    post /shoppingcart/items
	Adds an item to the shopping cart. (shoppingcartItemsPost)
	Query parameters
	
	product_id (required)
	Query Parameter —
	quantity (required)
	Query Parameter —
	Return type
	
	CommerceItem
	Produces
	
	This API call produces the following media types according to the Accept request header; the media type will be conveyed by the Content-Type response header.
	application/json
	Responses
	
	200	
     */
    @RequestMapping(value = "/shoppingcart/items", method = RequestMethod.POST)
    public @ResponseBody APIResponse shoppingcartItemsPost( 
    		@RequestParam(value = "product_id", required = true) String product_id,    		
    	    @RequestParam(value = "quantity", required = true) int quantity) {
        return APIResponse.toOkResponse(ShoppingCartDTO.shoppingcartItemsPost(product_id, quantity));
    }
    
}
