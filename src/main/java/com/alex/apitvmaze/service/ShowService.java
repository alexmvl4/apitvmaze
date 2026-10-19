package com.alex.apitvmaze.service;

import com.alex.apitvmaze.client.ShowClient;
import com.alex.apitvmaze.dto.ShowSearchResponse;
import com.alex.apitvmaze.mapper.ShowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    private final ShowClient showClient;
    private final ShowMapper showMapper;

    public ShowService(ShowClient showClient, ShowMapper showMapper) {
        this.showClient = showClient;
        this.showMapper = showMapper;
    }

    public List<ShowSearchResponse> searchShows(String searchQuery) {
        if (searchQuery == null || searchQuery.isBlank()) {
            throw new IllegalArgumentException("El parametro search_query no puede estar vacio");
        }

        return showClient.searchShows(searchQuery.trim()).stream()
                .filter(result -> result.show() != null)
                .map(showMapper::toSearchResponse)
                .toList();
    }
}
