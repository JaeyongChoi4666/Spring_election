package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.example.vo.DeptVO;
import com.example.vo.ElectionVO;
import com.example.vo.UnivVO;

@Mapper
public interface ManagerMapper {
	
	//관리자||학생-대학교 목록 출력
	@Select({"SELECT UNIV_NAME FROM UNIV_LIST"})
	public List<UnivVO> selectUnivList();
	
	//관리자||학생-학과 목록 출력
	@Select({"SELECT UNIV_NAME, DEPT_NAME FROM DEPT_LIST"})
	public List<DeptVO> selectDeptList();
	
	//관리자-선거 추가
	@Insert({
			"INSERT INTO ELECTION_LIST(UNIV_NAME, ELECTION_NAME, STATUS) VALUES("
			+ "#{vo.univ_name,jdbcType=VARCHAR},								"
			+ "#{vo.election_name,jdbcType=VARCHAR},							"
			+ "#{vo.status,jdbcType=VARCHAR})									"
			})
	public int insertElection(@Param("vo") ElectionVO vo);
	
	//관리자-전체 선거목록 출력
	@Select({"SELECT UNIV_NAME, ELECTION_NAME, STATUS, COUNT_CANDIDATE FROM ELECTION_LIST ORDER BY DECODE(STATUS,'process',1,'prepare',2,3)"})
	public List<ElectionVO> selectElectionList();
	
	//관리자-후보자 정보 표시
	@Select({"SELECT "
			+ "UNIV_NAME,ELECTION_NAME,"
			+ "HBJ1_NAME,HBJ1_GENDER,HBJ1_GRADE,HBJ1_NUM,HBJ1_PROM1,HBJ1_PROM2,HBJ1_PROM3,"
			+ "HBJ2_NAME,HBJ2_GENDER,HBJ2_GRADE,HBJ2_NUM,HBJ2_PROM1,HBJ2_PROM2,HBJ2_PROM3,"
			+ "HBJ3_NAME,HBJ3_GENDER,HBJ3_GRADE,HBJ3_NUM,HBJ3_PROM1,HBJ3_PROM2,HBJ3_PROM3,"
			+ "HBJ1_PIC, HBJ2_PIC, HBJ3_PIC,HBJ1_VOTE, HBJ2_VOTE, HBJ3_VOTE, ELECTION_WINNER "
			+ "FROM ELECTION_LIST "
			+ "WHERE UNIV_NAME = #{univ_name} AND ELECTION_NAME = #{election_name}"})
	public ElectionVO selectOneElection(
			@Param("univ_name") String univ_name,
			@Param("election_name") String election_name);
	
	//관리자-후보자정보 수정
	@Update({
		"UPDATE ELECTION_LIST SET 						"
		+ "HBJ1_NAME = #{vo.hbj1_name},					"
		+ "HBJ1_GENDER = #{vo.hbj1_gender},				"
		+ "HBJ1_GRADE = #{vo.hbj1_grade},				"
		+ "HBJ1_NUM = #{vo.hbj1_num},					"
		+ "HBJ1_PIC = #{vo.hbj1_pic:BLOB},				"
		+ "HBJ1_PROM1 = #{vo.hbj1_prom1},				"
		+ "HBJ1_PROM2 = #{vo.hbj1_prom2},				"
		+ "HBJ1_PROM3 = #{vo.hbj1_prom3},				"
		
		+ "HBJ2_NAME = #{vo.hbj2_name},					"
		+ "HBJ2_GENDER = #{vo.hbj2_gender},				"
		+ "HBJ2_GRADE = #{vo.hbj2_grade},				"
		+ "HBJ2_NUM = #{vo.hbj2_num},					"
		+ "HBJ2_PIC = #{vo.hbj2_pic:BLOB},				"
		+ "HBJ2_PROM1 = #{vo.hbj2_prom1},				"
		+ "HBJ2_PROM2 = #{vo.hbj2_prom2},				"
		+ "HBJ2_PROM3 = #{vo.hbj2_prom3},				"
			
		+ "HBJ3_NAME = #{vo.hbj3_name},					"
		+ "HBJ3_GENDER = #{vo.hbj3_gender},				"
		+ "HBJ3_GRADE = #{vo.hbj3_grade},				"
		+ "HBJ3_NUM = #{vo.hbj3_num},					"
		+ "HBJ3_PIC = #{vo.hbj3_pic:BLOB},				"
		+ "HBJ3_PROM1 = #{vo.hbj3_prom1},				"
		+ "HBJ3_PROM2 = #{vo.hbj3_prom2},				"
		+ "HBJ3_PROM3 = #{vo.hbj3_prom3}, 				"
		
		+ "COUNT_CANDIDATE = #{vo.count_candidate} 		"
		
		+ "WHERE UNIV_NAME = #{vo.univ_name} 			"
		+ "AND ELECTION_NAME = #{vo.election_name}		"
			})
	public int updateCandidate(@Param("vo") ElectionVO vo);
	
	//관리자-등록 후보자수 세기
	@Select({"SELECT COUNT(HBJ1_NAME)+COUNT(HBJ2_NAME)+COUNT(HBJ3_NAME) AS COUNT_CANDIDATE "
			+ "FROM ELECTION_LIST "
			+ "WHERE UNIV_NAME=#{vo.univ_name} AND ELECTION_NAME=#{vo.election_name}"})
	public int countCandidate(@Param("vo") ElectionVO vo);
	
	
	//관리자-선거상태 > prepare
	@Update({"UPDATE ELECTION_LIST SET STATUS = 'prepare' WHERE UNIV_NAME = #{univ_name} AND ELECTION_NAME = #{election_name}"})
	public int setStatusPrepare(@Param("univ_name") String univ_name,@Param("election_name") String election_name);
	//관리자-선거상태 > process
	@Update({"UPDATE ELECTION_LIST SET STATUS = 'process' WHERE UNIV_NAME = #{univ_name} AND ELECTION_NAME = #{election_name}"})
	public int setStatusProcess(@Param("univ_name") String univ_name,@Param("election_name") String election_name);
	//관리자-선거상태 > close
	@Update({"UPDATE ELECTION_LIST SET STATUS = 'close' WHERE UNIV_NAME = #{univ_name} AND ELECTION_NAME = #{election_name}"})
	public int setStatusClose(@Param("univ_name") String univ_name,@Param("election_name") String election_name);
	
	//관리자-후보자 개별 사진값 출력
	@Results(value = {
		@Result(property = "hbj1_pic", column="HBJ1_PIC", jdbcType=JdbcType.BLOB, javaType= byte[].class),
		@Result(property = "hbj2_pic", column="HBJ2_PIC", jdbcType=JdbcType.BLOB, javaType= byte[].class),
		@Result(property = "hbj3_pic", column="HBJ3_PIC", jdbcType=JdbcType.BLOB, javaType= byte[].class),
	})
	@Select({"SELECT HBJ1_PIC,HBJ2_PIC,HBJ3_PIC FROM ELECTION_LIST WHERE UNIV_NAME = #{univ_name} AND ELECTION_NAME = #{election_name}"})
	public ElectionVO getHBJPic(@Param("univ_name") String univ_name,@Param("election_name") String election_name);
	
	//관리자-각 후보자 득표수 계산
	@Update({"UPDATE ELECTION_LIST SET 										"
			+ "HBJ1_VOTE = (SELECT COUNT(*) FROM 							"
			+ "				(SELECT VOTENUM FROM VOTE_RESULT_LIST 			"
			+ "					WHERE VOTENUM = #{vo.hbj1_num} 				"
			+ "					AND UNIV_NAME = #{vo.univ_name} 			"
			+ "					AND ELECTION_NAME = #{vo.election_name})),	"
			+ "HBJ2_VOTE = (SELECT COUNT(*) FROM 							"
			+ "				(SELECT VOTENUM FROM VOTE_RESULT_LIST 			"
			+ "					WHERE VOTENUM = #{vo.hbj2_num} 				"
			+ "					AND UNIV_NAME = #{vo.univ_name} 			"
			+ "					AND ELECTION_NAME = #{vo.election_name})),	"
			+ "HBJ3_VOTE = (SELECT COUNT(*) FROM 							"
			+ "				(SELECT VOTENUM FROM VOTE_RESULT_LIST 			"
			+ "					WHERE VOTENUM = #{vo.hbj3_num} 				"
			+ "					AND UNIV_NAME = #{vo.univ_name} 			"
			+ "					AND ELECTION_NAME = #{vo.election_name}))  	"
			+ "WHERE UNIV_NAME = #{vo.univ_name} AND ELECTION_NAME = #{vo.election_name} "})
	public int updateVoteNumber(@Param("vo") ElectionVO vo);
	
	//관리자-당선자 결정
	@Update({"UPDATE ELECTION_LIST SET "
			+ "ELECTION_WINNER = CASE "
			+ "						WHEN (#{vo.hbj1_vote}>#{vo.hbj2_vote} AND #{vo.hbj1_vote}>#{vo.hbj3_vote}) THEN #{vo.hbj1_name,jdbcType=VARCHAR} "
			+ "						WHEN (#{vo.hbj2_vote}>#{vo.hbj1_vote} AND #{vo.hbj2_vote}>#{vo.hbj3_vote}) THEN #{vo.hbj2_name,jdbcType=VARCHAR} "
			+ "						WHEN (#{vo.hbj3_vote}>#{vo.hbj1_vote} AND #{vo.hbj3_vote}>#{vo.hbj2_vote}) THEN #{vo.hbj3_name,jdbcType=VARCHAR} "
			+ "						ELSE '재투표' "
			+ "					 END "
			+ "WHERE UNIV_NAME = #{vo.univ_name} AND ELECTION_NAME = #{vo.election_name}"})
	public int setWinner(@Param("vo") ElectionVO vo);
}

