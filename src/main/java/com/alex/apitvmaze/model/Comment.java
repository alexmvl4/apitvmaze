package com.alex.apitvmaze.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "comments")
public record Comment(
        @Id String id,
        Long showId,
        String comment,
        Integer rating,
        LocalDateTime createdAt
) {}
