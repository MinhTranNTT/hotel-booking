package com.hotel.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.common.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
