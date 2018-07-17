package com.jisheng.po;

public class Order {
	private int id;
	private int customer_id;
	private int food_id;
	private String status;
	private int num;
	private int store_id;
	private String date;

	public Order(int customer_id, int food_id, String status, int num, int store_id, String date) {
		this.customer_id = customer_id;
		this.food_id = food_id;
		this.status = status;
		this.num = num;
		this.store_id = store_id;
		this.date = date;
	}

	public Order() {
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", customer_id=" + customer_id +
				", food_id=" + food_id +
				", status='" + status + '\'' +
				", num=" + num +
				", store_id=" + store_id +
				", date='" + date + '\'' +
				'}';
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
