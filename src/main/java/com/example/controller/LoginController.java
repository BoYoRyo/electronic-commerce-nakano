package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.LoginForm;
import com.example.service.LoginService;

/**
 * ログインコントローラークラス.
 * 
 * @author nakanoryo
 *
 */
@Controller
@RequestMapping("")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private HttpSession httpSession;
	
	/**
	 * ログイン画面に遷移.
	 * 
	 * @return ログイン画面
	 */
	@GetMapping("/toLogin")
	public String toLogin(LoginForm form) {
		return "login";
	}
	
	/**
	 * ログイン処理.
	 * 
	 * @param form form
	 * @param model model
	 * @return 商品一覧画面へ遷移
	 */
	@PostMapping("/login")
	public String login(LoginForm form, Model model) {
		User user = loginService.toLogin(form.getEmail(), form.getPassword());
		if( user == null) {
			model.addAttribute("loginErrorMessage", "メールアドレス、またはパスワードが間違っています");
			return toLogin(form);
		}
		httpSession.setAttribute("user", user);
		return "forward:/";
	}
}
