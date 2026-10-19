package com.alex.apitvmaze.service;

import com.alex.apitvmaze.dto.CommentRequest;
import com.alex.apitvmaze.model.Comment;
import com.alex.apitvmaze.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ShowService showService;

    public CommentService(CommentRepository commentRepository, ShowService showService) {
        this.commentRepository = commentRepository;
        this.showService = showService;
    }

    public Comment saveComment(Long showId, CommentRequest request) {
        showService.getShowById(showId);

        Comment comment = new Comment(
                null,
                showId,
                request.comment().trim(),
                request.rating(),
                LocalDateTime.now()
        );
        return commentRepository.save(comment);
    }
}
