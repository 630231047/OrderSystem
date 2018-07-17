package com.jisheng.po;

public class Food {
	private int id;
	private int store_id;
	private String name;
	private float price;
	private String uuidname;
	private String savepath;
	public String getUuidname() {
		return uuidname;
	}
	public void setUuidname(String uuidname) {
		this.uuidname = uuidname;
	}
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public Food() {
	}

	@Override
	public String toString() {
		return "Food{" +
				"id=" + id +
				", store_id=" + store_id +
				", name='" + name + '\'' +
				", price=" + price +
				", uuidname='" + uuidname + '\'' +
				", savepath='" + savepath + '\'' +
				'}';
	}

	public Food(int store_id, String name, float price, String uuidname, String savepath) {
		this.id = id;
		this.store_id = store_id;
		this.name = name;
		this.price = price;
		this.uuidname = uuidname;
		this.savepath = savepath;
	}
}
