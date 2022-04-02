package quanlycuahang.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2417200321484659527L;
	@Column(name = "PRODUCT_ID", nullable = false)
	private int productId;
	@Column(name = "ACCOUNT_ID", nullable = false)
	private int accountId;
	@Column(name = "AMOUNT", nullable = false)
	private int amount;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public CartKey(int productId, int accountId, int amount) {
		super();
		this.productId = productId;
		this.accountId = accountId;
		this.amount = amount;
	}
	public CartKey() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountId, amount, productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartKey other = (CartKey) obj;
		return accountId == other.accountId && amount == other.amount && productId == other.productId;
	}
	
}
