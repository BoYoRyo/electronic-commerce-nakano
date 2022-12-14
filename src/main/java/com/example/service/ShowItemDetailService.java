package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

/**
 * 商品詳細画面を表示する.
 * 
 * @author nakanoryo
 *
 */
@Service
@Transactional
public class ShowItemDetailService {
	@Autowired
	private ItemRepository itemRepository;

	/**
	 * 商品詳細画面を表示する.
	 * 
	 * @param id id
	 * @return item
	 */
	public Item showItemDetail(Integer id) {
		Item item = itemRepository.findById(id);
		return item;
	}
}
