package com.alex.apitvmaze.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentRequest(
        @NotBlank(message = "el comentario es obligatorio")
        String comment,

        @NotNull(message = "la calificacion es obligatoria")
        @Min(value = 0, message = "la calificacion minima es 0")
        @Max(value = 5, message = "la calificacion maxima es 5")
        Integer rating
) {}
