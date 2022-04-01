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
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "part")
	private Set<ProductType> proTypeList = new HashSet<ProductType>();
	
}
