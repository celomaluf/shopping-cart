package br.com.shoppingCart.model.entity;

import java.math.BigDecimal;

import br.com.shoppingCart.model.dto.ShoppingCartDTO;
/**
 * @author Marcelo Maluf Teixeira
 *
 */
public class CommerceItem {
	
	private String id;
	private String product_id;
	private Integer quantity;
	private BigDecimal amount;
	private Product product;
	
	public CommerceItem() {
		
	}
	
	public CommerceItem(Integer quantity, Product product) {
		if (ShoppingCartDTO.getCommerce_id() == null ) {
			ShoppingCartDTO.CommerceIdStarter.start();
		}
		
		setId(String.valueOf(ShoppingCartDTO.addCommerce_id()));
		setProduct_id(product.getId());
		setQuantity(quantity);
		setAmount(BigDecimal.valueOf(quantity).multiply(product.getPrice()));
		setProduct(product);
	}	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}	
	
	@Override
	
    public String toString() {
        return "CommerceItem{" +
                "id='" + id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", quantity=" + quantity + '\'' +
                ", amount=" + amount + '\'' +
                ", product{" + product.toString() +'}' + '\'' +
                '}';
    }
}