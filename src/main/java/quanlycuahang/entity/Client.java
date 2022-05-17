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
	private String id;
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
	@JoinColumn(name = "CLIENT_ID", referencedColumnName = "USERNAME")
	private ClientAccount clientAccount;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ClientAccount getClientAccount() {
		return clientAccount;
	}

	public void setClientAccount(ClientAccount clientAccount) {
		this.clientAccount = clientAccount;
	}

	public Client(String id, String lastName, String firstName, String address, String phoneNumber, String email,
			ClientAccount clientAccount) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.clientAccount = clientAccount;
	}

	public Client() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
