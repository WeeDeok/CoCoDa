package com.CoCoDa.repository;

import com.CoCoDa.vo.UserVO;
import org.springframework.stereotype.Repository;

import com.CoCoDa.mapper.UserMapper;

@Repository
public class UserDao {

	private UserMapper mapper;

	public UserVO userlogin(UserVO user) {
		
			UserVO us = mapper.userlogin(user);
			return us;
		
	}
	
	public int userjoin(UserVO user) {

		int result =0;
			
			result=mapper.userjoin(user);
			
			return result;
		
	}
	
	public int searchUserid(String userid) {
		
		String name = mapper.searchUserid(userid);

		if(name!=null) return 1;
		
		return 0;

	}
	
	public int joinUser(UserVO user) {

		int number=0;
		
		number = mapper.joinUser(user);
		
		return number;

	}
	
}
