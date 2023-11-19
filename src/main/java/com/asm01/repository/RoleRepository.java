package com.asm01.repository;

import com.asm01.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("RoleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
}
