package com.example.jokerexamples.vertical.domain.house;

import org.springframework.data.annotation.Id;


public record House(@Id Integer id, String address) {
}
