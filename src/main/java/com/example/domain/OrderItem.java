package com.example.domain;

import java.util.List;

/**
 * orderitemのドメインクラス.
 * 
 * @author nakanoryo
 *
 */
public class OrderItem {
	/** id */
	private Integer id;

	/** アイテムid */
	private Integer itemId;

	/** オーダーid */
	private Integer orderId;

	/** 数量 */
	private Integer quantity;

	/** サイズ */
	private String size;

	/** 商品 */
	private Item item;

	/** オーダートッピングリスト */
	private List<OrderTopping> orderToppingList;

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", itemId=" + itemId + ", orderId=" + orderId + ", quantity=" + quantity
				+ ", size=" + size + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<OrderTopping> getOrderToppingList() {
		return orderToppingList;
	}

	public void setOrderToppingList(List<OrderTopping> orderToppingList) {
		this.orderToppingList = orderToppingList;
	}

}
