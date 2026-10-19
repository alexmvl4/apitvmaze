package com.alex.apitvmaze.client;

import com.alex.apitvmaze.client.dto.TvMazeSearchResult;
import com.alex.apitvmaze.model.Show;
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
    public List<TvMazeSearchResult> searchShows(String query) {
        List<TvMazeSearchResult> results = apiClient.get(
                "/search/shows",
                Map.of("q", query),
                new ParameterizedTypeReference<List<TvMazeSearchResult>>() {});

        return results != null ? results : List.of();
    }

    @Override
    public Show getShowById(Long showId) {
        return apiClient.get(
                "/shows/" + showId,
                Map.of(),
                new ParameterizedTypeReference<Show>() {});
    }
}
