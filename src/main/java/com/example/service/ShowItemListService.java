package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

/**
 * 商品一覧画面を表示するサービスクラス.
 * 
 * @author nakanoryo
 *
 */
@Service
@Transactional
public class ShowItemListService {
	@Autowired
	private ItemRepository itemRepository;

	/**
	 * 商品一覧を取得する.
	 * 
	 * @return itemリスト
	 */
	public List<Item> showItemList() {
		List<Item> itemList = itemRepository.findAllOrderByPriceASC();
		return itemList;
	}
}
