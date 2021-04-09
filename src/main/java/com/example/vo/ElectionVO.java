package com.example.vo;

import java.util.Arrays;

public class ElectionVO {
	private String univ_name = null;		//대학교명
	private String election_name = null;	//선거이름
	private String election_winner = null;	//당선자명
	private int count_candidate = 0;		//등록한 후보자수
	private String status = "prepare";		//선거상태
	//후보자1의 정보
	private String hbj1_name = null;		//후보자1 이름
	private String hbj1_gender = null;		//후보자1 성별
	private String hbj1_grade = null;		//후보자1 학년
	private byte[] hbj1_pic = null;			//후보자1 사진
	private String hbj1_num = null;				//후보자1 기호
	private String hbj1_prom1 = null;		//후보자1 공약1
	private String hbj1_prom2 = null;		//후보자1 공약2
	private String hbj1_prom3 = null;		//후보자1 공약3
	private int hbj1_vote = 0;				//후보자1 득표수
	//후보자2의 정보
	private String hbj2_name = null;		//후보자2 이름
	private String hbj2_gender = null;		//후보자2 성별
	private String hbj2_grade = null;		//후보자2 학년
	private byte[] hbj2_pic = null;			//후보자2 사진
	private String hbj2_num = null;				//후보자2 기호
	private String hbj2_prom1 = null;		//후보자2 공약1
	private String hbj2_prom2 = null;		//후보자2 공약2
	private String hbj2_prom3 = null;		//후보자2 공약3
	private int hbj2_vote = 0;				//후보자2 득표수
	//후보자3의 정보
	private String hbj3_name = null;		//후보자3 이름
	private String hbj3_gender = null;		//후보자3 성별
	private String hbj3_grade = null;		//후보자3 학년
	private byte[] hbj3_pic = null;			//후보자3 사진
	private String hbj3_num = null;				//후보자3 기호
	private String hbj3_prom1 = null;		//후보자3 공약1
	private String hbj3_prom2 = null;		//후보자3 공약2
	private String hbj3_prom3 = null;		//후보자3 공약3
	private int hbj3_vote = 0;				//후보자3 득표수
	
	//기본 생성자
	public ElectionVO() {
		super();
	}
	
	public ElectionVO(String univ_name, String election_name) {
		super();
		this.univ_name = univ_name;
		this.election_name = election_name;
	}

	public ElectionVO(String univ_name, String election_name, String status) {
		super();
		this.univ_name = univ_name;
		this.election_name = election_name;
		this.status = status;
	}

	public String getUniv_name() {
		return univ_name;
	}

	public void setUniv_name(String univ_name) {
		this.univ_name = univ_name;
	}

	public String getElection_name() {
		return election_name;
	}

	public void setElection_name(String election_name) {
		this.election_name = election_name;
	}

	public String getElection_winner() {
		return election_winner;
	}

	public void setElection_winner(String election_winner) {
		this.election_winner = election_winner;
	}

	public int getCount_candidate() {
		return count_candidate;
	}

	public void setCount_candidate(int count_candidate) {
		this.count_candidate = count_candidate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHbj1_name() {
		return hbj1_name;
	}

	public void setHbj1_name(String hbj1_name) {
		this.hbj1_name = hbj1_name;
	}

	public String getHbj1_gender() {
		return hbj1_gender;
	}

	public void setHbj1_gender(String hbj1_gender) {
		this.hbj1_gender = hbj1_gender;
	}

	public String getHbj1_grade() {
		return hbj1_grade;
	}

	public void setHbj1_grade(String hbj1_grade) {
		this.hbj1_grade = hbj1_grade;
	}

	public byte[] getHbj1_pic() {
		return hbj1_pic;
	}

	public void setHbj1_pic(byte[] hbj1_pic) {
		this.hbj1_pic = hbj1_pic;
	}

	public String getHbj1_num() {
		return hbj1_num;
	}

	public void setHbj1_num(String hbj1_num) {
		this.hbj1_num = hbj1_num;
	}

	public String getHbj1_prom1() {
		return hbj1_prom1;
	}

	public void setHbj1_prom1(String hbj1_prom1) {
		this.hbj1_prom1 = hbj1_prom1;
	}

	public String getHbj1_prom2() {
		return hbj1_prom2;
	}

	public void setHbj1_prom2(String hbj1_prom2) {
		this.hbj1_prom2 = hbj1_prom2;
	}

	public String getHbj1_prom3() {
		return hbj1_prom3;
	}

	public void setHbj1_prom3(String hbj1_prom3) {
		this.hbj1_prom3 = hbj1_prom3;
	}

	public int getHbj1_vote() {
		return hbj1_vote;
	}

	public void setHbj1_vote(int hbj1_vote) {
		this.hbj1_vote = hbj1_vote;
	}

	public String getHbj2_name() {
		return hbj2_name;
	}

	public void setHbj2_name(String hbj2_name) {
		this.hbj2_name = hbj2_name;
	}

	public String getHbj2_gender() {
		return hbj2_gender;
	}

	public void setHbj2_gender(String hbj2_gender) {
		this.hbj2_gender = hbj2_gender;
	}

	public String getHbj2_grade() {
		return hbj2_grade;
	}

	public void setHbj2_grade(String hbj2_grade) {
		this.hbj2_grade = hbj2_grade;
	}

	public byte[] getHbj2_pic() {
		return hbj2_pic;
	}

	public void setHbj2_pic(byte[] hbj2_pic) {
		this.hbj2_pic = hbj2_pic;
	}

	public String getHbj2_num() {
		return hbj2_num;
	}

	public void setHbj2_num(String hbj2_num) {
		this.hbj2_num = hbj2_num;
	}

	public String getHbj2_prom1() {
		return hbj2_prom1;
	}

	public void setHbj2_prom1(String hbj2_prom1) {
		this.hbj2_prom1 = hbj2_prom1;
	}

	public String getHbj2_prom2() {
		return hbj2_prom2;
	}

	public void setHbj2_prom2(String hbj2_prom2) {
		this.hbj2_prom2 = hbj2_prom2;
	}

	public String getHbj2_prom3() {
		return hbj2_prom3;
	}

	public void setHbj2_prom3(String hbj2_prom3) {
		this.hbj2_prom3 = hbj2_prom3;
	}

	public int getHbj2_vote() {
		return hbj2_vote;
	}

	public void setHbj2_vote(int hbj2_vote) {
		this.hbj2_vote = hbj2_vote;
	}

	public String getHbj3_name() {
		return hbj3_name;
	}

	public void setHbj3_name(String hbj3_name) {
		this.hbj3_name = hbj3_name;
	}

	public String getHbj3_gender() {
		return hbj3_gender;
	}

	public void setHbj3_gender(String hbj3_gender) {
		this.hbj3_gender = hbj3_gender;
	}

	public String getHbj3_grade() {
		return hbj3_grade;
	}

	public void setHbj3_grade(String hbj3_grade) {
		this.hbj3_grade = hbj3_grade;
	}

	public byte[] getHbj3_pic() {
		return hbj3_pic;
	}

	public void setHbj3_pic(byte[] hbj3_pic) {
		this.hbj3_pic = hbj3_pic;
	}

	public String getHbj3_num() {
		return hbj3_num;
	}

	public void setHbj3_num(String hbj3_num) {
		this.hbj3_num = hbj3_num;
	}

	public String getHbj3_prom1() {
		return hbj3_prom1;
	}

	public void setHbj3_prom1(String hbj3_prom1) {
		this.hbj3_prom1 = hbj3_prom1;
	}

	public String getHbj3_prom2() {
		return hbj3_prom2;
	}

	public void setHbj3_prom2(String hbj3_prom2) {
		this.hbj3_prom2 = hbj3_prom2;
	}

	public String getHbj3_prom3() {
		return hbj3_prom3;
	}

	public void setHbj3_prom3(String hbj3_prom3) {
		this.hbj3_prom3 = hbj3_prom3;
	}

	public int getHbj3_vote() {
		return hbj3_vote;
	}

	public void setHbj3_vote(int hbj3_vote) {
		this.hbj3_vote = hbj3_vote;
	}

	@Override
	public String toString() {
		return "ElectionVO [univ_name=" + univ_name + ", election_name=" + election_name + ", election_winner="
				+ election_winner + ", count_candidate=" + count_candidate + ", status=" + status + ", hbj1_name="
				+ hbj1_name + ", hbj1_gender=" + hbj1_gender + ", hbj1_grade=" + hbj1_grade + ", hbj1_pic="
				+ Arrays.toString(hbj1_pic) + ", hbj1_num=" + hbj1_num + ", hbj1_prom1=" + hbj1_prom1 + ", hbj1_prom2="
				+ hbj1_prom2 + ", hbj1_prom3=" + hbj1_prom3 + ", hbj1_vote=" + hbj1_vote + ", hbj2_name=" + hbj2_name
				+ ", hbj2_gender=" + hbj2_gender + ", hbj2_grade=" + hbj2_grade + ", hbj2_pic="
				+ Arrays.toString(hbj2_pic) + ", hbj2_num=" + hbj2_num + ", hbj2_prom1=" + hbj2_prom1 + ", hbj2_prom2="
				+ hbj2_prom2 + ", hbj2_prom3=" + hbj2_prom3 + ", hbj2_vote=" + hbj2_vote + ", hbj3_name=" + hbj3_name
				+ ", hbj3_gender=" + hbj3_gender + ", hbj3_grade=" + hbj3_grade + ", hbj3_pic="
				+ Arrays.toString(hbj3_pic) + ", hbj3_num=" + hbj3_num + ", hbj3_prom1=" + hbj3_prom1 + ", hbj3_prom2="
				+ hbj3_prom2 + ", hbj3_prom3=" + hbj3_prom3 + ", hbj3_vote=" + hbj3_vote + "]";
	}

}
	