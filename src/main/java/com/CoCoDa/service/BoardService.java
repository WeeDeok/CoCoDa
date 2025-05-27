package com.CoCoDa.service;

import java.util.ArrayList;

import com.CoCoDa.entity.BoardEntity;
import com.CoCoDa.repository.BoardDao;
import com.CoCoDa.repository.BoardRepository;
import com.CoCoDa.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;


@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
    private BoardRepository boardRepository;
	
	public Page<BoardEntity> getAllBoards(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("boardNum").descending());
        return boardRepository.findAll(pageable);

    }

    public Page<BoardEntity> searchBoards(String keyword, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("boardNum").descending());
        return boardRepository.findByTitleContaining(keyword, pageable);

    }

    public BoardEntity getBoardById(int boardNum) {
        return boardRepository.findById(boardNum)
                .orElseThrow(() -> new RuntimeException("Board not found"));
    }	

    public BoardEntity createBoard(BoardEntity board) {

        return boardRepository.save(board);

    }
	
	public void deleteBoard(int boardnum) {
		
		boardRepository.deleteById(boardnum);

	}
	
    public BoardEntity updateBoard(int boardNum, BoardEntity board) {

        BoardEntity existing = getBoardById(boardNum);
        existing.setTitle(board.getTitle());
        existing.setContent(board.getContent());
        return boardRepository.save(existing);

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
