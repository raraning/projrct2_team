package model;

public class ProductQna {
	private int uid;
	private int pro_uid;
	private String id;
	private String name;
	private String comment;
	private String signdate;
	private String qna;
	private int fid;
	private String thread;
	
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getSigndate() {
		return signdate;
	}
	public void setSigndate(String signdate) {
		this.signdate = signdate;
	}
	public String getQna() {
		return qna;
	}
	public void setQna(String qna) {
		this.qna = qna;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getThread() {
		return thread;
	}
	public void setThread(String thread) {
		this.thread = thread;
	}
	
	@Override
	public String toString() {
		return "ProductQna [uid=" + uid + ", pro_uid=" + pro_uid + ", id=" + id + ", name=" + name + ", comment="
				+ comment + ", signdate=" + signdate + ", qna=" + qna + ", fid=" + fid + ", thread=" + thread + "]";
	}
	
	
}
