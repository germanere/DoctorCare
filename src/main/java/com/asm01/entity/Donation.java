package com.asm01.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity(name="Donation")
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="code")
    private String code;

    @Column(name="money")
    private int money;

    @Column(name="phonenum")
    private int phonenum;

    @Column(name="name")
    private String name;
 
    private int status = 0; //0: CREATED,1: PROCESSING,2: END,3: CLOSED
    
    @Column(name="dstart")
    private String dStart;
    
    @Column(name="dend")
    private String dEnd;
    
    @Column(name="dorg")
    private String dOrg;
    
    @Column(name="ddescribe")
    private String ddescribe;

    public String getDdescribe() {
		return ddescribe;
	}

	public void setDdescribe(String ddescribe) {
		this.ddescribe = ddescribe;
	}
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "donation",cascade = CascadeType.ALL, orphanRemoval = true)
    private List <User_Donation> userDonations;

    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getPhonenum() {
        return phonenum;
    }

    public List<User_Donation> getUserDonations() {
        return userDonations;
    }

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setMoney(int money) {
        this.money = money;
    }
    public void setPhonenum(int phonenum) {
        this.phonenum = phonenum;
    }

    public void setUserDonations(List<User_Donation> userDonations) {
        this.userDonations = userDonations;
    }

	public String getdStart() {
		return dStart;
	}

	public String getdOrg() {
		return dOrg;
	}

	public void setdOrg(String dOrg) {
		this.dOrg = dOrg;
	}


	public String getdEnd() {
		return dEnd;
	}

	public void setdEnd(String dEnd) {
		this.dEnd = dEnd;
	}

	public void setdStart(String dStart) {
		this.dStart = dStart;
	}

	public Donation(int id, String code, int money, int phonenum, String name, int status, String dStart,
			String dEnd, String dOrg, String ddescribe, List<User_Donation> userDonations) {
		super();
		this.id = id;
		this.code = code;
		this.money = money;
		this.phonenum = phonenum;
		this.name = name;
		this.status = status;
		this.dStart = dStart;
		this.dEnd = dEnd;
		this.dOrg = dOrg;
		this.ddescribe = ddescribe;
		this.userDonations = userDonations;
	}

	public Donation() {

	}

	@Override
	public String toString() {
		return "Donation [id=" + id + ", code=" + code + ", money=" + money + ", phonenum=" + phonenum + ", name="
				+ name + ", status=" + status + ", dStart=" + dStart + ", dEnd=" + dEnd + ", dOrg=" + dOrg
				+ ", ddescribe=" + ddescribe + ", userDonations=" + userDonations + "]";
	}


}
