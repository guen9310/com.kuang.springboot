package com.kuang.portfolio.springboot.web.dto;

import com.kuang.portfolio.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entitly){
        this.id = entitly.getId();
        this.title = entitly.getTitle();
        this.content = entitly.getContent();
        this.author = entitly.getAuthor();
    }
}
