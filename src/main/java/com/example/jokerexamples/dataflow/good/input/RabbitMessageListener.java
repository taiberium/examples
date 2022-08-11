package com.example.jokerexamples.dataflow.good.input;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMessageListener {

    @RabbitListener
    public void listen(){}
}
