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
}
