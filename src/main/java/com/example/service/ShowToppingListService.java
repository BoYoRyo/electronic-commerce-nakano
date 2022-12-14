package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Topping;
import com.example.repository.ToppingRepository;

/**
 * toppingを表示するサービスクラス.
 * 
 * @author nakanoryo
 *
 */
@Service
@Transactional
public class ShowToppingListService {
	@Autowired
	private ToppingRepository toppingRepository;

	/**
	 * Toppingを全件検索
	 * 
	 * @return toppingList
	 */
	public List<Topping> ShowAllTopping() {
		List<Topping> toppingList = toppingRepository.findAll();
		return toppingList;
	}
}
