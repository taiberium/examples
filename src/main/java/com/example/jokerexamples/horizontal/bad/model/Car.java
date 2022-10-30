package com.example.jokerexamples.horizontal.bad.model;

import org.springframework.data.annotation.Id;


public record Car(@Id Integer id, String model, String licensePlate) {
}
