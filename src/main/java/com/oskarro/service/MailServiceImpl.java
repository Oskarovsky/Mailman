package com.oskarro.service;

import com.oskarro.bean.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getMailFrom());
        message.setTo(mail.getMailTo());
        message.setSubject(mail.getMailSubject());
        message.setText(mail.getMailContent());
        mailSender.send(message);
    }
}
