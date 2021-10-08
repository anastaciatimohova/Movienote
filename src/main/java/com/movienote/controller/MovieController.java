package com.movienote.controller;

import com.movienote.model.Movie;
import com.movienote.service.MovieServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private MovieServiceImplementation movieService;

    @GetMapping()
    public List<Movie> getAllMovies() {

        return movieService.getAll();

    }

    @GetMapping("/{title}")
    public Movie getMovie(@PathVariable("title") String title) {

        return movieService.getByTitle(title);

    }

    @PostMapping
    public void saveMovie(@RequestBody Movie movie) {

        movieService.save(movie);

    }

    @PutMapping()
    public Movie updateMovie(@RequestBody Movie movie) {

        return movieService.change(movie);

    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {

        movieService.delete(id);

    }
}


