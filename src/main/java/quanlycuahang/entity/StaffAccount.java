package quanlycuahang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SHOP_ACCOUNT")
public class StaffAccount {
	@Id
	@Column(name = "USERNAME", nullable = false)
	private int username;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "ROLE", nullable = false)
	private char role;
	
	@OneToOne
	@JoinColumn(name = "USERNAME", referencedColumnName = "STAFF_ID")
	private Staff staffInfo;

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getRole() {
		return role;
	}

	public void setRole(char role) {
		this.role = role;
	}

	public Staff getStaffInfo() {
		return staffInfo;
	}

	public void setStaffInfo(Staff staffInfo) {
		this.staffInfo = staffInfo;
	}

	public StaffAccount(int username, String password, char role, Staff staffInfo) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.staffInfo = staffInfo;
	}

	public StaffAccount() {
		super();
	}
	
}
