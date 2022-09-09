package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.domain.Topping;
import com.example.service.ShowItemDetailService;
import com.example.service.ShowToppingListService;

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
	
	@Autowired
	private ShowToppingListService showToppingListService;

	/**
	 * 詳細画面へ遷移.
	 * 
	 * @param id    id
	 * @param model model
	 * @return 詳細画面
	 */
	@GetMapping("/item-detail")
	public String showItemDetail(Integer id, Model model) {
		
		//リンクの商品を検索
		Item item = showItemDetailService.showItemDetail(id);
		model.addAttribute("item", item);
		
		//Toppingリストの取得
		List<Topping> toppingList = showToppingListService.ShowAllTopping();
		model.addAttribute("toppingList", toppingList);
		
		return "item_detail";
	}
}
