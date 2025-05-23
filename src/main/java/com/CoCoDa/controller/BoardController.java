package com.CoCoDa.controller;

import com.CoCoDa.entity.BoardEntity;
import com.CoCoDa.entity.ReplyEntity;
import com.CoCoDa.service.BoardService;
import com.CoCoDa.vo.BoardVO;
import com.CoCoDa.vo.ReplyVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board") // 공통 경로
public class BoardController {
	
	@Autowired
    private BoardService service;
	
    @GetMapping
    public Page<BoardEntity> getBoards(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size) {
        return service.getBoards(page, size);
    }

    // 제목 검색 + 페이징
    @GetMapping("/search")
    public Page<BoardEntity> searchBoards(@RequestParam String keyword,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size) {

        return service.searchBoardsByTitle(keyword, page, size);
		
    }

    @GetMapping("/delete")
    public String deleteBoard(@RequestParam int boardnum) {
        service.deleteBoard(boardnum);
        return "redirect:/boardPage";
    }

    @GetMapping("/update")
    public String updateBoard(BoardVO board, Model model) {
        service.updateBoard(board);
        BoardVO updatedBoard = service.readingEachBoard(board.getBoardnum());
        model.addAttribute("eachBoard", updatedBoard);
        return "redirect:/readingEachBoard?boardnum=" + board.getBoardnum();
    }

    @GetMapping("/towrite")
    public String boardWrite() {
        return "boardWrite";
    }

    @PostMapping("/write")
    public String write(BoardVO board, HttpSession session) {
        String id = (String) session.getAttribute("userid");
        board.setId(id);
        service.insert(board);
        return "redirect:/boardPage";
    }

    @PostMapping("/replyWrite")
    public String replyWrite(ReplyVO reply, HttpSession session) {
        String id = (String) session.getAttribute("userid");
        reply.setId(id);
        service.insertReply(reply);
        return "redirect:/readingEachBoard?boardnum=" + reply.getBoardnum();
    }

    @GetMapping("/replydelete")
    public String deleteReply(ReplyVO reply, HttpSession session) {
        reply.setId((String) session.getAttribute("userid"));
        service.deleteReply(reply);
        return "redirect:/readingEachBoard?boardnum=" + reply.getBoardnum();
    }

    @GetMapping("/replyupdate")
    public String replyUpdate(ReplyVO reply) {
        service.updateReply(reply);
        return "redirect:/readingEachBoard?boardnum=" + reply.getBoardnum();
    }

}
