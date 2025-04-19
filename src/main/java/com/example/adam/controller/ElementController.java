package com.example.adam.controller;

import com.example.adam.dto.ElementCreateRequest;
import com.example.adam.dto.ElementVersionRequest;
import com.example.adam.dto.ElementVersionResponse;
import com.example.adam.service.ElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elements")
@RequiredArgsConstructor
public class ElementController {

    private final ElementService elementService;

    @PostMapping
    public ResponseEntity<Long> createElement(@RequestBody ElementCreateRequest request) {
        Long id = elementService.createElement(request);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/{elementId}/versions")
    public ResponseEntity<ElementVersionResponse> addVersion(
            @PathVariable Long elementId,
            @RequestBody ElementVersionRequest request) {
        return ResponseEntity.ok(elementService.addVersion(elementId, request));
    }

    @GetMapping("/{elementId}/versions")
    public ResponseEntity<List<ElementVersionResponse>> getVersions(@PathVariable Long elementId) {
        return ResponseEntity.ok(elementService.getAllVersions(elementId));
    }
}
