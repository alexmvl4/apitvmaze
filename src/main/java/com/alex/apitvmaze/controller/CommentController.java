package com.alex.apitvmaze.controller;

import com.alex.apitvmaze.dto.CommentRequest;
import com.alex.apitvmaze.dto.StatusResponse;
import com.alex.apitvmaze.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows/{show_id}/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<StatusResponse> saveComment(
            @PathVariable("show_id") Long showId,
            @Valid @RequestBody CommentRequest request) {
        commentService.saveComment(showId, request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new StatusResponse(HttpStatus.CREATED.value(), "Comentario guardado correctamente"));
    }
}
