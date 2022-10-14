package com.example.jokerexamples.vertical.domain.house;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository carRepository;

    public Optional<House> find(int id) {
        return carRepository.findById(id);
    }
}
