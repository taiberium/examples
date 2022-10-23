package com.example.jokerexamples.vertical.bad.car;

import org.springframework.data.annotation.Id;


public record CarListener(@Id Integer id, String model, String licensePlate) {
}
