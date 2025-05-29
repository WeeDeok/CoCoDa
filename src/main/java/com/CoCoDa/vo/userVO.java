package com.CoCoDa.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class userVO {
	
	private String userid;
    private String userpw;
    private String username;
    private String useremail;
    
	public userVO() {
		super();
	}

	public userVO(String userid, String userpw, String username, String useremail) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.useremail = useremail;
	}
    
}
