package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mapper.HomeMapper;
import com.example.mapper.ManagerMapper;
import com.example.vo.DeptVO;
import com.example.vo.MemberVO;
import com.example.vo.UnivVO;

@Controller
public class HomeController {
	
	@Autowired
	ManagerMapper mMapper;
	
	@Autowired
	HomeMapper hMapper;
	
	//메인 페이지------------------------------------------------------
	@RequestMapping(value = {"/home","/"})
	public String homeGet() {
		return "home";
	}
	
	//로그인 화면------------------------------------------------------
	@RequestMapping(value = "/login")
	public String loginGET() {
		return "login";
	}
	
	//회원가입 화면-----------------------------------------------------
	@RequestMapping(value = "/join")
	public String joinGET(Model model) {
		//대학교명 선택항목 제공
		List<UnivVO> univList = mMapper.selectUnivList();
		model.addAttribute("univList",univList);
		//학과명 선택항목 제공
		List<DeptVO> deptList = mMapper.selectDeptList();
		model.addAttribute("deptList", deptList);
		
		return "join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(
			@ModelAttribute MemberVO vo,
			@RequestParam(value = "code", required = false, defaultValue = "") String code,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(vo.getAuth().equals("student") ) {
			BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
			String encodedPW = bcpe.encode(vo.getPw());
			vo.setPw(encodedPW);
			hMapper.insertMember(vo);
			request.setAttribute("message", "회원가입이 완료되었습니다");
			request.setAttribute("url", "home");
			request.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(request, response);
			return "redirect:/home";
		}
		if(vo.getAuth().equals("manager") && code.equals("관리자")) {
			BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
			String encodedPW = bcpe.encode(vo.getPw());
			vo.setPw(encodedPW);
			hMapper.insertMember(vo);
			request.setAttribute("message", "회원가입(관리자)이 완료되었습니다");
			request.setAttribute("url", "home");
			request.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(request, response);
			return "redirect:/home";
		}
		request.setAttribute("message", "회원가입이 실패하였습니다");
		request.setAttribute("url", "join");
		request.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(request, response);
		return "redirect:/join";
		
	}
	//로그아웃 화면-----------------------------------------------------
	@RequestMapping(value = "/logout")
	public String logoutGET(HttpSession httpsession) {
		httpsession.invalidate();
		return "redirect:/";
	}
	
}
