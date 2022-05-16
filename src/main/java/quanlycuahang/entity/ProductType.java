package quanlycuahang.entity;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType {
	@Id
	@Column(name = "PRO_TYPE_ID",nullable = false)
	private int proTypeId;
	@Column(name = "PRO_TYPE_NAME", nullable = false)
	private String proTypeName;
	@ManyToOne
	@JoinColumn(name = "PART", nullable = false)
	private Part part;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "proType")
	private Set<Product> list = new HashSet<Product>();
	public int getProTypeId() {
		return proTypeId;
	}
	public void setProTypeId(int proTypeId) {
		this.proTypeId = proTypeId;
	}
	public String getProTypeName() {
		return proTypeName;
	}
	public void setProTypeName(String proTypeName) {
		this.proTypeName = proTypeName;
	}
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	public Set<Product> getList() {
		return list;
	}
	public void setList(Set<Product> list) {
		this.list = list;
	}
	public ProductType(int proTypeId, String proTypeName, Part part, Set<Product> list) {
		super();
		this.proTypeId = proTypeId;
		this.proTypeName = proTypeName;
		this.part = part;
		this.list = list;
	}
	public ProductType() {
		super();
	}
}
