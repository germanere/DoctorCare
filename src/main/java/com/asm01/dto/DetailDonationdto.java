package com.asm01.dto;

public class DetailDonationdto {
	private String name;
	private int money;
	private String donateDate;
	private String contain;
	
	public DetailDonationdto(String name, int money, String donateDate, String contain) {
		super();
		this.name = name;
		this.money = money;
		this.donateDate = donateDate;
		this.contain = contain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getDonateDate() {
		return donateDate;
	}

	public void setDonateDate(String donateDate) {
		this.donateDate = donateDate;
	}

	public String getContain() {
		return contain;
	}

	public void setContain(String contain) {
		this.contain = contain;
	}
	
	
}
