package com.movienote.service;


import com.movienote.model.Movie;


import java.util.List;

/**
 * Сервис для сущности Movie
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */


public interface MovieService {

    List<Movie> getAll();

    Movie getByTitle(String title);

    void save(Movie movie);

    Movie change(Movie movie);

    void delete(Long id);

}
