package com.market.air.domain.vo;

import com.market.air.domain.vo.enums.ContactType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@Embeddable
public class ContactInfo {
    @Enumerated(EnumType.STRING)
    private ContactType contactType;
    private String contactId;

    @Builder
    public ContactInfo(ContactType contactType, String contactId) {
        this.contactType = contactType;
        this.contactId = contactId;
    }


}
