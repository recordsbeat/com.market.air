package com.market.air.web;

import com.market.air.service.PostsService;
import com.market.air.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public void save(@RequestBody PostsSaveRequestDto requestDto){
        //return postsService.save(requestDto);
    }
}
