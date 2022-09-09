package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ShowItemListService;
import com.example.service.ShowSearchItemListService;

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

	@Autowired
	private ShowSearchItemListService showSearchItemListService;

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
	
	@GetMapping("/search")
	public String searchItem(String searchName, Model model) {
		List<Item> itemList = showSearchItemListService.ShowSearchItemList(searchName);
		if(itemList.size() == 0 || searchName == "") {
			model.addAttribute("searchErrorMessage", "「" + searchName + "」に該当する商品がありませんでした。");
			return showItemList(model);
		}
		model.addAttribute("itemList", itemList);
		return "item_list";
	}
}
