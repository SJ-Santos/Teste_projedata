package com.example.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.backend.*;
import com.example.repository.*;

@RestController
@RequestMapping("/insumes")
@CrossOrigin

public class InsumeController {

    private final InsumeRepository repository;

    public InsumeController(InsumeRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Insume> list(){
        return repository.findAll();
    }

    @PostMapping
    public Insume create(@RequestBody Insume insume){
        return repository.save(insume);
    }

}
