package com.example.jokerexamples.vertical.function.human;

import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
interface HumanRepository extends CrudRepository<Human, Integer> {
}

@Controller
public record GetHuman(HumanRepository humanRepository) {


    @GetMapping("{id}")
    public ResponseEntity<HumanDto> get(@PathVariable("id") int id) {
        return humanRepository.findById(id)
                .map(human -> new HumanDto(human.id(), human.name()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

record HumanDto(Integer id, String name) {
}

record Human(@Id Integer id, String name) {
}