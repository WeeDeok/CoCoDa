package com.CoCoDa.controller;

import com.CoCoDa.entity.BoardEntity;
import com.CoCoDa.entity.ReplyEntity;
import com.CoCoDa.service.BoardService;
import com.CoCoDa.vo.ReplyVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardRestController {

    private final BoardService service;

    /** 게시글 전체 조회 (페이징) */
    @GetMapping
    public Page<BoardEntity> getBoards(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.getBoards(page, size);
    }

    /** 게시글 검색 (제목 기반, 페이징 포함) */
    @GetMapping("/search")
    public Page<BoardEntity> searchBoards(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.searchBoardsByTitle(keyword, page, size);
    }

    /** 게시글 단건 조회 */
    @GetMapping("/{boardnum}")
    public BoardEntity getBoard(@PathVariable int boardnum) {
        return service.getBoardById(boardnum);
    }

    /** 게시글 생성 */
    @PostMapping
    public BoardEntity createBoard(@RequestBody BoardEntity board) {
        return service.createBoard(board);
    }

    /** 게시글 수정 */
    @PutMapping("/{boardnum}")
    public BoardEntity updateBoard(@PathVariable int boardnum, @RequestBody BoardEntity board) {
        
        return service.updateBoard(boardnum, board);
    }

    /** 게시글 삭제 */
    @DeleteMapping("/{boardnum}")
    public void deleteBoard(@PathVariable int boardnum) {
        service.deleteBoard(boardnum);
    }

    /** 특정 게시글에 대한 댓글 목록 조회 */
    @GetMapping("/{boardnum}/replies")
    public ArrayList<ReplyVO> getReplies(@PathVariable int boardnum) {
        return service.listReply(boardnum);
    }

    /** 댓글 작성 */
    @PostMapping("/{boardnum}/replies")
    public ReplyEntity createReply(@PathVariable int boardnum, @RequestBody ReplyVO reply, HttpSession session) {
        reply.setBoardnum(boardnum);
        reply.setId((String) session.getAttribute("userid"));
        return null;
    }

    /** 댓글 수정 */
    @PutMapping("/replies/{replynum}")
    public ReplyEntity updateReply(@PathVariable int replynum, @RequestBody ReplyVO reply) {
        reply.setReplynum(replynum);
        return null;
    }

    /** 댓글 삭제 */
    @DeleteMapping("/replies/{replynum}")
    public void deleteReply(@PathVariable int replynum, HttpSession session) {
        ReplyVO reply = new ReplyVO();
        reply.setReplynum(replynum);
        reply.setId((String) session.getAttribute("userid"));
        service.deleteReply(reply);
    }
}
