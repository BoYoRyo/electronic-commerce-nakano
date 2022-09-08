package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserRegistrationForm;
import com.example.service.UserRegistrationService;

@Controller
@RequestMapping()
public class UserRegistrationController {
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@PostMapping("/Regist")
	public String userRegister(UserRegistrationForm form) {
		User user = new User();
		BeanUtils.copyProperties(form, user);
		String name = form.getFamilyName() + form.getFirstName();
		user.setName(name);
		userRegistrationService.userRegistration(user);
		return "redirect:/toLogin";
	}
	
}
