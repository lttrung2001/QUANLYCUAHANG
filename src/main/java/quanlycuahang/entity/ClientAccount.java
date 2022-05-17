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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CLIENT_ACCOUNT")
public class ClientAccount {
	@Id
	@Column(name = "USERNAME", nullable = false)
	private String username;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "POINT", nullable = false)
	private int point;
	@Column(name = "CREATE_AT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@OneToOne(mappedBy = "clientAccount")
	private Client clientInfo;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "accountInCart")
	private Set<Cart> products = new HashSet<Cart>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Client getClientInfo() {
		return clientInfo;
	}
	public void setClientInfo(Client clientInfo) {
		this.clientInfo = clientInfo;
	}
	public Set<Cart> getProducts() {
		return products;
	}
	public void setProducts(Set<Cart> products) {
		this.products = products;
	}
	public ClientAccount() {
		super();
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public ClientAccount(String username, String password, int point, Date createdDate, Client clientInfo,
			Set<Cart> products) {
		super();
		this.username = username;
		this.password = password;
		this.point = point;
		this.createdDate = createdDate;
		this.clientInfo = clientInfo;
		this.products = products;
	}	
}
