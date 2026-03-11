package com.example.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.backend.*;
import com.example.repository.*;

@RestController
@RequestMapping("/products")
@CrossOrigin

public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Product> list(){
        return repository.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return repository.save(product);
    }

}
