package quanlycuahang.entity;

import java.io.Serializable;

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
	private String accountId;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public CartKey(int productId, String accountId) {
		super();
		this.productId = productId;
		this.accountId = accountId;
	}
	public CartKey() {
		super();
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
