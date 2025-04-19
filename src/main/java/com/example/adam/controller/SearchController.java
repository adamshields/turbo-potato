package com.example.adam.controller;

import com.example.adam.dto.SearchRequestDto;
import com.example.adam.dto.SearchResultDto;
import com.example.adam.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

//    @GetMapping
//    public ResponseEntity<List<SearchResultDto>> search(@RequestParam String q) {
//        return ResponseEntity.ok(searchService.search(q));
//    }

    @PostMapping("/search")
    public ResponseEntity<List<SearchResultDto>> search(@RequestBody SearchRequestDto request) {
        return ResponseEntity.ok(searchService.search(request));
    }

}
