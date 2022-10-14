package com.example.jokerexamples.vertical.domain.human;

import org.springframework.data.annotation.Id;


public record Human(@Id Integer id, String name) {
}
