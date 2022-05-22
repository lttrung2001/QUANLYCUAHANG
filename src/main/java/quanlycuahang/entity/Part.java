package quanlycuahang.entity;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PART")
public class Part {
	@Id
	@Column(name = "PART_ID", nullable = false)
	private int id;
	@Column(name = "PART_NAME", nullable = false)
	private String name;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "part")
	private Set<ProductType> proTypeList = new HashSet<ProductType>();
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
	public Set<ProductType> getProTypeList() {
		return proTypeList;
	}
	public void setProTypeList(Set<ProductType> proTypeList) {
		this.proTypeList = proTypeList;
	}
	public Part(int id, String name, Set<ProductType> proTypeList) {
		super();
		this.id = id;
		this.name = name;
		this.proTypeList = proTypeList;
	}
	public Part() {
		super();
	}
	
}
