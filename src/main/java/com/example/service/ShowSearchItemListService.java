package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

/**
 * 文字列検索機能.
 * 
 * @author nakanoryo
 *
 */
@Service
@Transactional
public class ShowSearchItemListService {
	@Autowired
	private ItemRepository itemRepository;

	/**
	 * 文字列検索して価格の昇順で表示.
	 * 
	 * @param searchName 検索文字列
	 * @return itemリスト
	 */
	public List<Item> ShowSearchItemList(String searchName) {
		List<Item> itemList = itemRepository.findByLikeNameOrderByPriceASC(searchName);
		return itemList;
	}
}
