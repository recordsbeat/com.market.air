package com.market.air.service;

import com.market.air.domain.posts.Posts;
import com.market.air.domain.user.Users;
import com.market.air.domain.user.UsersRepository;
import com.market.air.domain.vo.enums.ContactType;
import com.market.air.web.dto.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    PostsService postsService;
    @Autowired
    UsersRepository usersRepository;

    @Before
    public void setUp() throws Exception {
        Users user1 = Users.builder()
                .email("email@email.com")
                .nickName("nickname")
                .password("123123")
                .build();
        usersRepository.save(user1);

        Users user2 = Users.builder()
                .email("email1@email.com")
                .nickName("nickname1")
                .password("123123")
                .build();
        usersRepository.save(user2);
    }

    @After
    public void tearDown() throws Exception {
        usersRepository.deleteAll();
    }

    @Test
    @Transactional
    public void save() {
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .contactType(ContactType.INSTAGRAM)
                .contactId("@insta")
                .content("content sdofisdfoisjdfoisdfisdjf")
                .title("title here")
                .build();

        Users users = usersRepository.findAll().stream()
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        Posts posts = dto.toEntity();
        users.addPost(posts);
        posts.putUser(users);
        usersRepository.save(users);


        System.out.println("element : " + users.getPostsList());
    }
}