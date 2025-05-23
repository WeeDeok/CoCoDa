package com.CoCoDa.vo;

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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	@Override
	public String toString() {
		return "user [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", useremail=" + useremail
				+ "]";
	}
    
    

}
