package quanlycuahang.bean;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Admin {
	@NotBlank(message = "Không để trống username")
	@NotEmpty(message = "Không để trống username")
	private String username;
	@NotBlank(message = "Không để trống password")
	@NotEmpty(message = "Không để trống password")
	private String password;
	private String fullname;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Admin(String username, String password, String fullname) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
