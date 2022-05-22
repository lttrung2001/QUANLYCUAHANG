package quanlycuahang.entity;

import java.util.Date;



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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BILL")
public class Bill {
	@Id
	@Column(name = "BILL_ID", nullable = false)
	private int id;
	@Column(name = "CREATE_AT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Column(name = "STATUS", nullable = false)
	private char status;
	@Column(name = "DELIVER_ADDRESS", nullable = false)
	private String address;
	@Column(name = "STAFF_CREATE")
	private String staffCreate;
	@ManyToOne
	@JoinColumn(name = "CUSTOMER")
	private ClientAccount customerAcc;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "bill")
	Set<BillDetail> billDetails = new HashSet<BillDetail>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStaffCreate() {
		return staffCreate;
	}
	public void setStaffCreate(String staffCreate) {
		this.staffCreate = staffCreate;
	}
	public ClientAccount getCustomerAcc() {
		return customerAcc;
	}
	public void setCustomerAcc(ClientAccount customerAcc) {
		this.customerAcc = customerAcc;
	}
	public Set<BillDetail> getBillDetails() {
		return billDetails;
	}
	public void setBillDetails(Set<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}
	public Bill(int id, Date createDate, char status, String address, String staffCreate, ClientAccount customerAcc,
			Set<BillDetail> billDetails) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.status = status;
		this.address = address;
		this.staffCreate = staffCreate;
		this.customerAcc = customerAcc;
		this.billDetails = billDetails;
	}
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
