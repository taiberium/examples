package com.example.jokerexamples.vertical.domain.human;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HumanService {

    private final HouseRepository carRepository;

    public Optional<Human> find(int id) {
        return carRepository.findById(id);
    }
}
