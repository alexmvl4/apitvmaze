package com.alex.apitvmaze.repository;

import com.alex.apitvmaze.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
