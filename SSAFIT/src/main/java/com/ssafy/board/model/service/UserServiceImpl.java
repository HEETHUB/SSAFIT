package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public void signup(User user) {
		userDao.insertUser(user);
	}

	@Override
	public User login(String id, String password) {
		//우리의 고민거리~~! 
		//실제 DB에 id만을 가지고 User 정보를 가지고와서 요기에서 가져온 User의 비밀번호와 password 라고 하는 요녀석을 비교해서 처리
		//DB에 id / pw 둘다 넘겨서 ... WHERE 조건문을 통해 실제로 일치하는 유저가 있다면 들고 오게 할건지.... 
		User tmp = userDao.selectOne(id);
		//다음 중  tmp에 들어갈 수있는 것들은 ? 
		//1. 아이디가 일치하는 유저의 정보
		//2. null
		if(tmp != null && tmp.getPassword().equals(password))
			return tmp;
		return null;
	}

}
