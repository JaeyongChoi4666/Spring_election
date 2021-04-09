package com.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mapper.ElectionMapper;
import com.example.mapper.ManagerMapper;
import com.example.vo.ElectionVO;
import com.example.vo.VoteResultVO;

@Controller
@RequestMapping(value = "/election")
public class ElectionController {
	@Autowired
	ElectionMapper eMapper;
	@Autowired
	ManagerMapper mMapper;
	
	//학생 메인, 선거목록 표시-------------------------------------------------
	@RequestMapping(value = {"/main","","/"})
	public String mainGET(
			@RequestParam(value = "univ_name", required = false) String univ_name,
			Model model) {
		List<ElectionVO> processList = eMapper.selectProcessElection(univ_name);
		List<ElectionVO> closeList = eMapper.selectCloseElection(univ_name);
		
		model.addAttribute("processList",processList);
		model.addAttribute("closeList",closeList);
		
		return "student&manager/main";
	}
	
	//진행중인 선거목록-------------------------------------------------------
	@RequestMapping(value = "/process", method = RequestMethod.GET)
	public String processGET(
			@RequestParam(value = "univ_name") String univ_name,
			@RequestParam(value = "election_name") String election_name,
			Model model) {
		ElectionVO selected = mMapper.selectOneElection(univ_name, election_name);
		
		model.addAttribute("univ_name",univ_name);
		model.addAttribute("election_name",election_name);
		model.addAttribute("selected",selected);
		return "student&manager/process";
	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String processPOST(@ModelAttribute VoteResultVO vo,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//투표여부 확인, 0 = 없음, 1 = 있음
		int alreadyvote = eMapper.doYouVote(vo);
		String univ = vo.getUniv_name();
		if(alreadyvote == 0) {
			eMapper.insertVoteResult(vo);
			request.setAttribute("icon", "success");
			request.setAttribute("message", "투표가 완료되었습니다");
			request.setAttribute("univ_name", univ);
			request.getRequestDispatcher("/WEB-INF/views/confirm.jsp").forward(request, response);
			return "redirect:/election?univ_name="+URLEncoder.encode(univ, "utf-8");
		}
		else {
			request.setAttribute("icon", "error");
			request.setAttribute("message", "이미 투표한 선거입니다");
			request.setAttribute("univ_name", univ);
			request.getRequestDispatcher("/WEB-INF/views/confirm.jsp").forward(request, response);
			return "redirect:/election?univ_name="+URLEncoder.encode(univ, "utf-8");
		}
		
	}
	
	//과거 선거결과 표시------------------------------------------------------
	@RequestMapping(value = "/close")
	public String closeGET(
			@RequestParam(value = "univ_name") String univ_name,
			@RequestParam(value = "election_name") String election_name,
			Model model) {
		ElectionVO selected = mMapper.selectOneElection(univ_name, election_name);
		
		model.addAttribute("univ_name",univ_name);
		model.addAttribute("election_name",election_name);
		model.addAttribute("selected",selected);
		return "student&manager/close";
	}
	
	//후보자1 사진 출력------------------------------------------------------
	@RequestMapping(value = "/image1" )
	public ResponseEntity<byte[]> image1GET(
			@RequestParam("univ_name") String univ_name,
			@RequestParam("election_name") String election_name,
			HttpServletRequest request){
		try {
			ElectionVO vo = mMapper.selectOneElection(univ_name, election_name);
			byte[] pic1 = vo.getHbj1_pic();
			if(pic1.length > 0) {
				HttpHeaders header = new HttpHeaders();
				header.setContentType(MediaType.IMAGE_PNG);
				return new ResponseEntity<byte[]>(pic1, header,HttpStatus.OK);
			}
			return null;
		}catch(Exception e) {
			try {
				InputStream in = request.getServletContext().getResourceAsStream("/resources/pic/noimage.jpg");
				byte[] img = IOUtils.toByteArray(in);
				
				if(img.length > 0) {
					HttpHeaders header = new HttpHeaders();
					header.setContentType(MediaType.IMAGE_PNG);
					return new ResponseEntity<byte[]>(img, header, HttpStatus.OK);
				}
				return null;
			}
			catch (Exception e1) {
				return null;
			}
		}
	}
	//후보자2 사진 출력------------------------------------------------------
	@RequestMapping(value = "/image2" )
	public ResponseEntity<byte[]> image2GET(
			@RequestParam("univ_name") String univ_name,
			@RequestParam("election_name") String election_name,
			HttpServletRequest request){
		try {
			ElectionVO vo = mMapper.selectOneElection(univ_name, election_name);
			byte[] pic2 = vo.getHbj2_pic();
			if(pic2.length > 0) {
				HttpHeaders header = new HttpHeaders();
				header.setContentType(MediaType.IMAGE_PNG);
				return new ResponseEntity<byte[]>(pic2, header,HttpStatus.OK);
			}
			return null;
		}catch(Exception e) {
			try {
				InputStream in = request.getServletContext().getResourceAsStream("/resources/pic/noimage.jpg");
				byte[] img = IOUtils.toByteArray(in);
				
				if(img.length > 0) {
					HttpHeaders header = new HttpHeaders();
					header.setContentType(MediaType.IMAGE_PNG);
					return new ResponseEntity<byte[]>(img, header, HttpStatus.OK);
				}
				return null;
			}
			catch (Exception e1) {
				return null;
			}
		}
	}
	//후보자3 사진 출력------------------------------------------------------
	@RequestMapping(value = "/image3" )
	public ResponseEntity<byte[]> image3GET(
			@RequestParam("univ_name") String univ_name,
			@RequestParam("election_name") String election_name,
			HttpServletRequest request){
		try {
			ElectionVO vo = mMapper.selectOneElection(univ_name, election_name);
			byte[] pic3 = vo.getHbj3_pic();
			if(pic3.length > 0) {
				HttpHeaders header = new HttpHeaders();
				header.setContentType(MediaType.IMAGE_PNG);
				return new ResponseEntity<byte[]>(pic3, header,HttpStatus.OK);
			}
			return null;
		}catch(Exception e) {
			try {
				InputStream in = request.getServletContext().getResourceAsStream("/resources/pic/noimage.jpg");
				byte[] img = IOUtils.toByteArray(in);
				
				if(img.length > 0) {
					HttpHeaders header = new HttpHeaders();
					header.setContentType(MediaType.IMAGE_PNG);
					return new ResponseEntity<byte[]>(img, header, HttpStatus.OK);
				}
				return null;
			}
			catch (Exception e1) {
				return null;
			}
		}
	}
}