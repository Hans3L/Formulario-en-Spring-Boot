package com.creativity.registrymicroservice.component;

import com.creativity.registrymicroservice.controller.ContactController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskComponent {

    Logger LOGGER = LogManager.getLogger(ContactController.class);

    @Scheduled(fixedDelay = 5000)
    public void doTask(){
        LOGGER.info("TIME IS: " + new Date());
    }
}
