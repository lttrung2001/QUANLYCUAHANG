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
	private String username;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "ROLE", nullable = false)
	private char role;
	
	@OneToOne
	@JoinColumn(name = "USERNAME", referencedColumnName = "STAFF_ID")
	private Staff staffInfo;
}
