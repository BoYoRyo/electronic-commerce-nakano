package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ShowItemDetailService;

/**
 * 商品詳細画面に遷移する.
 * 
 * @author nakanoryo
 *
 */
@Controller
@RequestMapping("")
public class ShowItemDetailCotroller {
	@Autowired
	private ShowItemDetailService showItemDetailService;

	/**
	 * 詳細画面へ遷移.
	 * 
	 * @param id    id
	 * @param model model
	 * @return 詳細画面
	 */
	@GetMapping("/item-detail")
	public String showItemDetail(Integer id, Model model) {
		Item item = showItemDetailService.showItemDetail(id);
		model.addAttribute("item", item);
		return "item_detail";
	}
}
