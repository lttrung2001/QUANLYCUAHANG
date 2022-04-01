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
@Table(name = "PRODUCT")
public class Product {
	@Id
	@Column(name = "PRODUCT_ID", nullable = false)
	private int id;
	@Column(name = "PRODUCT_NAME", nullable = false)
	private String name;
	@Column(name = "DESCRIPTION", nullable = true)
	private String desc;
	@Column(name = "IMAGE", nullable = false)
	private String image;
	@Column(name = "QTT_IN_STOCK", nullable = false)
	private int qttInStock;
	// Cot ben duoi co the sai
	// Tim hieu convert DateTime SQL Server to LocalDate in Java
	@Column(name = "INSERT_DATE")
	private LocalDate insertDate;
	@ManyToOne
	@JoinColumn(name = "PRO_TYPE_ID", nullable = false)
	private ProductType proType;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productInBill")
	private Set<BillDetail> billDetails = new HashSet<BillDetail>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productInCart")
	private Set<Cart> cartList = new HashSet<Cart>();
}
