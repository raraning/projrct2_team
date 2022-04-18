package model;

public class Qna {
	
	private int uid;
	private String id;
	private String name;
	private String subject;
	private String comment;
	private String signdate;
	private int ref;
	private String gongji;
	private String file1;
	private String file1_o;
	private String file1_s;
	private int fid;
	private String thread;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public String getGongji() {
		return gongji;
	}
	public void setGongji(String gongji) {
		this.gongji = gongji;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public String getFile1_o() {
		return file1_o;
	}
	public void setFile1_o(String file1_o) {
		this.file1_o = file1_o;
	}
	public String getFile1_s() {
		return file1_s;
	}
	public void setFile1_s(String file1_s) {
		this.file1_s = file1_s;
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
		return "Qna [uid=" + uid + ", id=" + id + ", name=" + name + ", subject=" + subject + ", comment=" + comment
				+ ", signdate=" + signdate + ", ref=" + ref + ", gongji=" + gongji + ", file1=" + file1 + ", file1_o="
				+ file1_o + ", file1_s=" + file1_s + ", fid=" + fid + ", thread=" + thread + ", getUid()=" + getUid()
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getSubject()=" + getSubject()
				+ ", getComment()=" + getComment() + ", getSigndate()=" + getSigndate() + ", getRef()=" + getRef()
				+ ", getGongji()=" + getGongji() + ", getFile1()=" + getFile1() + ", getFile1_o()=" + getFile1_o()
				+ ", getFile1_s()=" + getFile1_s() + ", getFid()=" + getFid() + ", getThread()=" + getThread()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
