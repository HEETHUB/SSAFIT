package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.User;

public interface UserService {
	public List<User> getUserList();
	public void signup(User user);
	public User login(String id, String password);
}
