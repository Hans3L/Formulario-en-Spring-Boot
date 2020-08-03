package com.creativity.registrymicroservice.service;

import com.creativity.registrymicroservice.dto.ContactDto;
import com.creativity.registrymicroservice.entity.ContactEntity;

import java.util.List;

public interface ContactService {

    public abstract ContactDto addContact(ContactDto contactDto);

    public abstract List<ContactDto> listContact();

    public abstract ContactDto updateContact(ContactDto contactDto);

    public abstract ContactEntity findContactById(int id);

    public abstract void removeContact(int id);

    public abstract ContactDto findContactByIdContactDto(int id);
}
