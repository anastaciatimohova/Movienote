package com.movienote.controller;

import com.movienote.model.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер для сущности Movie
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@RestController
@RequestMapping("/movie")
public class MovieController {

    @GetMapping()
    public List<Movie> getAllMovies() {

        List<Movie> movies = new ArrayList<>();

        return movies;
    }

    @GetMapping("/{titleMovie}")
    public Movie getMovie(@PathVariable("titleMovie") String title) {

        Movie movie = new Movie();

        return movie;
    }

    @PostMapping
    public Movie saveMovie(@RequestBody Movie movie) {

        return movie;

    }

    @PatchMapping("/{externalId}")
    public Movie updateMovie(@PathVariable("externalId") Long externalId) {

        Movie movie = new Movie();

        return movie;
    }

    @DeleteMapping("/{id}")

    public void deleteMovie(@PathVariable("id") Long id) {

    }
}


