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
}
