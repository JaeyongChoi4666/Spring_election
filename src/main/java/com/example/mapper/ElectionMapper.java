package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.vo.ElectionVO;
import com.example.vo.VoteResultVO;

@Mapper
public interface ElectionMapper {
	//진행중인 선거 목록
	@Select({"SELECT UNIV_NAME, ELECTION_NAME FROM ELECTION_LIST WHERE UNIV_NAME = #{vo} AND STATUS = 'process'"})
	public List<ElectionVO> selectProcessElection(@Param("vo") String univ_name);
	
	//종료된 선거 목록
	@Select({"SELECT UNIV_NAME, ELECTION_NAME FROM ELECTION_LIST WHERE UNIV_NAME = #{vo} AND STATUS = 'close'"})
	public List<ElectionVO> selectCloseElection(@Param("vo") String univ_name);
	
	//개인의 투표결과 입력
	@Insert({"INSERT INTO VOTE_RESULT_LIST(UNIV_NAME,ELECTION_NAME,VOTERID,VOTENUM) "
			+ "VALUES(#{vo.univ_name},#{vo.election_name},#{vo.voteid},#{vo.votenum})"})
	public int insertVoteResult(@Param("vo") VoteResultVO vo);
	
	//선거여부 확인, 0 = 없음, 1 = 있음
	@Select({"SELECT COUNT(*) FROM VOTE_RESULT_LIST 		"
			+ "WHERE UNIV_NAME = #{vo.univ_name} 			"
			+ "AND ELECTION_NAME = #{vo.election_name} 		"
			+ "AND VOTERID = #{vo.voteid}					"})
	public int doYouVote(@Param("vo") VoteResultVO vo);

}

