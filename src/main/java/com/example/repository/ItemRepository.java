package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Item;

/**
 * itemテーブルのリポジトリ.
 * 
 * @author nakanoryo
 *
 */
@Repository
public class ItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Item> ITEM_ROW_MAPPER = (rs, i) -> {
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setDescription(rs.getString("description"));
		item.setPriceM(rs.getInt("price_m"));
		item.setPriceL(rs.getInt("price_L"));
		item.setImagePath(rs.getString("image_path"));
		item.setDeleted(rs.getBoolean("deleted"));
		return item;
	};

	/**
	 * アイテムを価格の昇順で全て取得する.
	 * 
	 * @return itemリスト
	 */
	public List<Item> findAllOrderByPriceASC() {
		String sql = "SELECT id, name, description, price_m, price_l, image_path, deleted FROM items ORDER BY price_m";
		List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
		return itemList;
	}

	/**
	 * 文字列検索して価格の昇順で検索する.
	 * 
	 * @param searchName 検索文字列
	 * @return Itemリスト
	 */
	public List<Item> findByLikeNameOrderByPriceASC(String searchName) {
		String sql = "SELECT id, name, description, price_m, price_l, image_path, deleted FROM items WHERE name ILIKE :searchName ORDER BY price_m";
		SqlParameterSource param = new MapSqlParameterSource().addValue("searchName", "%" + searchName + "%");
		List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);
		return itemList;
	}
}
