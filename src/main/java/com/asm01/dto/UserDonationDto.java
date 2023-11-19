package com.asm01.dto;


public class UserDonationDto {	
	private String code;
	private String name;
	private String dStart;
	private String dEnd;
	private String dOrg;
	private int dPhone;
	private String dContain;
	


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getdStart() {
		return dStart;
	}
	public void setdStart(String dStart) {
		this.dStart = dStart;
	}
	public String getdEnd() {
		return dEnd;
	}
	public void setdEnd(String dEnd) {
		this.dEnd = dEnd;
	}
	public String getdOrg() {
		return dOrg;
	}
	public void setdOrg(String dOrg) {
		this.dOrg = dOrg;
	}
	public int getdPhone() {
		return dPhone;
	}
	public void setdPhone(int dPhone) {
		this.dPhone = dPhone;
	}
	public String getdContain() {
		return dContain;
	}
	public void setdContain(String dContain) {
		this.dContain = dContain;
	}


	public UserDonationDto(String code, String name, String dStart, String dEnd, String dOrg, int dPhone,
			String dContain) {
		super();
		this.code = code;
		this.name = name;
		this.dStart = dStart;
		this.dEnd = dEnd;
		this.dOrg = dOrg;
		this.dPhone = dPhone;
		this.dContain = dContain;
	}
	public UserDonationDto() {
		
	}
	@Override
	public String toString() {
		return "UserDonationDto [code=" + code + ", dName=" + name + ", dStart=" + dStart + ", dEnd=" + dEnd
				+ ", dOrg=" + dOrg + ", dPhone=" + dPhone + ", dContain=" + dContain + "]";
	}
	
	
}
