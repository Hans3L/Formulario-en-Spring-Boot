package com.creativity.registrymicroservice.service;

import com.creativity.registrymicroservice.component.ContactConverter;
import com.creativity.registrymicroservice.dto.ContactDto;
import com.creativity.registrymicroservice.entity.ContactEntity;
import com.creativity.registrymicroservice.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("ContactService")
public class ContactServiceImp implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    public ContactDto addContact(ContactDto contactDto) {
        ContactEntity contactEntity = contactRepository.save(contactConverter.convertContactDtoToContactEntity(contactDto));
        return contactConverter.convertContactEntityToContactDto(contactEntity);
    }

    public List<ContactDto> listContact() {
        List<ContactEntity> contactEntities = contactRepository.findAll();
        List<ContactDto> contactDtos = new ArrayList<>();
        for (ContactEntity contactEntity : contactEntities)
            contactDtos.add(contactConverter.convertContactEntityToContactDto(contactEntity));
        return contactDtos;
    }

    public ContactDto updateContact(ContactDto contactDto) {
        ContactEntity contactEntity = contactRepository
                .save(contactConverter.convertContactDtoToContactEntity(contactDto));
        return contactConverter.convertContactEntityToContactDto(contactEntity);
    }

    public ContactEntity findContactById(int id) {
        return contactRepository.findById(id);
    }

    public ContactDto findContactByIdContactDto(int id){
        return contactConverter.convertContactEntityToContactDto(findContactById(id));
    }

    public void removeContact(int id) {
        ContactEntity contactEntity = findContactById(id);
        if (contactEntity != null) {
            contactRepository.delete(contactEntity);
        }

    }

}
