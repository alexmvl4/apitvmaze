package com.alex.apitvmaze.client;

import com.alex.apitvmaze.client.dto.TvMazeShow;

import java.util.List;

public interface ShowClient {
    List<TvMazeShow> searchShows(String query);
}
