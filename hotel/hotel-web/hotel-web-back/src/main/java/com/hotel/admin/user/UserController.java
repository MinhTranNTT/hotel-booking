package com.hotel.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.common.entity.User;

@Controller
public class UserController {

	@Autowired private UserSercvice userService;
	
	@GetMapping("/users")
	public String listAll(Model model) {
		List<User> listUser = userService.listAll();
		model.addAttribute("listUser", listUser);
		
		return "users";
	}
}
