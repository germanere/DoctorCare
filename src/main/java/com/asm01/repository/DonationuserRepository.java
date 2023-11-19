package com.asm01.repository;

import com.asm01.entity.User_Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationuserRepository extends JpaRepository<User_Donation, Integer> {
}
