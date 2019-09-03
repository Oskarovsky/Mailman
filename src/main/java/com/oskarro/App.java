package com.oskarro;

import com.oskarro.bean.Mail;
import com.oskarro.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.oskarro.service.MailService;

public class App {

    public static void main(String[] args) {
        Mail mail = new Mail();
        mail.setMailFrom("oskarro@contact.com");
        mail.setMailTo("oskar.slyk@gmail.com");
        mail.setMailSubject("Spring4 - Email");
        mail.setMailContent("This is test message.");

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MailService mailService = (MailService) context.getBean("mailService");
        mailService.sendEmail(mail);
        context.close();
    }
}
