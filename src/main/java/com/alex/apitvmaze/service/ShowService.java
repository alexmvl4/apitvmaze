package com.alex.apitvmaze.service;

import com.alex.apitvmaze.client.ShowClient;
import com.alex.apitvmaze.client.dto.TvMazeSearchResult;
import com.alex.apitvmaze.dto.CommentResponse;
import com.alex.apitvmaze.dto.ShowSearchResponse;
import com.alex.apitvmaze.mapper.CommentMapper;
import com.alex.apitvmaze.mapper.ShowMapper;
import com.alex.apitvmaze.model.Comment;
import com.alex.apitvmaze.model.Show;
import com.alex.apitvmaze.repository.CommentRepository;
import com.alex.apitvmaze.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ShowService {
    private final ShowClient showClient;
    private final ShowMapper showMapper;
    private final ShowRepository showRepository;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public ShowService(ShowClient showClient, ShowMapper showMapper, ShowRepository showRepository,
                       CommentRepository commentRepository, CommentMapper commentMapper) {
        this.showClient = showClient;
        this.showMapper = showMapper;
        this.showRepository = showRepository;
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public List<ShowSearchResponse> searchShows(String searchQuery) {
        if (searchQuery == null || searchQuery.isBlank()) {
            throw new IllegalArgumentException("El parametro search_query no puede estar vacio");
        }

        List<Show> shows = showClient.searchShows(searchQuery.trim()).stream()
                .map(TvMazeSearchResult::show)
                .filter(Objects::nonNull)
                .toList();

        Map<Long, List<CommentResponse>> commentsByShow = findCommentsByShowIds(
                shows.stream().map(Show::id).toList());

        return shows.stream()
                .map(show -> showMapper.toSearchResponse(show, commentsByShow.getOrDefault(show.id(), List.of())))
                .toList();
    }

    public Show getShowById(Long showId) {
        if (showId == null || showId <= 0) {
            throw new IllegalArgumentException("El parametro show_id debe ser un numero mayor a cero");
        }

        return showRepository.findById(showId)
                .orElseGet(() -> showRepository.save(showClient.getShowById(showId)));
    }

    private Map<Long, List<CommentResponse>> findCommentsByShowIds(List<Long> showIds) {
        if (showIds.isEmpty()) {
            return Map.of();
        }

        return commentRepository.findByShowIdIn(showIds).stream()
                .collect(Collectors.groupingBy(
                        Comment::showId,
                        Collectors.mapping(commentMapper::toResponse, Collectors.toList())));
    }
}
