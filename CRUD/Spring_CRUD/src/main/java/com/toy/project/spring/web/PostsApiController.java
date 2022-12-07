package com.toy.project.spring.web;

import com.toy.project.spring.service.PostsService;
import com.toy.project.spring.web.dto.PostsListResponseDto;
import com.toy.project.spring.web.dto.PostsResponseDto;
import com.toy.project.spring.web.dto.PostsSaveRequestDto;
import com.toy.project.spring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @GetMapping("/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping
    public List<PostsListResponseDto> getPostsList() {
        return postsService.findAllDesc();
    }



}