package com.ileiwe.service.event;

import com.ileiwe.service.mail.EmailService;
import com.ileiwe.service.mail.Message;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.validation.constraints.Email;
import java.util.UUID;

@Component
@Slf4j
public class ApplicationEventListener {
    @Autowired
    EmailService emailService;

    @Autowired
    TemplateEngine templateEngine;

    @EventListener
    public void handleRegistrationCompleteEvent(OnRegistrationCompleteEvent onRegistrationCompleteEvent){
        confirmRegistration(onRegistrationCompleteEvent);

    }
private void confirmRegistration(
        OnRegistrationCompleteEvent event){
//        String verificationToken = UUID.randomUUID().toString();
    Message message = Message.builder().from("funmibiajadi@gmail.com").to(event.getAppUser().getEmail()).
            subject("confirmation email").body(templateEngine.process("confirmation.html",
                    new Context())).build();
    emailService.send(message);

}
}
