package com.example.adam.repository;


import com.example.adam.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<Element, Long> {
    // Optional: Add custom methods like findByType if needed
}
