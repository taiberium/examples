package com.example.jokerexamples.vertical.bad.car;

import com.example.jokerexamples.vertical.domain.car.Car;
import com.example.jokerexamples.vertical.domain.car.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Optional<Car> find(int id) {
        return carRepository.findById(id);
    }
}
