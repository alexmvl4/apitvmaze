package com.alex.apitvmaze.repository;

import com.alex.apitvmaze.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByShowId(Long showId);

    List<Comment> findByShowIdIn(Collection<Long> showIds);
}
