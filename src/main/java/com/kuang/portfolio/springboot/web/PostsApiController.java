package com.kuang.portfolio.springboot.web;

import com.kuang.portfolio.springboot.service.posts.PostsService;
import com.kuang.portfolio.springboot.web.dto.PostsResponseDto;
import com.kuang.portfolio.springboot.web.dto.PostsSaveRequestDto;
import com.kuang.portfolio.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    //글 등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //글 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@RequestBody PostsUpdateRequestDto requestDto,@PathVariable Long id){
        return postsService.update(requestDto,id);
    }

    //글 삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

    //글 번호 찾기
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
    }
