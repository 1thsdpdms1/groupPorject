package org.spring.spring_board_0331.controller;

import lombok.RequiredArgsConstructor;
import org.spring.spring_board_0331.repository.BoardRepository;
import org.spring.spring_board_0331.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/write")
    public String write(){
        return "board/write";
    }

    @PostMapping("/write")
    public String writeOk(){
        return "board/write";
    }
}
