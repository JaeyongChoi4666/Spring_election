package com.example.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.mapper.ManagerMapper;
import com.example.vo.ElectionVO;
import com.example.vo.UnivVO;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {
	
	@Autowired
	ManagerMapper mMapper;
	
	//관리자 메인, 선거목록 표시--------------------------------------------
	@RequestMapping(value = {"/list","/"})
	public String listGET(Model model) {
		//우측 상단 대학교명 선택항목
		List<UnivVO> univList = mMapper.selectUnivList();
		model.addAttribute("univList",univList);
		
		//메인페이지 선거목록 표시
		List<ElectionVO> electionList = mMapper.selectElectionList();
		model.addAttribute("electionList", electionList);
		return "manager/list";

	}
	
	//선거 등록--------------------------------------------------------
	@RequestMapping(value = "/insert")
	public String insertGET(Model model) {
		List<UnivVO> univList = mMapper.selectUnivList();
		model.addAttribute("univList",univList);
		
		return "manager/insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPOST(@ModelAttribute ElectionVO vo) {
		ElectionVO newElection = new ElectionVO();
		newElection.setUniv_name(vo.getUniv_name());
		newElection.setElection_name(vo.getElection_name());
		newElection.setStatus(vo.getStatus());
		
		mMapper.insertElection(newElection);
		return "redirect:/manager/list";
	}
	
	//후보자 등록 및 수정-------------------------------------------------
	@RequestMapping(value = "/updatecandidate")
	public String updatecandidateGET(
			@RequestParam(value = "univ_name") String univ_name,
			@RequestParam(value = "election_name") String election_name,
			Model model
			) {
		ElectionVO selectedOne =
				mMapper.selectOneElection(univ_name, election_name);
		
		model.addAttribute("selectedOne",selectedOne);
		model.addAttribute("univ_name",univ_name);
		model.addAttribute("election_name",election_name);
		return "manager/updatecandidate";
	}
	
	@RequestMapping(value = "/updatecandidate", method = RequestMethod.POST)
	public String updatecandidatePOST(
			@ModelAttribute ElectionVO vo,
			@RequestParam(value = "pic1") MultipartFile pic1,
			@RequestParam(value = "pic2") MultipartFile pic2,
			@RequestParam(value = "pic3") MultipartFile pic3) throws IOException, SQLException {
		ElectionVO pic = mMapper.getHBJPic(vo.getUniv_name(), vo.getElection_name());
		
		if(pic != null) {
			if(pic.getHbj1_pic() != null) {
				vo.setHbj1_pic(pic.getHbj1_pic());
			}
			if(pic.getHbj2_pic() != null) {
				vo.setHbj2_pic(pic.getHbj2_pic());
			}
			if(pic.getHbj3_pic() != null) {
				vo.setHbj3_pic(pic.getHbj3_pic());
			}
		}
		
		if(pic1.getBytes().length > 0) {
			vo.setHbj1_pic(pic1.getBytes());
		}
		if(pic2.getBytes().length > 0) {
			vo.setHbj2_pic(pic2.getBytes());
		}
		if(pic3.getBytes().length > 0) {
			vo.setHbj3_pic(pic3.getBytes());
		}
		
		mMapper.updateCandidate(vo);
		int countCandidate = mMapper.countCandidate(vo);
		vo.setCount_candidate(countCandidate);
		mMapper.updateCandidate(vo);
		return "redirect:/manager/list";
	}
	
	//선거상태 - prepare로 변경------------------------------------------
	@RequestMapping(value = "/prepare")
	public String prepareGET(
			@RequestParam(value = "univ_name") String univ_name,
			@RequestParam(value = "election_name") String election_name) {
		
		mMapper.setStatusPrepare(univ_name, election_name);
		return "redirect:/manager/list";
	}
	
	//선거상태 - process로 변경------------------------------------------
	@RequestMapping(value = "/process")
	public String processGET(
			@RequestParam(value = "univ_name") String univ_name,
			@RequestParam(value = "election_name") String election_name) {
		mMapper.setStatusProcess(univ_name, election_name);
		return "redirect:/manager/list";
	}
	
	//선거상태 - close로 변경--------------------------------------------
	@RequestMapping(value = "/close")
	public String closeGET(
			@RequestParam(value = "univ_name") String univ_name,
			@RequestParam(value = "election_name") String election_name) {
		ElectionVO selected = mMapper.selectOneElection(univ_name, election_name);
		mMapper.setStatusClose(univ_name, election_name);
		mMapper.updateVoteNumber(selected);
		mMapper.setWinner(selected);
		
		return "redirect:/manager/list";
	}
}
