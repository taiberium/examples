package com.example.jokerexamples.horizontal.bad.service;


import com.example.jokerexamples.horizontal.bad.model.Car;
import com.example.jokerexamples.horizontal.bad.model.Human;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;

public class RabbitAdapter {

    @RabbitListener(queues = "human")
    @SendTo("exchange/car")
    public Car listen(Human human){
        return new Car(human.id(),"model","license");
    }
}
