package com.CoCoDa.mapper;

import java.util.List;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import com.CoCoDa.vo.BoardVO;
import com.CoCoDa.vo.ReplyVO;

public interface BoardMapper {

	//public List<board> readingBoard();
	
	public List<BoardVO> readingBoard(String searchText, RowBounds rb);
	
	public int addHits(int boardnum);
	
	public BoardVO readingEachBoard(int boardnum);
	
	public int deleteBoard(int boardnum); 
	
	public int updateBoard(BoardVO board);
	
	public int getTotal(String searchText);

	public int insertboard(BoardVO board);
	
	public int insertReply(ReplyVO reply);
	
	public ArrayList<ReplyVO> listReply(int boardnum);
	
	public void deleteReply(ReplyVO reply);
	
	public int updateReply(ReplyVO reply);
	
}
