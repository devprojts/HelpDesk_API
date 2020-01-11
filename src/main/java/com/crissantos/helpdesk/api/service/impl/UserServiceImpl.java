package com.crissantos.helpdesk.api.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crissantos.helpdesk.api.entity.User;
import com.crissantos.helpdesk.api.repository.UserRepository;
import com.crissantos.helpdesk.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return this.userRepository.findByEmail(email);
	}

	@Override
	public User createdOrUpdate(User user) {
		// TODO Auto-generated method stub
		return this.userRepository.save(user);
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return this.userRepository.findOne(id);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		this.userRepository.delete(id);
	}

	@Override
	public Page<User> findAll(int page, int count) {
		// TODO Auto-generated method stub
		Pageable pages = new PageRequest(page, count);
		return this.userRepository.findAll(pages);
	}
}
