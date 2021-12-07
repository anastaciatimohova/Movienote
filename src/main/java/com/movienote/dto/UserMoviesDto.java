package com.movienote.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.movienote.model.Movie;
import com.movienote.model.Status;
import com.movienote.model.User;
import com.movienote.model.UserMovies;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMoviesDto {

    private String description;

    private Integer rating;

    private Status status;


    public UserMovies toUserMovies(User user, Movie movie, UserMoviesDto userMoviesDto) {

        UserMovies userMovies = new UserMovies();
        userMovies.setUser(user);
        userMovies.setMovie(movie);
        userMovies.setDescription(userMoviesDto.getDescription());
        userMovies.setRating(userMoviesDto.getRating());
        userMovies.setStatus(userMoviesDto.getStatus());
        return userMovies;
    }

    public UserMoviesDto toDto(UserMovies userMovies) {

        UserMoviesDto userMoviesDto = new UserMoviesDto();
        userMoviesDto.setDescription(userMovies.getDescription());
        userMoviesDto.setRating(userMovies.getRating());
        userMoviesDto.setStatus(userMovies.getStatus());
        return userMoviesDto;
    }
}
