package www.jisheng.po;

public class Storer {
	private int store_id;
	private int user_id;
	private String store_name;
	private String store_address;
	private float avg_mark;
	private String status;
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getStore_address() {
		return store_address;
	}
	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public float getAvg_mark() {
		return avg_mark;
	}
	public void setAvg_mark(float avg_mark) {
		this.avg_mark = avg_mark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
