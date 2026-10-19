package com.alex.apitvmaze.client;

import com.alex.apitvmaze.client.dto.TvMazeSearchResult;
import com.alex.apitvmaze.model.Show;

import java.util.List;

public interface ShowClient {
    List<TvMazeSearchResult> searchShows(String query);

    Show getShowById(Long showId);
}
