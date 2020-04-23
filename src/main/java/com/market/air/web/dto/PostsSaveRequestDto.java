package com.market.air.web.dto;

import com.market.air.domain.posts.Posts;
import com.market.air.domain.vo.ContactInfo;
import com.market.air.domain.vo.enums.ContactType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private ContactType contactType;
    private String contactId;

    @Builder
    public PostsSaveRequestDto(String title, String content, ContactType contactType, String contactId) {
        this.title = title;
        this.content = content;
        this.contactType = contactType;
        this.contactId = contactId;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .contactInfo(ContactInfo.builder().contactId(contactId).contactType(contactType).build())
                .build();
    }
}
