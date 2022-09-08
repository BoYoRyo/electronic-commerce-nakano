package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

/**
 * usersテーブルのサービス機能を行うクラス.
 * 
 * @author nakanoryo
 *
 */
@Service
@Transactional
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
	
	/**
	 * メールアドレスが重複していないかチェック
	 * 
	 * @param email emailアドレス
	 * @return 重複していたらfalse/していなければtrue
	 */
	public Boolean isCheckEmail(String email) {
		if(userRepository.findByEmail(email) == null) {
			return true;
		} else {
			return false;
		}
	}
}
