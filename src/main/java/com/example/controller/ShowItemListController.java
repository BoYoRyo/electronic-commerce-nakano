package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ShowItemListService;

/**
 * 商品一覧画面を表示する.
 * 
 * @author nakanoryo
 *
 */
@Controller
@RequestMapping("")
public class ShowItemListController {
	@Autowired
	private ShowItemListService showItemListService;

	/**
	 * 商品一覧画面を表示する.
	 * 
	 * @param model model
	 * @return 商品一覧画面へ遷移
	 */
	@GetMapping("")
	public String showItemList(Model model) {
		List<Item> itemList = showItemListService.showItemList();
		model.addAttribute("itemList", itemList);
		return "item_list";
	}
}
