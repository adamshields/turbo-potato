package com.example.adam.service.impl;

import com.example.adam.dto.SearchRequestDto;
import com.example.adam.dto.SearchResultDto;
import com.example.adam.entity.SearchIndex;
import com.example.adam.repository.SearchIndexRepository;
import com.example.adam.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final SearchIndexRepository repository;
    @Override
    public List<SearchResultDto> search(SearchRequestDto request) {
        String query = request.getQuery();

        return repository.findByRawContentContainingIgnoreCase(query)
                .stream()
                .map(index -> {
                    SearchResultDto dto = new SearchResultDto();
                    dto.setId(index.getReferenceId());
                    dto.setType(index.getReferenceType());
                    dto.setLabel(index.getLabel());
                    dto.setSummary(index.getSummary());
                    return dto;
                })
                .collect(Collectors.toList());
    }


//    @Override
//    public List<SearchResultDto> search(String keyword) {
//        return repository.findByRawContentContainingIgnoreCase(keyword)
//                .stream()
//                .map(index -> {
//                    SearchResultDto dto = new SearchResultDto();
//                    dto.setId(index.getReferenceId());
//                    dto.setType(index.getReferenceType());
//                    dto.setLabel(index.getLabel());
//                    dto.setSummary(index.getSummary());
//                    return dto;
//                })
//                .collect(Collectors.toList());
//    }

    @Override
    public void index(String type, Long refId, String label, String summary, String rawContent) {
        SearchIndex index = new SearchIndex();
        index.setReferenceType(type);
        index.setReferenceId(refId);
        index.setLabel(label);
        index.setSummary(summary);
        index.setRawContent(rawContent);
        index.setCreatedAt(LocalDateTime.now());
        repository.save(index);
    }
}
