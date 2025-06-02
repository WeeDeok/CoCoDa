package com.CoCoDa.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.CoCoDa.vo.UserVO;

@Mapper
public interface UserMapper {

	public UserVO userlogin(UserVO user);
	
	public int userjoin(UserVO user);
	
	public String searchUserid(String userid);
	
	public int joinUser(UserVO user);
}
