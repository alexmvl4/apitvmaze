package com.alex.apitvmaze.dto;

import java.time.LocalDate;
import java.util.List;

public record ShowSearchResponse(
        Double score,
        Show show
) {
    public record Show(
            Long id,
            String name,
            String type,
            String language,
            List<String> genres,
            String status,
            LocalDate premiered,
            Double rating,
            String image,
            String summary
    ) {}
}
