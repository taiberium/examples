package com.example.jokerexamples.dataflow.good.output;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailOutput {

    private final JavaMailSender javaMailSender;
    @Value("${email.source:taiberium@mail.ru}")
    private String fromEmail;

    public void sendAlarmEmail() {
        sendEmail("example@gmail.com","ALARM","Something is broken");
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
