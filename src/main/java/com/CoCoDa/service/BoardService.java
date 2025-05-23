package com.CoCoDa.service;

import java.util.ArrayList;
import java.util.List;

import com.CoCoDa.entity.BoardEntity;
import com.CoCoDa.repository.BoardDao;
import com.CoCoDa.repository.BoardRepository;
import com.CoCoDa.vo.BoardVO;
import com.CoCoDa.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;


@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
    private BoardRepository boardRepository;
	
	public List<BoardVO> readingBoard(String searchText, int startRecord, int countPerPage) {
		List<BoardVO> bo = new ArrayList<>();
		
		bo = dao.readingBoard(searchText,startRecord,countPerPage);
		
		return bo;
	}
	
	public int insert(BoardVO board) {
		int num =0;
		
		num = dao.insert(board);
		
		return num;
	}
	
	
	public BoardVO readingEachBoard(int boardnum) {
		BoardVO eachBoard = null;
		eachBoard = dao.readingEachBoard(boardnum);
		
		return eachBoard;		
	}
	
	public int deleteBoard(int boardnum) {
		int num = 0;
		num=dao.deleteBoard(boardnum);
		
		return num;
	}
	
	public int updateBoard(BoardVO board) {
		int num= 0;
		num = dao.updateBoard(board);
		
		return num;
	}
	
	public int getTotal(String searchText) {
		int num = 0;
		num = dao.getTotal(searchText);
		
		return num;
	}
	
	/*리플*/
	public int insertReply(ReplyVO reply) {
		int num=0;
		num=dao.insertReply(reply);
		
		return num;
	}
	
	public ArrayList<ReplyVO> listReply(int boardnum){
		ArrayList<ReplyVO> list = null;
		list = dao.listReply(boardnum);
		
		return list;
	}
	
	public void deleteReply(ReplyVO reply) {
		dao.deleteReply(reply);
	}
	
	public int updateReply(ReplyVO reply) {
		int numm =0;
		numm=dao.updateReply(reply);
		return numm;
	}

	public Page<BoardEntity> getBoards(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("boardNum").descending());
        return boardRepository.findAll(pageable);
    }

    public Page<BoardEntity> searchBoardsByTitle(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("boardNum").descending());
        return boardRepository.findByTitleContaining(keyword, pageable);
    }

}
