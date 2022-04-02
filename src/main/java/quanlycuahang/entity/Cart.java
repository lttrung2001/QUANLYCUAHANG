package quanlycuahang.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "CART")
public class Cart {
	@EmbeddedId
	private CartKey id;
	
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product productInCart;
	@ManyToOne
	@MapsId("accountId")
	@JoinColumn(name = "ACCOUNT_ID", nullable = false)
	private ClientAccount accountInCart;
	
	@Column(name = "AMOUNT_CART", nullable = false)
	private int amount;

	public CartKey getId() {
		return id;
	}

	public void setId(CartKey id) {
		this.id = id;
	}

	public Product getProductInCart() {
		return productInCart;
	}

	public void setProductInCart(Product productInCart) {
		this.productInCart = productInCart;
	}

	public ClientAccount getAccountInCart() {
		return accountInCart;
	}

	public void setAccountInCart(ClientAccount accountInCart) {
		this.accountInCart = accountInCart;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Cart(CartKey id, Product productInCart, ClientAccount accountInCart, int amount) {
		super();
		this.id = id;
		this.productInCart = productInCart;
		this.accountInCart = accountInCart;
		this.amount = amount;
	}

	public Cart() {
		super();
	}
	
}
