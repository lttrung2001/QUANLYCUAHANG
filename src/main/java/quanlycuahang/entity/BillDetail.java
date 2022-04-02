package quanlycuahang.entity;

import javax.persistence.Table;




import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Table(name = "BILL_DETAIL")
public class BillDetail {
	@EmbeddedId
	private BillDetailKey id;
	
	@ManyToOne
	@MapsId("billId")
	@JoinColumn(name = "BILL_ID", nullable = false)
	private Bill bill;	
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product productInBill;
	
	@Column(name = "AMOUNT_BILL", nullable = false)
	private int amount;

	public BillDetailKey getId() {
		return id;
	}

	public void setId(BillDetailKey id) {
		this.id = id;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProductInBill() {
		return productInBill;
	}

	public void setProductInBill(Product productInBill) {
		this.productInBill = productInBill;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public BillDetail(BillDetailKey id, Bill bill, Product productInBill, int amount) {
		super();
		this.id = id;
		this.bill = bill;
		this.productInBill = productInBill;
		this.amount = amount;
	}

	public BillDetail() {
		super();
	}
	
}
