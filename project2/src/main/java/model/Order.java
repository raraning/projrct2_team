package model;

public class Order {

	private int uid;
	
	private String pay_ok; // 1:완료 2.배송 3:주문 4:취소	
	
	private String howpay; //무통장
	private String howpay_num; //계좌번호
	private String bank1; //은행
	private String bank1_get_name; //예금주 명
	private String bank1_give_name; //입금자
	
	private String cart_session; // 카트 세션정보
	
	private String get_name;
	private String get_phone;
	private String get_zipcode;
	private String get_zipcode1;
	private String get_zipcode2;
	private String get_zipcode3;
	private String get_zipcode4;
	
	private String id;
	private String name;
	private String email;
	private String phone;
	private String zipcode;
	private String zipcode1;
	private String zipcode2;
	private String zipcode3;
	private String zipcode4;
	private String message;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPay_ok() {
		return pay_ok;
	}
	public void setPay_ok(String pay_ok) {
		this.pay_ok = pay_ok;
	}
	public String getHowpay() {
		return howpay;
	}
	public void setHowpay(String howpay) {
		this.howpay = howpay;
	}
	public String getHowpay_num() {
		return howpay_num;
	}
	public void setHowpay_num(String howpay_num) {
		this.howpay_num = howpay_num;
	}
	public String getBank1() {
		return bank1;
	}
	public void setBank1(String bank1) {
		this.bank1 = bank1;
	}
	public String getBank1_get_name() {
		return bank1_get_name;
	}
	public void setBank1_get_name(String bank1_get_name) {
		this.bank1_get_name = bank1_get_name;
	}
	public String getBank1_give_name() {
		return bank1_give_name;
	}
	public void setBank1_give_name(String bank1_give_name) {
		this.bank1_give_name = bank1_give_name;
	}
	public String getCart_session() {
		return cart_session;
	}
	public void setCart_session(String cart_session) {
		this.cart_session = cart_session;
	}
	public String getGet_name() {
		return get_name;
	}
	public void setGet_name(String get_name) {
		this.get_name = get_name;
	}
	public String getGet_phone() {
		return get_phone;
	}
	public void setGet_phone(String get_phone) {
		this.get_phone = get_phone;
	}
	public String getGet_zipcode() {
		return get_zipcode;
	}
	public void setGet_zipcode(String get_zipcode) {
		this.get_zipcode = get_zipcode;
	}
	public String getGet_zipcode1() {
		return get_zipcode1;
	}
	public void setGet_zipcode1(String get_zipcode1) {
		this.get_zipcode1 = get_zipcode1;
	}
	public String getGet_zipcode2() {
		return get_zipcode2;
	}
	public void setGet_zipcode2(String get_zipcode2) {
		this.get_zipcode2 = get_zipcode2;
	}
	public String getGet_zipcode3() {
		return get_zipcode3;
	}
	public void setGet_zipcode3(String get_zipcode3) {
		this.get_zipcode3 = get_zipcode3;
	}
	public String getGet_zipcode4() {
		return get_zipcode4;
	}
	public void setGet_zipcode4(String get_zipcode4) {
		this.get_zipcode4 = get_zipcode4;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getZipcode1() {
		return zipcode1;
	}
	public void setZipcode1(String zipcode1) {
		this.zipcode1 = zipcode1;
	}
	public String getZipcode2() {
		return zipcode2;
	}
	public void setZipcode2(String zipcode2) {
		this.zipcode2 = zipcode2;
	}
	public String getZipcode3() {
		return zipcode3;
	}
	public void setZipcode3(String zipcode3) {
		this.zipcode3 = zipcode3;
	}
	public String getZipcode4() {
		return zipcode4;
	}
	public void setZipcode4(String zipcode4) {
		this.zipcode4 = zipcode4;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Order [uid=" + uid + ", pay_ok=" + pay_ok + ", howpay=" + howpay + ", howpay_num=" + howpay_num
				+ ", bank1=" + bank1 + ", bank1_get_name=" + bank1_get_name + ", bank1_give_name=" + bank1_give_name
				+ ", cart_session=" + cart_session + ", get_name=" + get_name + ", get_phone=" + get_phone
				+ ", get_zipcode=" + get_zipcode + ", get_zipcode1=" + get_zipcode1 + ", get_zipcode2=" + get_zipcode2
				+ ", get_zipcode3=" + get_zipcode3 + ", get_zipcode4=" + get_zipcode4 + ", id=" + id + ", name=" + name
				+ ", email=" + email + ", phone=" + phone + ", zipcode=" + zipcode + ", zipcode1=" + zipcode1
				+ ", zipcode2=" + zipcode2 + ", zipcode3=" + zipcode3 + ", zipcode4=" + zipcode4 + ", message="
				+ message + "]";
	}
	
	
	
}
