package com.ileiwe.service.mail;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("mailgun")
@Slf4j
public class MailGunEmailServiceImpl implements EmailService{

    @Value("${MAILGUN_API_KEY}")
private String API_KEY;

    @Value("${MAILGUN_SANDBOX_DOMAIN}")
    private String DOMAIN_NAME;

    @Override
    public MailResponse send(Message message) {

        try {
            HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + DOMAIN_NAME + "/messages")
                    .basicAuth("api", API_KEY)
                    .field("from", "funmibiajadi@gmail.com")
                    .field("to", "davinel.davinel@gmail.com")
                    .field("subject", "hello")
                    .field("text", "testing")
                    .asJson();

            return request.getStatus() == 200 ? new MailResponse(true):new MailResponse(false);
        } catch (UnirestException e) {
            log.info("Exception occurred -> {}",e.getMessage());
           return new MailResponse(false);
        }

        }
    }

