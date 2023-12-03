package com.asm01.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.asm01.config.ResourceNotFoundException;
import com.asm01.dto.CreateUserDto;
import com.asm01.dto.UserDonationDto;
import com.asm01.entity.Donation;
import com.asm01.entity.Role;
import com.asm01.entity.User;
import com.asm01.entity.User_Donation;
import com.asm01.service.DonationService;
import com.asm01.service.RoleService;
import com.asm01.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userservice;
    
    @Autowired
    private DonationService donateservice;
    
    @Autowired
    private RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public String homePage(){
        return "admin/home";
    }

    @RequestMapping(value = "/donation",method = RequestMethod.GET)
    public String Donation(Model theModel){
    	List<Donation> donate = donateservice.getDonate();
        theModel.addAttribute("donations", donate);	
        return "admin/donation";
    }

    @GetMapping("/account")
    public String accountmanage(Model theModel){
        List < User > user = userservice.getUsers();
        theModel.addAttribute("users", user);     
        return "admin/account";
    }
    
    @GetMapping("/detail/{code}")
    public String detaildonate(@PathVariable String code, Model theModel) {
    	Donation donation = donateservice.getDonatebycode(code);
    	theModel.addAttribute("donation", donation);
    	
    	List<Donation> donate = donateservice.getDonate();
    	theModel.addAttribute("donations", donate);
    	return "admin/detail";
    }

    @PostMapping("/adduser")
    public String addnewuser(@ModelAttribute CreateUserDto dto){
    	User newUser = new User();	
    	newUser.setUsername(dto.getUsername());
    	newUser.setFullname(dto.getFullname());
    	newUser.setPhone(dto.getPhone());
    	newUser.setAddress(dto.getAddress());
    	newUser.setPassword(dto.getPassword());
    	newUser.setEmail(dto.getEmail());
    	Role roledao = roleService.getByRoleName(dto.getRole_name());
    	newUser.setRole(roledao);
    	userservice.saveUser(newUser);
        return "redirect:/admin/account";
    }
    
    @PostMapping("/lockuser")
    public String status(@RequestParam("idUser") String theid) {
    	String id = theid;
    	userservice.lockUser(Integer.parseInt(id));
    	return "redirect:/admin/account";
    }

    @PostMapping("/deleteuser")
    public String deluser(@RequestParam("idUser") String theId) {
    	String id = theId;
    	userservice.deleteUser(Integer.parseInt(id));
        return "redirect:/admin/account";
    }
    
    @PostMapping("/updateuser")
    public String upuser(@RequestParam("idUser") int theId,			
    		@RequestParam("fullName") String fullName,
    		@RequestParam("email") String email,
			@RequestParam("phone") String phone,
			@RequestParam("address") String address,
			@RequestParam("username") String username,
			@RequestParam("idRole") int roleid){

    	userservice.updateUser(theId, fullName, Integer.parseInt(phone), 
    			email, address, username, roleid);
    	return "redirect:/admin/account";
    }
    
    @PostMapping("/addonation")
    public String adddonation(@ModelAttribute UserDonationDto donationdto) {
    	Donation newD = new Donation();
    	newD.setCode(donationdto.getCode());
        newD.setName(donationdto.getName());
        newD.setdStart(donationdto.getdStart());
        newD.setdEnd(donationdto.getdEnd());
        newD.setdOrg(donationdto.getdOrg());
    	newD.setPhonenum(donationdto.getdPhone());
        newD.setDdescribe(donationdto.getdContain());
        User_Donation usD1= new User_Donation();
        usD1.setStatus("Created");
        donateservice.saveDonate(newD);
    	return "redirect:/admin/donation";
    }
    
    @PostMapping("/deldonate")
	public String deletedonate(@RequestParam("idUser")int theId) throws ResourceNotFoundException {
    	donateservice.deleteDonatate(theId);
    	return "redirect:/admin/donation";
    }
	@PostMapping("/change-status") 
	public String changeDonationStatus(@RequestParam("donationId") int donationId) {
		donateservice.changeStatus(donationId);
    	return "redirect:/admin/donation";
	}
    
    @PostMapping("/updonate")
    public String updatedonation(@RequestParam("donateid")int theID,
    		@RequestParam("code")String code,
    		@RequestParam("name")String name,
    		@RequestParam("start")String dStart,
    		@RequestParam("end")String dEnd,
    		@RequestParam("tochuc")String tochuc,
    		@RequestParam("sdt")int phone,
    		@RequestParam("noidung")String contain) {
    	donateservice.updateDonate(theID, code, name, dStart, dEnd, tochuc, phone, contain);
    		
    	return "redirect:/admin/donation";
    	}
			    
			    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model themodel){

        return "admin/login";
    }

    @RequestMapping("/logout")
    public String logout(){
        return 	"redirect:/admin/login";
    }
}
