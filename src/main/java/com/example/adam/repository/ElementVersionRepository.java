package com.example.adam.repository;

import com.example.adam.entity.ElementVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElementVersionRepository extends JpaRepository<ElementVersion, Long> {
    List<ElementVersion> findByElementIdOrderByVersionNumberDesc(Long elementId);
}
