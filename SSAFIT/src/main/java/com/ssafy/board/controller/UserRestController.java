package com.ssafy.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

import io.swagger.annotations.Api;

//마숙 

@RestController
@RequestMapping("/api/user")
@Api(tags = "유저 컨트롤러")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	// 로그인
	@PostMapping("login")
	public ResponseEntity<?> login(User user, HttpSession session) {
		User tmp = userService.login(user.getId(), user.getPassword());

		if(tmp == null) 
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		session.setAttribute("loginUser", tmp.getName());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	//로그아웃
	@GetMapping("logout")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 유저등록
	@PostMapping("signup")
	public ResponseEntity<User> signup(User user) {
		System.out.println(user.getName()+"님을 새로운 유저로 등록합니다.");
		userService.signup(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	// 등록된 유저들 다 가져오기 
	@GetMapping("users")
	public ResponseEntity<?> userList() {
		List<User> list = userService.getUserList();
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
}
