package com.example.vo;

public class VoteResultVO {
	private String univ_name = null;	//대학교명
	private String election_name = null;//선거명
	private String voteid = null;		//투표자ID
	private String votenum = null;			//투표한 후보의 기호
	
	//기본 생성자
	public VoteResultVO() {
		super();
	}

	//파라미터 생성자
	public VoteResultVO(String univ_name, String election_name, String voteid, String votenum) {
		super();
		this.univ_name = univ_name;
		this.election_name = election_name;
		this.voteid = voteid;
		this.votenum = votenum;
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

	public String getVoteid() {
		return voteid;
	}

	public void setVoteid(String voteid) {
		this.voteid = voteid;
	}

	public String getVotenum() {
		return votenum;
	}

	public void setVotenum(String votenum) {
		this.votenum = votenum;
	}

	@Override
	public String toString() {
		return "VoteResultVO [univ_name=" + univ_name + ", election_name=" + election_name + ", voteid=" + voteid
				+ ", votenum=" + votenum + "]";
	}
	
}

