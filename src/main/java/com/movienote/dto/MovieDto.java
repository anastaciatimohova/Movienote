package com.movienote.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movienote.model.Genre;
import com.movienote.model.Movie;
import com.movienote.model.User;
import com.movienote.repository.GenreJpaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDto {

    @JsonProperty("adult")
    private Boolean adult;
    @JsonProperty("poster_path")
    private String poster;
    @JsonProperty("original_language")
    private String language;
    @JsonProperty("original_title")
    private String title;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("id")
    private Long externalId;
    @JsonProperty("genre_ids")
    private List<Long> genreIds;

    @Autowired
    private GenreJpaRepository genreJpaRepository;


    public Movie toMovie(MovieDto movieDto) {

        Movie movie = new Movie();
        movie.setAdult(movieDto.getAdult());
        movie.setPoster(movieDto.getPoster());
        movie.setLanguage(movieDto.getLanguage());
        movie.setTitle(movieDto.getTitle());
        movie.setOverview(movieDto.getOverview());
        movie.setExternalId(movieDto.getExternalId());
        List<Long> genreExternalIds = movieDto.getGenreIds();
        List<Genre> genres = genreJpaRepository.findAllByExternalId(genreExternalIds);
        movie.setGenres((Set<Genre>) genres);

        return movie;
    }


    public MovieDto toDto(Movie movie) {

        MovieDto movieDto = new MovieDto();
        movieDto.setAdult(movie.getAdult());
        movieDto.setPoster(movie.getPoster());
        movieDto.setLanguage(movie.getLanguage());
        movieDto.setTitle(movie.getTitle());
        movieDto.setOverview(movie.getOverview());
        movieDto.setExternalId(movie.getExternalId());
        Set<Genre> genres = movie.getGenres();
        List<Long> genresIds = genres.stream().map(Genre::getExternalId).collect(Collectors.toList());
        movieDto.setGenreIds(genresIds);

        return movieDto;
    }

}
