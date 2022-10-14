package com.example.jokerexamples.vertical.domain.house;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("houses")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService carService;

    @GetMapping("{id}")
    public ResponseEntity<HouseDto> get(@PathVariable("id") int id) {
        return carService.find(id)
                .map(house -> new HouseDto(house.id(), house.address()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    record HouseDto(Integer id, String address) {
    }
}
