package com.example.adam.service;

import com.example.adam.dto.SearchRequestDto;
import com.example.adam.dto.SearchResultDto;

import java.util.List;

public interface SearchService {
    List<SearchResultDto> search(SearchRequestDto request);
    void index(String type, Long refId, String label, String summary, String rawContent);
}
