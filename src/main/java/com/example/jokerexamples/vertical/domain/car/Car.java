package com.example.jokerexamples.vertical.domain.car;

import org.springframework.data.annotation.Id;


public record Car(@Id Integer id, String model, String licensePlate) {
}
