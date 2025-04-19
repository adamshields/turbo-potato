package com.example.adam.service;

import com.example.adam.dto.SearchResultDto;

import java.util.List;

public interface SearchService {
    List<SearchResultDto> search(String keyword);
    void index(String type, Long refId, String label, String summary, String rawContent);
}
