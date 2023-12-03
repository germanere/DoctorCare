package com.asm01.service;

import com.asm01.config.ResourceNotFoundException;
import com.asm01.entity.Role;
import com.asm01.entity.User;
import com.asm01.repository.UserDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Component(value = "userService")
public class UserService {
    @Autowired
    private UserDtoRepository userRepository;
    
    @Autowired
    private RoleService roleService;

    @Transactional
    public List < User > getUsers() {
        return userRepository.findAll();
    }

    
    @Transactional
    public void saveUser(User theuser) {
        userRepository.save(theuser);
    }

   
    @Transactional
    public User getUser(int id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(
            );
    }

    
    @Transactional
    public User getUserByFullName(String name) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findAll()
                .stream()
                .filter(x -> x.getFullname().equalsIgnoreCase(name))
                .findFirst();

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ResourceNotFoundException("User not found for name: " + name);
        }
    }
    
    @Transactional
    public void deleteUser(int theId) {
        userRepository.deleteById(theId);
    }
    
	@Transactional
	public void lockUser(int userId) {
		Optional<User> result = userRepository.findById(userId);
		if (result.isPresent()) {
			User user = result.get();
			
			int status = user.getStatus() == 0 ? 1 : 0;
			user.setStatus(status);
			
			userRepository.save(user);
		}
	}
	
	@Transactional
	public void updateUser(int userId, String fullName, int phoneNumber,String email, String address,String username,int roleId) {
		Optional<User> result = userRepository.findById(userId);
		if (result.isPresent()) {
			User user = result.get();
			user.setFullname(fullName);
			user.setEmail(email);
			user.setPhone(phoneNumber);
			user.setAddress(address);
			user.setUsername(username);	
			// Kiểm tra role có thay đổi không, nếu thay đổi thì update lại
			if (user.getRole().getId() != roleId) {
				Role role = roleService.getRole(roleId);
				user.setRole(role);
			}
			userRepository.save(user);
			System.out.println("Update user successfully");
		}
	}
}
