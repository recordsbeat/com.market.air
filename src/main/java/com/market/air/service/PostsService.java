package com.market.air.service;

import com.market.air.domain.posts.Posts;
import com.market.air.domain.posts.PostsRepository;
import com.market.air.domain.user.Users;
import com.market.air.domain.user.UsersRepository;
import com.market.air.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.h2.engine.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private  final UsersRepository usersRepository;

    @Transactional
    public void save(Long id,PostsSaveRequestDto requestDto){
        Users users = usersRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 유저가 존재하지 않습니다. id ="+id));


        Posts posts = requestDto.toEntity();
        users.addPost(posts);
        posts.putUser(users);
        usersRepository.save(users);
    }
}
