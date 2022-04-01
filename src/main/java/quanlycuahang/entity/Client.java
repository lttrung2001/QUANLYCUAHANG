package quanlycuahang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {
	@Id
	@Column(name = "CLIENT_ID", nullable = false)
	private int id;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	@Column(name = "PHONE_NUMBER", nullable = false)
	private String phoneNumber;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@OneToOne
	@JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
	private ClientAccount clientAccount;
}
