package com.movienote.controller;

import com.movienote.model.Genre;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер для сущности Genre
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@RestController
@RequestMapping("/genre")
public class GenreController {

    @GetMapping()
    public List<Genre> getAllGenres() {

        List<Genre> genres = new ArrayList<>();

        return genres;
    }

    @GetMapping("/{name}")
    public Genre getGenre(@PathVariable("name") String name) {

        Genre genre = new Genre();

        return genre;
    }

    @PostMapping()
    public void saveGenre(@RequestBody Genre genre ){

    }

    @PutMapping("/{id}/{name}")
    public Genre updateGenre(@PathVariable("id") Long id, @PathVariable("name") String name ) {

        Genre genre = new Genre();

        return genre;
    }

    @DeleteMapping("/{name}")

    public void deleteGenre(@PathVariable("name") String name) {

    }
}



