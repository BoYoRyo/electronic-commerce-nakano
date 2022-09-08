package com.example.domain;

/**
 * orderitemのドメインクラス.
 * 
 * @author nakanoryo
 *
 */
public class OrderTopping {
	/** id */
	private Integer id;

	/** トッピングid */
	private Integer toppingId;

	/** オーダーアイテムid */
	private Integer orderItemId;

	/** トッピング */
	private Topping topping;

	@Override
	public String toString() {
		return "OrderTopping [id=" + id + ", toppingId=" + toppingId + ", orderItemId=" + orderItemId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getToppingId() {
		return toppingId;
	}

	public void setToppingId(Integer toppingId) {
		this.toppingId = toppingId;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Topping getTopping() {
		return topping;
	}

	public void setTopping(Topping topping) {
		this.topping = topping;
	}

}
