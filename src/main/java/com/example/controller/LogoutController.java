package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ログアウトする.
 * 
 * @author nakanoryo
 *
 */
@Controller
@RequestMapping()
public class LogoutController {
	@Autowired
	private HttpSession session;
	
	/**
	 * ユーザーのセッションを削除してログアウトする.
	 * 
	 * @return 商品一覧画面に遷移
	 */
	@GetMapping("/logout")
	public String toLogout() {
		session.removeAttribute("user");
		return "forward:/";
	}
}
