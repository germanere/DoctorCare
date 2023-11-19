package com.asm01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//@Entity(name="User_Donation")
@Entity
@Table(name = "user_donations")
public class User_Donation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "money")
    private int money;

    @Column(name = "name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "donation_id")
    private Donation donation;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String status = "Pending"; //Pending , APPROVE
  

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User_Donation(int id, int money, String name, Donation donation, User user, String status) {
		super();
		this.id = id;
		this.money = money;
		this.name = name;
		this.donation = donation;
		this.user = user;
		this.status = status;
	}

	public User_Donation() {

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
}
