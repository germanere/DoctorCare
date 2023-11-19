package com.asm01.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.asm01.entity.Role;
import com.asm01.repository.RoleRepository;

@Service
@Component(value = "roleService")
public class RoleService {
	@Autowired
	private  RoleRepository repository;
	
	 public Role getByRoleName(String roleName) {
		List<Role> roles = repository.findAll();
	        for (Role role : roles) {
	            if (role.getRole_name().equalsIgnoreCase(roleName)) {
	                return role;
	            }
	        }
	        return null;
	    }

	public Role getRole(int roleId) {
		List<Role> roles = repository.findAll();
        for (Role role : roles) {
        	if(role.getId()==roleId)
        		return role;
        }
		return null;
	}

}
