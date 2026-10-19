package com.alex.apitvmaze.mapper;

import com.alex.apitvmaze.dto.ShowSearchResponse;
import com.alex.apitvmaze.model.Show;
import org.springframework.stereotype.Component;

@Component
public class ShowMapper {

    public ShowSearchResponse toSearchResponse(Show show) {
        return new ShowSearchResponse(
                show.id(),
                show.name(),
                resolveChannel(show),
                show.summary(),
                show.genres()
        );
    }

    private String resolveChannel(Show show) {
        if (show.network() != null) {
            return show.network().name();
        }
        if (show.webChannel() != null) {
            return show.webChannel().name();
        }
        return null;
    }
}
