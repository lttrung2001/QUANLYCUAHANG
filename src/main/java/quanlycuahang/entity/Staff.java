package quanlycuahang.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STAFF")
public class Staff {
	@Id
	@Column(name = "STAFF_ID", nullable = false)
	private int id;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "SEX")
	private char sex;
	@Column(name = "DOB", nullable = false)
	private LocalDate dob;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "PHONE_NUMBER", nullable = false)
	private String phoneNumber;
	@Column(name = "IS_WORKING", nullable = false)
	private char isWorking;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staffCreate")
	private Set<Bill> billList = new HashSet<Bill>();
	@OneToOne(mappedBy = "staffInfo")
	private StaffAccount account;
}
