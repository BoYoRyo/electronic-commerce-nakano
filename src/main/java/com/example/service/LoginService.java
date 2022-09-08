package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

/**
 * ログインを行うサービスクラス.
 * 
 * @author nakanoryo
 *
 */
@Service
@Transactional
public class LoginService {
	@Autowired
	private UserRepository userRepository;

	/**
	 * ログインする.
	 * 
	 * @param email    email
	 * @param password password
	 * @return user
	 */
	public User toLogin(String email, String password) {
		User user = new User();
		user = userRepository.findByEmailAndPassword(email, password);
		return user;
	}
}
