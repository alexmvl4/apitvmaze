package com.alex.apitvmaze.client.dto;

import com.alex.apitvmaze.model.Show;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TvMazeSearchResult(
        Double score,
        Show show
) {}
