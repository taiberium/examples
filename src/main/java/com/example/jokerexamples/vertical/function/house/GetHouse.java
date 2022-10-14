package com.example.jokerexamples.vertical.function.house;

import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Repository
interface HouseRepository extends CrudRepository<House, Integer> {
}

@Controller
public record GetHouse(HouseRepository houseRepository) {


    @GetMapping("{id}")
    public ResponseEntity<HouseDto> get(@PathVariable("id") int id) {
        return houseRepository.findById(id)
                .map(house -> new HouseDto(house.id(), house.address()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

record HouseDto(Integer id, String address) {
}

record House(@Id Integer id, String address) {
}
