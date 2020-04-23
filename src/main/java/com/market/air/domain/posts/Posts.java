package com.market.air.domain.posts;

import com.market.air.domain.user.Users;
import com.market.air.domain.vo.ContactInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String content;

    @ManyToOne
    private Users users;

    @Embedded
    private ContactInfo contactInfo;


    @Builder
    public Posts(Long id, String title, String content, ContactInfo contactInfo) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.contactInfo = contactInfo;
    }

    public void putUser(Users users){
        this.users = users;
    }
}
