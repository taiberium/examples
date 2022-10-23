package com.example.jokerexamples.vertical.bad.car;

import org.springframework.data.annotation.Id;


public record Car(@Id Integer id, String model, String licensePlate) {
}
