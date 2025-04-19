package com.example.adam.repository;

import com.example.adam.entity.SearchIndex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchIndexRepository extends JpaRepository<SearchIndex, Long> {
    List<SearchIndex> findByRawContentContainingIgnoreCase(String keyword);
}
