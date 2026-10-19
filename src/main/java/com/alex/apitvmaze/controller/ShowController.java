package com.alex.apitvmaze.controller;

import com.alex.apitvmaze.dto.ShowSearchResponse;
import com.alex.apitvmaze.model.Show;
import com.alex.apitvmaze.service.ShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {
    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/search")
    public List<ShowSearchResponse> search(@RequestParam("search_query") String searchQuery) {
        return showService.searchShows(searchQuery);
    }

    @GetMapping("/{show_id}")
    public Show getShow(@PathVariable("show_id") Long showId) {
        return showService.getShowById(showId);
    }
}
