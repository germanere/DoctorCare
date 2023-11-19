package com.asm01.dto;

public class userDtodonate {
	private String fullname;
	private int money;
	private String contain;
	private int idUser;
	private int idDonation;
	
	public userDtodonate(String fullname, int money, String contain) {
		super();
		this.fullname = fullname;
		this.money = money;
		this.contain = contain;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdDonation() {
		return idDonation;
	}

	public void setIdDonation(int idDonation) {
		this.idDonation = idDonation;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getContain() {
		return contain;
	}

	public void setContain(String contain) {
		this.contain = contain;
	}
	

}
