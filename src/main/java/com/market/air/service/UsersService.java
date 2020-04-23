package com.market.air.service;

import com.market.air.domain.user.UsersRepository;
import com.market.air.web.dto.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional(rollbackFor = Exception.class)
    public Long save(UsersSaveRequestDto requestDto){
        if(!checkDuplicatedEmail(requestDto.getEmail()))
            throw new IllegalArgumentException(String.format("email=[%s]가 중복됩니다.",requestDto.getEmail()));

        if(!checkDuplicatedNickName(requestDto.getNickName()))
            throw new IllegalArgumentException(String.format("nickName=[%s]가 중복됩니다.",requestDto.getNickName()));

        return usersRepository.save(requestDto.toEntity()).getId();
    }

    public boolean checkDuplicatedEmail(String email){
        return usersRepository.findAll().stream()
                .noneMatch(x -> x.checkDuplicatedEmail(email));
    }


    public boolean checkDuplicatedNickName(String nickName){
        return usersRepository.findAll().stream()
                .noneMatch(x -> x.checkDuplicatedNickName(nickName));
    }
}
