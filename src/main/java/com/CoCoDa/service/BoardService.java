package com.CoCoDa.service;

import java.util.ArrayList;

import com.CoCoDa.entity.BoardEntity;
import com.CoCoDa.repository.BoardDao;
import com.CoCoDa.repository.BoardRepository;
import com.CoCoDa.vo.ReplyVO;
import com.CoCoDa.Constant.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;


@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	@Autowired
    private BoardRepository boardRepository;
	
	public Page<BoardEntity> getAllBoards(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("boardNum").descending());
        return boardRepository.findAll(pageable);

    }

    public Page<BoardEntity> searchBoards(String keyword, int page, int size) {
        if (keyword == null || keyword.trim().isEmpty()) {
            keyword = "";
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by("boardNum").descending());
        return boardRepository.findByTitleContaining(keyword, pageable);

    }

    public BoardEntity getBoardById(int boardNum) {
        return boardRepository.findById(boardNum)
                .orElseThrow(() -> new RuntimeException(ErrorMessage.BOARD_NOT_FOUND.getMessage()));
    }	

    public BoardEntity createBoard(BoardEntity board) {
        if (board == null) {
            throw new IllegalArgumentException(ErrorMessage.BOARD_CANNOT_BE_NULL.getMessage());
        }
        return boardRepository.save(board);

    }
	
	public void deleteBoard(int boardnum) {
		
		boardRepository.deleteById(boardnum);

	}
	
    public BoardEntity updateBoard(int boardNum, BoardEntity board) {
        if (board == null) {
            throw new IllegalArgumentException(ErrorMessage.BOARD_CANNOT_BE_NULL.getMessage());
        }
        BoardEntity existing = getBoardById(boardNum);
        existing.setTitle(board.getTitle() != null ? board.getTitle() : existing.getTitle());
        existing.setContent(board.getContent() != null ? board.getContent() : existing.getContent());
        return boardRepository.save(existing);

    }

	public int getTotal(String searchText) {
		int num = 0;
		if (searchText == null) {
			searchText = "";
		}
		num = dao.getTotal(searchText);
		
		return num;
	}
	
	/*리플*/
	public int insertReply(ReplyVO reply) {
		if (reply == null) {
			throw new IllegalArgumentException(ErrorMessage.REPLY_CANNOT_BE_NULL.getMessage());
		}
		int num=0;
		num=dao.insertReply(reply);
		
		return num;
	}
	
	public ArrayList<ReplyVO> listReply(int boardnum){
		ArrayList<ReplyVO> list = new ArrayList<>();
		ArrayList<ReplyVO> result = dao.listReply(boardnum);
		if (result != null) {
			list = result;
		}
		return list;
	}
	
	public void deleteReply(ReplyVO reply) {
		if (reply == null) {
			throw new IllegalArgumentException(ErrorMessage.REPLY_CANNOT_BE_NULL.getMessage());
		}
		dao.deleteReply(reply);
	}
	
	public int updateReply(ReplyVO reply) {
		if (reply == null) {
			throw new IllegalArgumentException(ErrorMessage.REPLY_CANNOT_BE_NULL.getMessage());
		}
		int numm =0;
		numm=dao.updateReply(reply);
		return numm;
	}

	public Page<BoardEntity> getBoards(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("boardNum").descending());
        return boardRepository.findAll(pageable);
    }

    public Page<BoardEntity> searchBoardsByTitle(String keyword, int page, int size) {
        if (keyword == null || keyword.trim().isEmpty()) {
            keyword = "";
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by("boardNum").descending());
        return boardRepository.findByTitleContaining(keyword, pageable);
    }

}
