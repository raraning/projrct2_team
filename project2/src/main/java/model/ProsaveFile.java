package model;

public class ProsaveFile {
	
	private int uid;
	private int pro_uid;
	private String pro_name;
	private String pro_id;
	private String id;
	private String cart_session;
	private int pro_price;
	private int pro_point;
	private int pro_count;
	private String file1;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPro_uid() {
		return pro_uid;
	}
	public void setPro_uid(int pro_uid) {
		this.pro_uid = pro_uid;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCart_session() {
		return cart_session;
	}
	public void setCart_session(String cart_session) {
		this.cart_session = cart_session;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public int getPro_point() {
		return pro_point;
	}
	public void setPro_point(int pro_point) {
		this.pro_point = pro_point;
	}
	public int getPro_count() {
		return pro_count;
	}
	public void setPro_count(int pro_count) {
		this.pro_count = pro_count;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	@Override
	public String toString() {
		return "ProsaveFile [uid=" + uid + ", pro_uid=" + pro_uid + ", pro_name=" + pro_name + ", pro_id=" + pro_id
				+ ", id=" + id + ", cart_session=" + cart_session + ", pro_price=" + pro_price + ", pro_point="
				+ pro_point + ", pro_count=" + pro_count + ", file1=" + file1 + "]";
	}
	
	
	

	
}
