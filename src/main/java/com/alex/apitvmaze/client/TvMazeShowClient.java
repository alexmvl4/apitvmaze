package com.alex.apitvmaze.client;

import com.alex.apitvmaze.client.dto.TvMazeShow;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TvMazeShowClient implements ShowClient {
    private final ApiClient apiClient;

    public TvMazeShowClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public List<TvMazeShow> searchShows(String query) {
        List<TvMazeShow> results = apiClient.get(
                "/search/shows",
                Map.of("q", query),
                new ParameterizedTypeReference<List<TvMazeShow>>() {});

        return results != null ? results : List.of();
    }
}
