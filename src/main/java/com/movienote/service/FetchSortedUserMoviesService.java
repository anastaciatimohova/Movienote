package com.movienote.service;

import com.movienote.dto.MovieDto;

import java.util.List;

public interface FetchSortedUserMoviesService {

    List<MovieDto> fetchSortedMovieByTitle(MovieDto dto);

    List<MovieDto> fetchSortedMovieByRating(MovieDto dto);

    List<MovieDto> fetchSortedMovieByStatus(MovieDto dto);

    MovieDto fetchSortedMovieByCreated(MovieDto dto);
}
