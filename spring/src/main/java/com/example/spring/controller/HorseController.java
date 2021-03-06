package com.example.spring.controller;

import com.example.spring.entity.Horses;
import com.example.spring.exception.HorseNotFoundException;
import com.example.spring.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/horses")
public class HorseController {

    @Autowired
    private HorseService horseService;

    @PostMapping
    public ResponseEntity addHorse(@RequestBody Horses horse){
        try {
            horseService.addHorse(horse);
            return ResponseEntity.ok("Horse successfully added!!!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Horse add error");
        }
    }

    @GetMapping
    public ResponseEntity getHorses(){
        try {
            return ResponseEntity.ok(horseService.getHorses());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
