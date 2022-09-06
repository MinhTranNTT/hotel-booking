package com.hotel.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hotel.common.entity.Role;
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
	
	@GetMapping("/users/new")
	public String newUser(Model model) {
		List<Role> listRoles = userService.listRoles();
		
		User user = new User();
		user.setEnabled(true);
		
		model.addAttribute("user", user);
		model.addAttribute("listRoles", listRoles);
		model.addAttribute("pageTitle", "Create New User");
		
		return "user_form";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user, RedirectAttributes redirectAttributes) {
		System.out.println(user);
		user.setEnabled(true);
		userService.save(user);
		
		redirectAttributes.addFlashAttribute("message", "The user has been saved successfully.");
		
		return "redirect:/users";
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable("id") Integer id, Model model, RedirectAttributes redicRedirectAttributes) {
		
		try {
			User user = userService.get(id);
			List<Role> listRoles = userService.listRoles();
			
			model.addAttribute("user", user);
			model.addAttribute("listRoles", listRoles);
			model.addAttribute("pageTitle", "Edit User (ID: " + id + ")");
			
			return "user_form";
		} catch (UserNotFoundException ex) {
			redicRedirectAttributes.addFlashAttribute("message", ex.getMessage());
			return "redirect:/users";			
		}
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id")  Integer id, Model model, RedirectAttributes redirectAttributes) {
		try {
			userService.delete(id);
			redirectAttributes.addFlashAttribute("message", "The user ID " + id + " has been deleted successfully");
		} catch (UserNotFoundException ex) {
			redirectAttributes.addFlashAttribute("message", ex.getMessage());
		}
		return "redirect:/users";
	}
	
}
