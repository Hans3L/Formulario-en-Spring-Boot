package com.creativity.registrymicroservice.controller;

import com.creativity.registrymicroservice.dto.ContactDto;
import com.creativity.registrymicroservice.service.ContactService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.creativity.registrymicroservice.util.Contants.CONTACTS;
import static com.creativity.registrymicroservice.util.Contants.CONTACT_FORM;

@Controller
@RequestMapping("/contact")
public class ContactController {

    Logger LOGGER = LogManager.getLogger(ContactController.class);

    @Autowired
    @Qualifier("ContactService")
    private ContactService contactService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/cancel")
    public String cancel(){
        return "redirect:/contact/show-contact";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/contact-form")
    public String redirectContactForm(@RequestParam(name = "id", required= false) int id, //el id no puede ser null por required
            Model model){
        ContactDto contactDto = new ContactDto();
        if (id != 0){
            contactDto = contactService.findContactByIdContactDto(id);
        }
        model.addAttribute("contactDto", contactDto);
        return CONTACT_FORM;
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/add-contact")
    public String addContact(@ModelAttribute(name = "contactDto") ContactDto contactDto, Model model){
        LOGGER.info("ENTERING METHOD: addContact() -- PARAMS: ContactDto: " + contactDto.toString() );

        if(contactService.addContact(contactDto) != null){
            model.addAttribute("result", 1);
        }else {
            model.addAttribute("result", 0);
        }
        return "redirect:/contact/show-contact";
    }

    @GetMapping("/show-contact")
    public ModelAndView showContact(){
        ModelAndView mav = new ModelAndView(CONTACTS);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername());
        mav.addObject("contacts", contactService.listContact());
        return mav;
    }

    @GetMapping("/remove-contact")
    public ModelAndView removeContact(@RequestParam(name = "id", required= true) int id){
        contactService.removeContact(id);
        return showContact();
    }

}
