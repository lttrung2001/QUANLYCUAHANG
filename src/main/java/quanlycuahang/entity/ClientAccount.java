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
}
