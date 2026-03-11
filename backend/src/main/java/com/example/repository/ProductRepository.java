package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.*;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
