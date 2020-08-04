package com.creativity.registrymicroservice.controller;

import com.creativity.registrymicroservice.dto.ContactDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class RestExampleController {

    @GetMapping("/check-rest")
    public ResponseEntity<ContactDto> checkRest(){
        ContactDto contactDto = new ContactDto(1, "Hansel", "Liverty", "999999540", "Lima");
        return new ResponseEntity<ContactDto>(contactDto, HttpStatus.OK);
    }
}
