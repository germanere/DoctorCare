package com.asm01.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.asm01.config.ResourceNotFoundException;
import com.asm01.entity.Donation;
import com.asm01.repository.DonationRepository;

import jakarta.transaction.Transactional;

@Service
@Component(value = "donationService")
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;
   
    @Transactional
    public List < Donation > getDonate() {
        return donationRepository.findAll();
    }
    @Transactional
    public Donation getDonatebycode(String code) {
    	List <Donation> donations = donationRepository.findAll();
    	for(Donation donateDonation :donations) {
    		if(donateDonation.getCode().equalsIgnoreCase(code)) {
    			return donateDonation;
    		}
    	}
		return null;
    }
   
    @Transactional
    public void saveDonate(Donation thedonate) {
        donationRepository.save(thedonate);
    }

   
    @Transactional
    public Donation getDonate(int id) throws ResourceNotFoundException {
        return donationRepository.findById(id).orElseThrow(
            );
    }
    
    @Transactional
    public void deleteDonatate(int theId) {
		Optional<Donation> result = donationRepository.findById(theId);
		if (result.isPresent()) {
			Donation donation = result.get();
			if (donation.getStatus() == 0) {	// Nếu donation có trạng thái là mới tạo thì mới được xóa
				donationRepository.delete(donation);
				System.out.println("Delete donation (id = " + theId + ") successfully");
			}
		}
    }
    @Transactional
    public void updateDonate(int id,String code,String name,String dStart,String dEnd,String dOrg,int phone,String describe) {
    	Optional<Donation> result = donationRepository.findById(id);
    	if (result.isPresent()) {
    		Donation donate= result.get();
    		donate.setCode(code);
    		donate.setName(name);
    		donate.setdStart(dStart);
    		donate.setdEnd(dEnd);
    		donate.setdOrg(dOrg);
    		donate.setPhonenum(phone);
    		donate.setDdescribe(describe);
			donationRepository.save(donate);
			System.out.println("Update donation successfully");
    	}
    }
	
    @Transactional
	public void changeStatus(int donationId) {
		Optional<Donation> result= donationRepository.findById(donationId);
		if (result.isPresent()) {
			Donation donation = result.get();
			// Kiểm tra status của donation để set donation cho phù hợp
			switch (donation.getStatus()) {
				case 0: donation.setStatus(1);
						break;
				case 1: donation.setStatus(2);
						break;
				case 2: donation.setStatus(3);
						break;
			}
			donationRepository.save(donation);
			System.out.println("Change donation status successfully");
			
		}
	}

}
