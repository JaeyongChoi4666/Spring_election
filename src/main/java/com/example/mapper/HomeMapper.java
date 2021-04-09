package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.vo.MemberVO;

@Mapper
public interface HomeMapper {
	
	@Insert({"INSERT INTO VOTER_MEMBER_LIST(ID,UNIV_NAME,DEPT_NAME,STU_NAME,STU_NUM,STU_GRD,AUTH,PW) "
			+ "VALUES (#{vo.id},#{vo.univ_name},#{vo.dept_name},#{vo.stu_name},#{vo.stu_num},#{vo.stu_grd},#{vo.auth},#{vo.pw})"})
	public int insertMember(@Param("vo") MemberVO vo);
	
	
	@Select({"SELECT ID,UNIV_NAME,DEPT_NAME,STU_NAME,STU_NUM,STU_GRD,AUTH,PW FROM VOTER_MEMBER_LIST WHERE ID = #{id}"})
	public MemberVO findByID(@Param("id") String id);
}

