package com.alex.apitvmaze.client;

import com.alex.apitvmaze.client.dto.TvMazeSearchResult;

import java.util.List;

public interface ShowClient {
    List<TvMazeSearchResult> searchShows(String query);
}
