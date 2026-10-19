package com.alex.apitvmaze.mapper;

import com.alex.apitvmaze.client.dto.TvMazeShow;
import com.alex.apitvmaze.dto.ShowSearchResponse;
import org.springframework.stereotype.Component;

@Component
public class ShowMapper {

    public ShowSearchResponse toSearchResponse(TvMazeShow result) {
        return new ShowSearchResponse(
                result.score(),
                toShow(result.show())
        );
    }

    public ShowSearchResponse.Show toShow(TvMazeShow.Show show) {
        return new ShowSearchResponse.Show(
                show.id(),
                show.name(),
                show.type(),
                show.language(),
                show.genres(),
                show.status(),
                show.premiered(),
                show.rating() != null ? show.rating().average() : null,
                show.image() != null ? show.image().medium() : null,
                show.summary()
        );
    }
}
