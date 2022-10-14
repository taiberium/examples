package com.example.jokerexamples.vertical.domain.car;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("{id}")
    public ResponseEntity<CarDto> get(@PathVariable("id") int id) {
        return carService.find(id)
                .map(car -> new CarDto(car.id(), car.model(), car.licensePlate()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    record CarDto(Integer id, String model, String licensePlate) {
    }
}
