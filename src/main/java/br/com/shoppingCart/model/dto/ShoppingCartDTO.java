package br.com.shoppingCart.model.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.shoppingCart.model.entity.CommerceItem;
import br.com.shoppingCart.model.entity.Product;
import br.com.shoppingCart.model.entity.ShoppingCart;
/**
 * @author Marcelo Maluf Teixeira
 *
 */
public class ShoppingCartDTO {

	private static ShoppingCart shoppingCart = new ShoppingCart();
	//#TODO CORRIGIR O CONTADOR QUANDO O TOMCAT É REINICIADO. Atualizar a lista com base o que está nos cookies.
	
	private static Integer commerce_id;

	public static Integer getCommerce_id() {		
		return commerce_id;
	}
	
	public static Integer addCommerce_id() {
		commerce_id = ++commerce_id;
		return commerce_id;
	}
	
	public static ShoppingCart getShoppingCart() {
		return shoppingCart;
	}	

	public static List<Product> productsGet () {
		return getShowCase();
	}

	public static String shoppingcartItemsIdDelete(String commerceItem_id_){	

		System.out.println("commerceItem_id_: " +commerceItem_id_);
		for (int x = 0; x < shoppingCart.getItems().size(); x++ ) {
			CommerceItem commerceItem = shoppingCart.getItems().get(x);
			System.out.println("commerceItem.getId(): " +commerceItem.getId());

			if (  commerceItem.getId().equals(commerceItem_id_) ) {
				shoppingCart.getItems().remove(x);
				return "Item was removed from the cart.";
			}
		}		
		return "Could not remove item from the Cart.";
	}
	
	public static List<Product> getShowCase() {
		Product iphone7 = new Product("1", "Apple iPhone 7 Unlocked Phone 32 GB - US Version (Silver)", "images/iphone7.jpg", BigDecimal.valueOf(809.30) );
		Product iphone6 = new Product("2", "Apple iPhone 6 16GB Silver LTE Cellular International Unlocked", "images/iphone6.jpg", BigDecimal.valueOf(649.00) );
		Product s7 = new Product("3", "Samsung Galaxy S7 Factory Unlocked Phone 32 GB", "images/s7.jpg", BigDecimal.valueOf(540.99) );
		Product s6 = new Product("4", "Samsung Galaxy S6 G920F 32GB Factory Unlocked 5.1 HD", "images/s6.jpg", BigDecimal.valueOf(405.97) );
		Product z5= new Product("5", "Sony Xperia Z5 Premium E6853 5.5-Inch 4K UHD Display", "images/xperia-z5.jpg", BigDecimal.valueOf(539.99) );
		List<Product> showCase = new ArrayList<Product>();
		showCase.add(iphone7);
		showCase.add(iphone6);
		showCase.add(s7);
		showCase.add(s6);
		showCase.add(z5);
		return showCase;
	}

	public static CommerceItem shoppingcartItemsPost(String product_id, Integer quantity) {
		for (Product product : getShowCase() ) {
			if (product.getId().equals(product_id)) {
				CommerceItem commerceItem = new CommerceItem(Integer.valueOf(quantity), product);
				shoppingCart.getItems().add(commerceItem);
				return commerceItem;
			}
		}
		return null;
	}
	
	public static class CommerceIdStarter {
		public static void start() {
			ShoppingCartDTO.commerce_id = 0;
		}
		
	}
}