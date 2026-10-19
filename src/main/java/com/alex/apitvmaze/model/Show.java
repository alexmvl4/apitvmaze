package com.alex.apitvmaze.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Show(
        Long id,
        String url,
        String name,
        String type,
        String language,
        List<String> genres,
        String status,
        Integer runtime,
        Integer averageRuntime,
        LocalDate premiered,
        LocalDate ended,
        String officialSite,
        Schedule schedule,
        Rating rating,
        Integer weight,
        Network network,
        Network webChannel,
        Network.Country dvdCountry,
        Externals externals,
        Image image,
        String summary,
        Long updated
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Schedule(
            String time,
            List<String> days
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Rating(
            Double average
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Network(
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
    public record Externals(
            Integer tvrage,
            Integer thetvdb,
            String imdb
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Image(
            String medium,
            String original
    ) {}
}
