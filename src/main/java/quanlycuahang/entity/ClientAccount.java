package quanlycuahang.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT_ACCOUNT")
public class ClientAccount {
	@Id
	@Column(name = "ID", nullable = false)
	private int id;
	@Column(name = "USERNAME", nullable = false)
	private String username;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "POINT", nullable = false)
	private int point;
	@OneToOne(mappedBy = "clientAccount")
	private Client clientInfo;
	@OneToMany(mappedBy = "accountInCart")
	private Set<Cart> products = new HashSet<Cart>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public ClientAccount(int id, String username, String password, int point, Client clientInfo, Set<Cart> products) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.point = point;
		this.clientInfo = clientInfo;
		this.products = products;
	}
	public ClientAccount() {
		super();
	}
	
}
