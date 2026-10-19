package com.alex.apitvmaze.mapper;

import com.alex.apitvmaze.client.dto.TvMazeShow;
import com.alex.apitvmaze.dto.ShowSearchResponse;
import org.springframework.stereotype.Component;

@Component
public class ShowMapper {

    public ShowSearchResponse toSearchResponse(TvMazeShow.Show show) {
        return new ShowSearchResponse(
                show.id(),
                show.name(),
                resolveChannel(show),
                show.summary(),
                show.genres()
        );
    }

    private String resolveChannel(TvMazeShow.Show show) {
        if (show.network() != null) {
            return show.network().name();
        }
        if (show.webChannel() != null) {
            return show.webChannel().name();
        }
        return null;
    }
}
