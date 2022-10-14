package com.example.jokerexamples.vertical.domain.human;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("human")
@RequiredArgsConstructor
public class HumanController {

    private final HumanService carService;

    @GetMapping("{id}")
    public ResponseEntity<HumanDto> get(@PathVariable("id") int id){
        return carService.find(id)
                .map(human -> new HumanDto(human.id(), human.name()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    record HumanDto(Integer id, String address) {
    }
}
