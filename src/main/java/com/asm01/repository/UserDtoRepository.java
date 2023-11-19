package com.asm01.repository;

import com.asm01.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface UserDtoRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "select * from user u where u.fullname like :fullname", nativeQuery = true)
	Optional<User> findUserByName(@Param("fullname") String fullname);

}
