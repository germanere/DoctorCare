package com.asm01.dto;

public class CreateUserDto {
	
	private String fullname;
	private String email;
	private int phone;
	private String address;
	private String username;
	private String password;
	private String role_name;
	
	public CreateUserDto(String fullname, String email, int phone, String address, String username, String password,
			String role_name) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.username = username;
		this.password = password;
		this.role_name = role_name;
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "CreateUserDto [fullname=" + fullname + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", username=" + username + ", password=" + password + ", role_name=" + role_name + "]";
	}


}
