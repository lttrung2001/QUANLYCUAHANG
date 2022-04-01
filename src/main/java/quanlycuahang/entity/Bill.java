package quanlycuahang.entity;

import java.time.LocalDate;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BILL")
public class Bill {
	@Id
	@Column(name = "BILL_ID", nullable = false)
	private int id;
	@Column(name = "CREATED_AT", nullable = false)
	private LocalDate createDate;
	@Column(name = "STATUS", nullable = false)
	private byte status;
	@Column(name = "DELIVER_ADDRESS", nullable = false)
	private String address;
	@ManyToOne
	@JoinColumn(name = "STAFF_ID", nullable = false)
	private Staff staffCreate;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
	Set<BillDetail> billDetails = new HashSet<BillDetail>();
}
