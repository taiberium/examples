package com.example.jokerexamples.vertical.bad.car;

import org.springframework.data.annotation.Id;


public record RabbitAdapter(@Id Integer id, String model, String licensePlate) {
}
