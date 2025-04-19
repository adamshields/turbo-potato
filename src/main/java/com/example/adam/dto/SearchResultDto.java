package com.example.adam.dto;

import lombok.Data;

@Data
public class SearchResultDto {
    private String type;
    private Long id;
    private String label;
    private String summary;
}
