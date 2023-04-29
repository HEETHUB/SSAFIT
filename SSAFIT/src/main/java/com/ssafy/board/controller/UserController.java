package com.ssafy.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

//마숙 
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//로그인 (로그인 페이지)
	@GetMapping("login")
	public String loginForm() {
		return "/user/loginform";
	}
	//로그인 (실제 수행)
	@PostMapping("login")
	public String login(User user, HttpSession session) {
		User tmp = userService.login(user.getId(), user.getPassword());
		//요기에 tmp로 올 수 있는 것은?
		//1. 실제 로그인 할 유저의 정보
		//2. null (아이디는 있는데.... 비번 틀렸어~~)
		if(tmp == null) {
			return "redirect:login";
		}
		session.setAttribute("loginUser", tmp.getName());
		return "redirect:list";
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
//		session.removeAttribute("loginUser");
		session.invalidate();
		
		//로그인 페이지로 날리던지, 목록 페이지로 날리던지...
		return "redirect:list";
		
	}
	
	
	
	//유저등록 (회원가입 페이지로 이도옹)
	@GetMapping("signup")
	public String signupForm() {
		return "/user/signupform";
	}
	
	//유저등록 (진짜 등록해)
	@PostMapping("signup")
	public String signup(User user) {
		userService.signup(user);
		//오디다가 보내지?
		//1. 결과페이지로 보낸다.
		//2. 목록 페이지로 보낸다. (회원가입 하는 순간 로그인도 되면 좋은거 아니야?)
		//2-1. 지금 내 DTO user를 고대로 실어다가 로그인 요청을 보내기
		//2-2. 지금 요기다가 세션불러다가 세션에 등록하고 목록으로 보내기
		//3. 로그인 페이지로 보낸다.(V)
		return "redirect:login";
	}
	
	
	@GetMapping("users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "/user/userList";
	}
}
