package quanlycuahang.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID", nullable = false)
	private int id;
	@Column(name = "PRODUCT_NAME", nullable = false)
	private String name;
	@Column(name = "DESCRIPTION", nullable = true)
	private String desc;
	@Column(name = "PRICE", nullable = false)
	private double price;
	@Column(name = "IMAGE", nullable = false)
	private String image;
	@Column(name = "QTT_IN_STOCK", nullable = false)
	private int qttInStock;
	@Column(name = "INSERT_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertDate;
	@ManyToOne
	@JoinColumn(name = "PRODUCT_TYPE", nullable = false)
	private ProductType proType;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "productInBill")
	private List<BillDetail> inBill;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "productInCart")
	private List<Cart> inCart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQttInStock() {
		return qttInStock;
	}

	public void setQttInStock(int qttInStock) {
		this.qttInStock = qttInStock;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public ProductType getProType() {
		return proType;
	}

	public void setProType(ProductType proType) {
		this.proType = proType;
	}

	public List<BillDetail> getInBill() {
		return inBill;
	}

	public void setInBill(List<BillDetail> inBill) {
		this.inBill = inBill;
	}

	public List<Cart> getInCart() {
		return inCart;
	}

	public void setInCart(List<Cart> inCart) {
		this.inCart = inCart;
	}

	public Product(int id, String name, String desc, double price, String image, int qttInStock, Date insertDate,
			ProductType proType, List<BillDetail> inBill, List<Cart> inCart) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.image = image;
		this.qttInStock = qttInStock;
		this.insertDate = insertDate;
		this.proType = proType;
		this.inBill = inBill;
		this.inCart = inCart;
	}

	public Product() {
		super();
	}

}
