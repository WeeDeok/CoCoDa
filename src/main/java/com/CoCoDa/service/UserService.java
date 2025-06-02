package com.CoCoDa.service;

import com.CoCoDa.repository.UserDao;
import com.CoCoDa.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	public UserVO userlogin(UserVO user) {
		UserVO us = dao.userlogin(user);
		return us;
	}
	
	public int userjoin(UserVO user) {
		int result =0;
		result = dao.userjoin(user);
		return result;
	}
	
	public int searchUserid(String userid) {
		int numm = 0;
		numm = dao.searchUserid(userid);
		return numm;
	}
	
	public int joinUser(UserVO user) {
		int number = 0;
		number = dao.joinUser(user);
		return number;
	}

}
