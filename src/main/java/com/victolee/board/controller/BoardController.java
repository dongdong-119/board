package com.victolee.board.controller;


import com.victolee.board.dto.BoardDto;
import com.victolee.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/")
    public String list(Model model){

        List<BoardDto> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);

        return "board/list.html";
    }

    @GetMapping("/post")
    public String write(){
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);

        //글쓰면 원래 기본페이지로 돌아감
        return "redirect:/";
    }







}
