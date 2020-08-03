package com.creativity.registrymicroservice.component;

import com.creativity.registrymicroservice.dto.ContactDto;
import com.creativity.registrymicroservice.entity.ContactEntity;
import org.springframework.stereotype.Component;

@Component("contactConverter")
public class ContactConverter {

    public ContactEntity convertContactDtoToContactEntity(ContactDto contactDto){
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setId(contactDto.getId());
        contactEntity.setFirstName(contactDto.getFirstName());
        contactEntity.setLastName(contactDto.getLastName());
        contactEntity.setTelephone(contactDto.getTelephone());
        contactEntity.setCity(contactDto.getCity());
        return contactEntity;
    }

    public ContactDto convertContactEntityToContactDto(ContactEntity contactEntity){
        ContactDto contactDto = new ContactDto();
        contactDto.setId(contactEntity.getId());
        contactDto.setFirstName(contactEntity.getFirstName());
        contactDto.setLastName(contactEntity.getLastName());
        contactDto.setTelephone(contactEntity.getTelephone());
        contactDto.setCity(contactEntity.getCity());
        return contactDto;
    }
}
