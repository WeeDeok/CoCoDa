package com.CoCoDa.service;

import com.CoCoDa.entity.UserEntity;
import com.CoCoDa.repository.UserDao;
import com.CoCoDa.repository.UserRepository;
import com.CoCoDa.vo.UserVO;
import com.CoCoDa.Constant.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity userlogin(UserEntity user) {
		if (user == null || user.getUserid() == null) {
			throw new IllegalArgumentException(ErrorMessage.USER_OR_USERID_CANNOT_BE_NULL.getMessage());
		}
		return userRepository.findById(user.getUserid()).orElseThrow(() -> new RuntimeException(ErrorMessage.USER_NOT_FOUND.getMessage()));

	}
	
	public UserEntity userjoin(UserEntity user) {
		if (user == null || user.getUserid() == null) {
			throw new IllegalArgumentException(ErrorMessage.USER_OR_USERID_CANNOT_BE_NULL.getMessage());
		}
		if (userRepository.findById(user.getUserid()).isPresent()) {

			throw new RuntimeException(ErrorMessage.USER_EXIST.getMessage());

		}

		return userRepository.save(user);

	}
	
	public int searchUserid(String userid) {
		if (userid == null) {
			throw new IllegalArgumentException(ErrorMessage.USERID_CANNOT_BE_NULL.getMessage());
		}
		int numm = 0;
		numm = dao.searchUserid(userid);
		return numm;

	}
	
	public int joinUser(UserVO user) {
		if (user == null) {
			throw new IllegalArgumentException(ErrorMessage.USER_CANNOT_BE_NULL.getMessage());
		}
		int number = 0;
		number = dao.joinUser(user);
		return number;

	}

}
