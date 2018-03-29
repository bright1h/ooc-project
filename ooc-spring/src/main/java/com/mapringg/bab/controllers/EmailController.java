package com.mapringg.bab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mapring
 */
@Controller
@RequestMapping("/api/email")
public class EmailController {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailController(@Qualifier("mailConfiguration") JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    // TODO (1) Change to @PostMapping and use JsonObject to convert the incoming json to String
    @GetMapping
    public void sendSimpleMessage(
            String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println("sendSimpleMessage");
        message.setTo("trainer.mapring@icloud.com");
        message.setSubject("test");
        message.setText("test");
        emailSender.send(message);
    }
}
