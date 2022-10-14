package com.example.jokerexamples.horizontal_v2.good.service;

import com.example.jokerexamples.horizontal_v2.good.output.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailSender emailSender;

    public void sendAlarmEmail() {
        emailSender.sendEmail("example@gmail.com","ALARM","Something is broken");
    }
}
