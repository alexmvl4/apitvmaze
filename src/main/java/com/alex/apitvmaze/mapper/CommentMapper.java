package com.alex.apitvmaze.mapper;

import com.alex.apitvmaze.dto.CommentResponse;
import com.alex.apitvmaze.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentResponse toResponse(Comment comment) {
        return new CommentResponse(comment.comment(), comment.rating());
    }
}
