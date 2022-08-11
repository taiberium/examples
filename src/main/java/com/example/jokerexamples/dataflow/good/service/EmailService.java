package com.example.jokerexamples.dataflow.good.service;

import com.example.jokerexamples.dataflow.good.output.EmailSender;
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
