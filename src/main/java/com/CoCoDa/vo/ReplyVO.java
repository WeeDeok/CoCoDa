package com.CoCoDa.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO {
	
	private int replynum;		//리플번호
	private int boardnum;		//본문 글번호
	private String id;		//작성자 ID
	private String text;		//리플내용
	private String inputdate;		//작성날짜
	
	public ReplyVO() {
		super();
	}

	public ReplyVO(int replynum, int boardnum, String id, String text, String inputdate) {
		super();
		this.replynum = replynum;
		this.boardnum = boardnum;
		this.id = id;
		this.text = text;
		this.inputdate = inputdate;
	}

	public Object getContent() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getContent'");
	}
	

}
