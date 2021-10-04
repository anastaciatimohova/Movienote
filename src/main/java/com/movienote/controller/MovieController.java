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

    @GetMapping("/{title_Movie}")
    public Movie getMovie(@PathVariable("title_Movie") String title) {

        Movie movie = new Movie();

        return movie;
    }

    @PostMapping
    public void saveMovie(@RequestBody Movie movie) {

    }

    @PutMapping()
    public Movie updateMovie(@RequestBody Movie movie) {

        return movie;

    }

    @DeleteMapping("/{id}")

    public void deleteMovie(@PathVariable("id") Long id) {

    }
}


