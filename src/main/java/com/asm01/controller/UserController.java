package com.asm01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.asm01.config.ResourceNotFoundException;
import com.asm01.dto.userDtodonate;
import com.asm01.entity.Donation;
import com.asm01.entity.User_Donation;
import com.asm01.service.DonationService;
import com.asm01.service.UserDonationService;
import com.asm01.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserDonationService userdonates;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DonationService donationService;
	
	@Autowired
	private UserDonationService userDonationService;
	
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String homePage(Model model){
    	List<User_Donation> userdonations = userDonationService.getUserDonate();
    	model.addAttribute("user_donationss",userdonations);
	    List<Donation> donations = donationService.getDonate();
	    model.addAttribute("donations", donations);
	    return "public/home";

    }
    
    @PostMapping("/adduserdonation")
    public String adduserDonate(@ModelAttribute userDtodonate userdonatedto, Model model ) throws ResourceNotFoundException {
    	User_Donation userdonate = new User_Donation();
    	userdonate.setName(userdonatedto.getFullname());
    	userdonate.setMoney(userdonatedto.getMoney());
    	userdonate.setStatus("Pending");
    	userdonate.setDonation(donationService.getDonate(userdonatedto.getIdDonation()));
    	userdonate.setUser(userService.getUserByFullName(userdonatedto.getFullname()));
    	System.out.println(userdonate.toString());
    	userdonates.saveUserDonate(userdonate);
    	List<Donation> donations = donationService.getDonate();
    	model.addAttribute("donations", donations);
        return "public/home";
    }
    
    @GetMapping("/Detail/{code}")
    public String processForm(@PathVariable String code,Model theModel){
    	Donation donation = donationService.getDonatebycode(code);
    	theModel.addAttribute("donation", donation);
	    List<Donation> donations = donationService.getDonate();
	    theModel.addAttribute("donations", donations);
	    List<User_Donation> userDonationAll = userDonationService.getUserDonate();
	    int total = 0;
	    for (User_Donation user_Donation : userDonationAll) {
	    	if (user_Donation.getDonation().getId() == donation.getId()) {
	    		total += user_Donation.getMoney();
	    	}
	    }

	    theModel.addAttribute("sumMoney", total);
        return "public/detail";
    }

}
