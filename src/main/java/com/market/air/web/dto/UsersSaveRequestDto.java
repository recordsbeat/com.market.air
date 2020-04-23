package com.market.air.web.dto;

import com.market.air.domain.user.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
    private  String email;
    private  String password;
    private  String nickName;

    @Builder
    public UsersSaveRequestDto(String email, String password, String nickName) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
    }

    public Users toEntity(){
        return Users.builder()
                .email(email)
                .nickName(nickName)
                .password(password)
                .build();
    }
}
