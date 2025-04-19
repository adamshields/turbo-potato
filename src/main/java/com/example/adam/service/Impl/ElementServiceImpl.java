package com.example.adam.service.Impl;

import com.example.adam.dto.ElementCreateRequest;
import com.example.adam.dto.ElementVersionRequest;
import com.example.adam.dto.ElementVersionResponse;
import com.example.adam.entity.Element;
import com.example.adam.entity.ElementVersion;
import com.example.adam.repository.ElementRepository;
import com.example.adam.repository.ElementVersionRepository;
import com.example.adam.service.ElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElementServiceImpl implements ElementService {

    private final ElementRepository elementRepository;
    private final ElementVersionRepository versionRepository;

    @Override
    public Long createElement(ElementCreateRequest request) {
        Element element = new Element();
        element.setType(request.getType());
        element.setCreatedAt(LocalDateTime.now());
        element.setUpdatedAt(LocalDateTime.now());
        return elementRepository.save(element).getId();
    }

    @Override
    public ElementVersionResponse addVersion(Long elementId, ElementVersionRequest request) {
        // Get latest version number
        int nextVersion = versionRepository.findByElementIdOrderByVersionNumberDesc(elementId)
                .stream()
                .findFirst()
                .map(v -> v.getVersionNumber() + 1)
                .orElse(1);

        ElementVersion version = new ElementVersion();
        version.setElementId(elementId);
        version.setVersionNumber(nextVersion);
        version.setResourceData(request.getResourceData());
        version.setCreatedAt(LocalDateTime.now());

        ElementVersion saved = versionRepository.save(version);

        // Update current version ID on element
        Element element = elementRepository.findById(elementId)
                .orElseThrow(() -> new RuntimeException("Element not found"));
        element.setCurrentVersionId(saved.getId());
        element.setUpdatedAt(LocalDateTime.now());
        elementRepository.save(element);

        return mapToResponse(saved);
    }

    @Override
    public List<ElementVersionResponse> getAllVersions(Long elementId) {
        return versionRepository.findByElementIdOrderByVersionNumberDesc(elementId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ElementVersionResponse mapToResponse(ElementVersion version) {
        ElementVersionResponse dto = new ElementVersionResponse();
        dto.setId(version.getId());
        dto.setElementId(version.getElementId());
        dto.setVersionNumber(version.getVersionNumber());
        dto.setResourceData(version.getResourceData());
        dto.setCreatedAt(version.getCreatedAt());
        return dto;
    }
}
