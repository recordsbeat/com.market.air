package com.market.air.service;

import com.market.air.domain.user.Users;
import com.market.air.domain.user.UsersRepository;
import com.market.air.web.dto.UsersSaveRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersServiceTest {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersService usersService;

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
    public void save() throws Exception{
        UsersSaveRequestDto dto = UsersSaveRequestDto.builder()
                .email("email@email.coma")
                .nickName("123")
                .build();

        Long id = usersService.save(dto);

        Users user = usersRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다. id =" + id));
        System.out.println("element" + user);

        /*
        usersRepository.findAll().stream()
               .forEach(x-> System.out.println("element" + x));
         */
    }

    @Test
    @Ignore
    public void checkDuplicatedEmail() {
        System.out.println("checkduplemail : " + usersService.checkDuplicatedEmail("email@email.com"));
    }

    @Test
    @Ignore
    public void checkDuplicatedNickName() {
        System.out.println("checkduplemail : " + usersService.checkDuplicatedNickName("nickName"));
    }
}