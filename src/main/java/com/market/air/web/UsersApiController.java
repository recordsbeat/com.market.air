package com.market.air.web;

import com.market.air.service.PostsService;
import com.market.air.service.UsersService;
import com.market.air.web.dto.PostsSaveRequestDto;
import com.market.air.web.dto.UsersSaveRequestDto;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UsersApiController {

    private final UsersService usersService;

    @PostMapping("/api/v1/users")
    public Long save(@RequestBody UsersSaveRequestDto requestDto) {
        return usersService.save(requestDto);
    }


    @GetMapping("/api/v1/users/checkEmail")
    public ResponseEntity<?> checkDuplicatedEmail(@RequestBody String email) throws Exception {
        ResponseEntity<?> result;
        try {
            result = new ResponseEntity<>(usersService.checkDuplicatedEmail(email), HttpStatus.OK) ;
        }
        catch(Exception e) {
            e.printStackTrace();
            result = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT) ;
        }
        return result;
    }
    @GetMapping("/api/v1/users/checkNickName")
    public ResponseEntity<?> checkDuplicatedNickName(@RequestBody String nickName) throws Exception {
        ResponseEntity<?> result;
        try {
            result = new ResponseEntity<>(usersService.checkDuplicatedNickName(nickName), HttpStatus.OK) ;
        }
        catch(Exception e) {
            e.printStackTrace();
            result = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT) ;
        }
        return result;
    }
}
