package com.alex.apitvmaze.repository;

import com.alex.apitvmaze.model.Show;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShowRepository extends MongoRepository<Show, Long> {
}
