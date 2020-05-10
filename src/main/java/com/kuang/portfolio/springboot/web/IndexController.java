package com.kuang.portfolio.springboot.web;

import com.kuang.portfolio.springboot.service.posts.PostsService;
import com.kuang.portfolio.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;


    // 목차
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    //로그인 페이지 이동
    @GetMapping("/posts/login")
    public String login(){
        return "login";
    }

    //글 등록 페이지 이동
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    //글 수정 페이지 이동
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts",dto);
        return "posts-update";
    }
}
