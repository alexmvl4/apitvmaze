package com.alex.apitvmaze.service;

import com.alex.apitvmaze.client.ShowClient;
import com.alex.apitvmaze.client.dto.TvMazeSearchResult;
import com.alex.apitvmaze.dto.ShowSearchResponse;
import com.alex.apitvmaze.mapper.ShowMapper;
import com.alex.apitvmaze.model.Show;
import com.alex.apitvmaze.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ShowService {
    private final ShowClient showClient;
    private final ShowMapper showMapper;
    private final ShowRepository showRepository;

    public ShowService(ShowClient showClient, ShowMapper showMapper, ShowRepository showRepository) {
        this.showClient = showClient;
        this.showMapper = showMapper;
        this.showRepository = showRepository;
    }

    public List<ShowSearchResponse> searchShows(String searchQuery) {
        if (searchQuery == null || searchQuery.isBlank()) {
            throw new IllegalArgumentException("El parametro search_query no puede estar vacio");
        }

        return showClient.searchShows(searchQuery.trim()).stream()
                .map(TvMazeSearchResult::show)
                .filter(Objects::nonNull)
                .map(showMapper::toSearchResponse)
                .toList();
    }

    public Show getShowById(Long showId) {
        if (showId == null || showId <= 0) {
            throw new IllegalArgumentException("El parametro show_id debe ser un numero mayor a cero");
        }

        return showRepository.findById(showId)
                .orElseGet(() -> showRepository.save(showClient.getShowById(showId)));
    }
}
