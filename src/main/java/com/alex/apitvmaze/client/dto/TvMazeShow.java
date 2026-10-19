package com.alex.apitvmaze.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TvMazeShow(
        Double score
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Show (
        Long id,
        String url,
        String name,
        String type,
        String language,
        List<String> genres,
        String status,
        Integer runtime,
        Integer averageRuntime,
        Date premiered,
        Date ended,
        String officialSite,
        Schedule schedule,
        Rating rating,
        Integer weight,
        Network network,
        String webChannel,
        String dvdCountry,
        External external,
        Image image,
        String summary,
        Integer updated
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Schedule(
                String time,
                List<String> days
        ) {}

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Rating(
          NullPointerException average
        ) {}

        @JsonIgnoreProperties(ignoreUnknown = true)
        public  record Network(
                Long id,
                String name,
                Country country,
                String officialSite
        ) {
            @JsonIgnoreProperties(ignoreUnknown = true)
            public record Country(
                String name,
                String code,
                String timezone
            ) {}
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record External(
                NullPointerException tvrage,
                Integer thetvdb,
                NullPointerException imdb
        ){}

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Image(
                String medium,
                String original
        ){}
    }
}
