package model;

public class Member {
	private int uid;
	private String id;
	private String pass;
	private String name;
	private String birth;
	private String gender;
	private String email;
	private String zipcode;
	private String zipcode1;
	private String zipcode2;
	private String zipcode3;
	private String zipcode4;
	private String level;
	private String sell_buy; //판매,구매
	private String none; // 휴먼, 일반, 탈퇴
	private int point; //포인트
	private String pro_manuname;// 제조사 명
	private String pro_salname;// 판매업체명
	private String date;
	private String phone;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSell_buy() {
		return sell_buy;
	}
	public void setSell_buy(String sell_buy) {
		this.sell_buy = sell_buy;
	}
	public String getNone() {
		return none;
	}
	public void setNone(String none) {
		this.none = none;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getPro_manuname() {
		return pro_manuname;
	}
	public void setPro_manuname(String pro_manuname) {
		this.pro_manuname = pro_manuname;
	}
	public String getPro_salname() {
		return pro_salname;
	}
	public void setPro_salname(String pro_salname) {
		this.pro_salname = pro_salname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Member [uid=" + uid + ", id=" + id + ", pass=" + pass + ", name=" + name + ", birth=" + birth
				+ ", gender=" + gender + ", email=" + email + ", zipcode=" + zipcode + ", zipcode1=" + zipcode1
				+ ", zipcode2=" + zipcode2 + ", zipcode3=" + zipcode3 + ", zipcode4=" + zipcode4 + ", level=" + level
				+ ", sell_buy=" + sell_buy + ", none=" + none + ", point=" + point + ", pro_manuname=" + pro_manuname
				+ ", pro_salname=" + pro_salname + ", date=" + date + ", phone=" + phone + "]";
	}
	
	
}
