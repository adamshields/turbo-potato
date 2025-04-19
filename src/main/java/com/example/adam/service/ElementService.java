package com.example.adam.service;

import com.example.adam.dto.ElementCreateRequest;
import com.example.adam.dto.ElementVersionRequest;
import com.example.adam.dto.ElementVersionResponse;

import java.util.List;

public interface ElementService {
    Long createElement(ElementCreateRequest request);
    ElementVersionResponse addVersion(Long elementId, ElementVersionRequest request);
    List<ElementVersionResponse> getAllVersions(Long elementId);
}
