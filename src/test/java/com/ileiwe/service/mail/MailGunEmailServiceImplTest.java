package com.ileiwe.service.mail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MailGunEmailServiceImplTest {
    @Autowired
    @Qualifier("mailgun")
    EmailService emailService;

    @BeforeEach
    void setUp() {
    }
    @Test
    void sendEmailWithMailGunTest(){
        Message mail = Message.builder().
                       from("").
                        to("").
                        subject("Test Email")
                        .body("This is the body of my test email").
                        build();
        MailResponse response = emailService.send(mail);
   assertTrue(response.isSuccessful());

    }

    @AfterEach
    void tearDown() {
    }
}