package com.CoCoDa.repository;

import java.util.ArrayList;
import java.util.List;

import com.CoCoDa.mapper.BoardMapper;
import com.CoCoDa.vo.BoardVO;
import com.CoCoDa.vo.ReplyVO;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> readingBoard(String searchText, int startRecord, int countPerPage) {
		
		RowBounds rb = new RowBounds(startRecord, countPerPage);
		
		List<BoardVO> readingBoard = mapper.readingBoard(searchText, rb);
		
		return readingBoard;

	}
	
	
	public int insert(BoardVO board) {
		
		int result = 0;
		try {
			result = mapper.insertboard(board);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	
	public BoardVO readingEachBoard(int boardnum) {
		
		BoardVO eachBoard = mapper.readingEachBoard(boardnum);
		mapper.addHits(boardnum);
		
		return eachBoard;

	}
	
	public int deleteBoard(int boardnum) {

		int num = 0;
		
		num = mapper.deleteBoard(boardnum);
		
		return num;

	}
	
	public int updateBoard(BoardVO board) {

		int num=0;
		
		num=mapper.updateBoard(board);
		
		return num;

	}
	
	public int getTotal(String searchText) {		
			
		int total = mapper.getTotal(searchText);	
		return total;	

	}		
	
	public int insertReply(ReplyVO reply) {
		
		int result = 0;
		result = mapper.insertReply(reply);

		return result;

	}
	
	public ArrayList<ReplyVO> listReply(int boardnum){
		
		ArrayList<ReplyVO> list = null;
		list=mapper.listReply(boardnum);
		return list;

	}
	
	//리플 삭제
	public void deleteReply(ReplyVO reply) {
		
		mapper.deleteReply(reply);

	}
	
	//리플 수정
	public int updateReply(ReplyVO reply) {
		
		int numm = 0;
		numm = mapper.updateReply(reply);
		return numm;
		
	}
}
