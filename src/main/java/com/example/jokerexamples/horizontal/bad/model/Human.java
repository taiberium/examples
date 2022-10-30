package com.example.jokerexamples.horizontal.bad.model;

import org.springframework.data.annotation.Id;


public record Human(@Id Integer id, String name) {
}
