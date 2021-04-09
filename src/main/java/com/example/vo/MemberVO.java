package com.example.vo;

public class MemberVO {
	private String id = null;			//회원ID
	private String pw = null;			//비밀번호
	private String univ_name = null;	//대학교명
	private String dept_name = null;	//학과명
	private String stu_name = null;		//학생명
	private String stu_num = null;		//학번
	private String stu_grd = null;		//학년
	private String auth = "STUDENT";	//권한
	
	//기본 생성자
	public MemberVO() {
		super();
	}
	
	//변수 생성자
	public MemberVO(String id, String pw, String univ_name, String dept_name, String stu_name, String stu_num,
			String stu_grd, String auth) {
		super();
		this.id = id;
		this.pw = pw;
		this.univ_name = univ_name;
		this.dept_name = dept_name;
		this.stu_name = stu_name;
		this.stu_num = stu_num;
		this.stu_grd = stu_grd;
		this.auth = auth;
	}
	
	//getter, setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUniv_name() {
		return univ_name;
	}
	public void setUniv_name(String univ_name) {
		this.univ_name = univ_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_num() {
		return stu_num;
	}
	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}
	public String getStu_grd() {
		return stu_grd;
	}
	public void setStu_grd(String stu_grd) {
		this.stu_grd = stu_grd;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", univ_name=" + univ_name + ", dept_name=" + dept_name
				+ ", stu_name=" + stu_name + ", stu_num=" + stu_num + ", stu_grd=" + stu_grd + ", auth=" + auth + "]";
	}
	
}
