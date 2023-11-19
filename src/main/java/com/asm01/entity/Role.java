package com.asm01.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="Role")
@Table(name = "roles")
public class Role {
    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="role_name")
    private String role_name;
    
    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private List<User> users ;
    
    public Role(int id,String role_name){
        this.id=id;
        this.role_name=role_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_name() {
        return role_name;
    }
    
    public Role() {

	}

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + 
                '}';
    }
}
