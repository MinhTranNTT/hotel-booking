package com.hotel.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.common.entity.Role;
import com.hotel.common.entity.User;

@Service
public class UserSercvice {

	@Autowired private UserRepository userRepo;
	
	@Autowired private RoleRepository roleRepo;
	
	//@Autowired private PasswordEncoder passwordEncoder;
	
	public List<User> listAll() {
		return (List<User>) userRepo.findAll();
	}
	
	public List<Role> listRoles() {
		return (List<Role>) roleRepo.findAll();
	}
	
	public void save(User user) {
		//encoderPassword(user);
		userRepo.save(user);
	}
	
//	public void encoderPassword(User user) {
//		String encoderPassword = passwordEncoder.encode(user.getPassword());
//		user.setPassword(encoderPassword);
//	}
	
	public boolean isEmailUnique(String email) {
		User userByEmail = userRepo.getUserByEmail(email);
		return userByEmail == null;
	}
}
