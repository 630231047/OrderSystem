package com.jisheng.po;

public class Assess {
	private int id;
	private int mark;
	private String words;
	private String uuidname;
	private String savepath;
	private int store_id;
	private int customer_id;
	private String date;

	public Assess() {
	}

	@Override
	public String toString() {
		return "Assess{" +
				"id=" + id +
				", mark=" + mark +
				", words='" + words + '\'' +
				", uuidname='" + uuidname + '\'' +
				", savepath='" + savepath + '\'' +
				", store_id=" + store_id +
				", customer_id=" + customer_id +
				", date='" + date + '\'' +
				'}';
	}

	public Assess(int mark, String words, String uuidname, String savepath, int store_id, int customer_id, String date) {
		this.mark = mark;
		this.words = words;
		this.uuidname = uuidname;
		this.savepath = savepath;
		this.store_id = store_id;
		this.customer_id = customer_id;
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
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
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
