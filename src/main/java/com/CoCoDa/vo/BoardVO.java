package com.CoCoDa.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {

	private int boardnum;					//글번호
	private String id;						//작성자 ID
	private String title;					//글제목
	private String content;					//글내용
	private String inputdate;				//작성날짜,시간
	private int hits;						//조회수
		
	public BoardVO() {
		super();
	}

	public BoardVO(int boardnum, String id, String title, String content, String inputdate, int hits) {
		super();
		this.boardnum = boardnum;
		this.id = id;
		this.title = title;
		this.content = content;
		this.inputdate = inputdate;
		this.hits = hits;
	}

}
