package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.User;
import com.example.repository.UserRepository;

/**
 * usersテーブルのサービス機能を行うクラス.
 * 
 * @author nakanoryo
 *
 */
public class UserRegistrationService {
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 新規ユーザー登録を行う.
	 * 
	 * @param user user
	 */
	public void userRegistration(User user) {
		userRepository.insertUser(user);
	}
}
