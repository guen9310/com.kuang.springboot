package com.kuang.portfolio.springboot.web;

import com.kuang.portfolio.springboot.config.auth.LoginUser;
import com.kuang.portfolio.springboot.config.auth.dto.SessionUser;
import com.kuang.portfolio.springboot.domain.user.Role;
import com.kuang.portfolio.springboot.service.posts.PostsService;
import com.kuang.portfolio.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;


    // 목차
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName",user.getName());
            model.addAttribute("userData",user);
        }
        return "index";
    }

    //로그인 페이지 이동
    @GetMapping("/posts/login")
    public String login(){
        return "login";
    }

    //글 등록 페이지 이동
    @GetMapping("/posts/save")
    public String postsSave(Model model){
        String name = Role.USER.name();
        model.addAttribute("name",name);
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
