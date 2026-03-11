package com.example.backend;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double value;

    @ManyToMany
    private List<Insume> insumes;

    public Product(Long id, String name, Double value, List<Insume> insumes) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.insumes = insumes;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public List<Insume> getInsumes() {
        return insumes;
    }
    public void setInsumes(List<Insume> insumes) {
        this.insumes = insumes;
    }
}
