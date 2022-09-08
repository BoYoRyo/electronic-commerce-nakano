package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserRegistrationForm;
import com.example.service.UserRegistrationService;

/**
 * ユーザー登録を行うコントローラークラス.
 * 
 * @author nakanoryo
 *
 */
@Controller
@RequestMapping()
public class UserRegistrationController {
	@Autowired
	private UserRegistrationService userRegistrationService;

	/**
	 * ユーザー登録をしてログイン画面へ遷移する.
	 * 
	 * @param form ユーザー情報のフォーム
	 * @return ログイン画面へリダイレクト
	 */
	@PostMapping("/regist-user")
	public String userRegister(@Validated UserRegistrationForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return toRegist(form);
		}
		User user = new User();
		BeanUtils.copyProperties(form, user);
		String name = form.getFamilyName() + form.getFirstName();
		user.setName(name);
		userRegistrationService.userRegistration(user);
		return "redirect:/toLogin";
	}

	/**
	 * ユーザー登録画面に遷移.
	 * 
	 * @return ユーザー登録画面
	 */
	@GetMapping("/regist")
	public String toRegist(UserRegistrationForm form) {
		return "register_user";
	}

}
