package br.com.shoppingCart.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Marcelo Maluf Teixeira
 *
 */
public class ShoppingCart {
	
	private List<CommerceItem> items;
	private BigDecimal amount;
	
	public ShoppingCart() {
		items = new ArrayList<CommerceItem>();
	}

	public List<CommerceItem> getItems() {
		return items;
	}

	public void setItems(List<CommerceItem> items) {
		this.items = items;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}	
}