package com.asm01.service;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.asm01.entity.User_Donation;
import com.asm01.repository.DonationuserRepository;

@Service
@Component(value = "userDonationService")
public class UserDonationService {

	@Autowired
	private DonationuserRepository userdonaterepository;
	
	@Transactional
	 public List < User_Donation > getUserDonate(){
		return userdonaterepository.findAll();
	}
	
    @Transactional
    public void saveUserDonate(User_Donation userD) {
       userdonaterepository.save(userD);
    }
	
	@Transactional
	public void deleteuserdonation(int theid) {
		userdonaterepository.deleteById(theid);;
	}
	
    @Transactional
    public User_Donation getUserDntById(int id) {
        return userdonaterepository.findAll().stream().filter(x -> x.getId()==id).findFirst().get();	
    }
}
