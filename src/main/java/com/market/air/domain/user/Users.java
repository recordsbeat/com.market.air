package com.market.air.domain.user;

import com.market.air.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ToString(exclude = "postsList")
@Getter
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nickName;

    @Column
    private String password;

    @Column
    private String email;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Posts> postsList = new ArrayList<>();

    @Builder
    public Users(Long id, String nickName, String password, String email) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }


    public boolean checkDuplicatedEmail(String email) {
        return this.email.equals(email);
    }
    public boolean checkDuplicatedNickName(String nickName) {
        return this.nickName.equals(nickName);
    }

    public void addPost(Posts post){
        this.postsList.add(post);
    }
}
