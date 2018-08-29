package com.quare.webapps.openidwebsite.dao.jpa;

import org.springframework.data.repository.Repository;

import com.quare.webapps.openidwebsite.entities.jpa.User;

public interface UserRepository extends Repository<User, Long> {

	public User findByEmail(String email);
	
}
