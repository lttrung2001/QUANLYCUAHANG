package quanlycuahang.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "STAFF")
public class Staff {
	@Id
	@Column(name = "STAFF_ID", nullable = false)
	private int id;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "SEX")
	private char sex;
	@Column(name = "DOB", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "PHONE_NUMBER", nullable = false)
	private String phoneNumber;
	@Column(name = "IS_WORKING", nullable = false)
	private char isWorking;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "staffCreate")
	@OrderBy
	private Set<Bill> createdBills = new HashSet<Bill>();
	@OneToOne(mappedBy = "staffInfo")
	private StaffAccount account;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public char getIsWorking() {
		return isWorking;
	}
	public void setIsWorking(char isWorking) {
		this.isWorking = isWorking;
	}
	public Set<Bill> getCreatedBills() {
		return createdBills;
	}
	public void setCreatedBills(Set<Bill> createdBills) {
		this.createdBills = createdBills;
	}
	public StaffAccount getAccount() {
		return account;
	}
	public void setAccount(StaffAccount account) {
		this.account = account;
	}
	public Staff(int id, String lastName, String firstName, char sex, Date dob, String email, String phoneNumber,
			char isWorking, Set<Bill> createdBills, StaffAccount account) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.sex = sex;
		this.dob = dob;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isWorking = isWorking;
		this.createdBills = createdBills;
		this.account = account;
	}
	public Staff() {
		super();
	}
	
}
