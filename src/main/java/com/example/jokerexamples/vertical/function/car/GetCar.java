package com.example.jokerexamples.vertical.function.car;

import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
interface CarRepository extends CrudRepository<Car, Integer> {
}

@Controller
public record GetCar(CarRepository carRepository) {


    @GetMapping("{id}")
    public ResponseEntity<CarDto> get(@PathVariable("id") int id) {
        return carRepository.findById(id)
                .map(car -> new CarDto(car.id(), car.model(), car.licensePlate()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

record CarDto(Integer id, String model, String licensePlate) {
}

record Car(@Id Integer id, String model, String licensePlate) {
}