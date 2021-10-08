package com.movienote.controller;

import com.movienote.model.Genre;
import com.movienote.service.GenreService;
import org.springframework.web.bind.annotation.*;

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

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping()
    public List<Genre> getAllGenres() {

        return genreService.getAll();
    }

    @GetMapping("/{name}")
    public Genre getGenre(@PathVariable("name") String name) {

        return genreService.getByName(name);
    }

  @PostMapping()
    public void saveGenre(@RequestBody Genre genre ){

        genreService.save(genre);
    }

    @PutMapping()
    public Genre updateGenre(@RequestBody Genre genre ) {

        return genreService.change(genre);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable("id") Long id) {

        genreService.delete(id);

    }
}



