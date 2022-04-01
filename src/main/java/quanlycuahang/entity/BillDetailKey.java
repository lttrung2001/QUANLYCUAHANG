package quanlycuahang.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BillDetailKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "BILL_ID", nullable = false)
	private int billId;
	@Column(name = "PRODUCT_ID", nullable = false)
	private int productId;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public BillDetailKey(int billId, int productId) {
		super();
		this.billId = billId;
		this.productId = productId;
	}
	public BillDetailKey() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(billId, productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillDetailKey other = (BillDetailKey) obj;
		return billId == other.billId && productId == other.productId;
	}
}
