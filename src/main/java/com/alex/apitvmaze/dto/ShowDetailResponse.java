package com.alex.apitvmaze.dto;

import com.alex.apitvmaze.model.Show;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.List;

public record ShowDetailResponse(
        @JsonUnwrapped Show show,
        List<CommentResponse> comments
) {}
