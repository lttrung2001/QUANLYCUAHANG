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
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType {
	@Id
	@Column(name = "PRO_TYPE_ID",nullable = false)
	private int proTypeId;
	@Column(name = "PRO_TYPE_NAME", nullable = false)
	private String proTypeName;
	@ManyToOne
	@JoinColumn(name = "PART_ID", nullable = false)
	private Part part;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proType")
	private Set<Product> list = new HashSet<Product>();
}
