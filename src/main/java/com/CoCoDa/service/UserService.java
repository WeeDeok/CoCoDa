package com.CoCoDa.service;

import com.CoCoDa.entity.UserEntity;
import com.CoCoDa.repository.UserDao;
import com.CoCoDa.repository.UserRepository;
import com.CoCoDa.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	private UserRepository userRepository;
	
	public UserEntity userlogin(UserEntity user) {

		return userRepository.findById(user.getUserid()).orElseThrow(() -> new RuntimeException("User Not Found"));

	}
	
	public UserEntity userjoin(UserEntity user) {
		
		if (userRepository.findById(user.getUserid()).isPresent()) {

			throw new RuntimeException("User Exist");

		}

		return userRepository.save(user);

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
