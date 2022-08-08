package com.hotel.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.common.entity.User;

@Service
public class UserSercvice {

	@Autowired private UserRepository repo;
	
	public List<User> listAll() {
		return (List<User>) repo.findAll();
	}
}
