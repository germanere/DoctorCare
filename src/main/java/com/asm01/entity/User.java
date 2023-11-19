package com.asm01.entity;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "fullname")
    private String fullname;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private int phone;

    @NonNull
    @Column(name = "username")
    private String username;
    
    @Nonnull
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

   
    private int status;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<User_Donation> userDonations;


    public User(String fullname,String email,int phone,String address,String user_name,String password,Role role,int status){
        this.fullname= fullname;
        this.email =email;
        this.phone = phone;
        this.address = address;
        this.username = user_name;
        this.password = password;
        this.role=role;
        this.status=status;
    }
    
    public User() {

	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user_name) {
        this.username = user_name;
    }


    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<User_Donation> getUserDonations() {
        return userDonations;
    }

    public void setUserDonations(List<User_Donation> userDonations) {
        this.userDonations = userDonations;
    }

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", address=" + address + ", email=" + email + ", phone="
				+ phone + ", username=" + username + ", password=" + password + ", role=" + role + ", status=" + status
				+ ", userDonations=" + userDonations + "]";
	}
    
    

}

