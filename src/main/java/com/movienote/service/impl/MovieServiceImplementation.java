
package com.movienote.service.impl;

import com.movienote.model.Movie;
import com.movienote.repository.MovieJpaRepository;
import com.movienote.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Реализация interface MovieService
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Transactional
@Service
public class MovieServiceImplementation implements MovieService {


    private final MovieJpaRepository movieJpaRepository;

    public MovieServiceImplementation(MovieJpaRepository movieJpaRepository) {
        this.movieJpaRepository = movieJpaRepository;
    }

    @Override
    public List<Movie> getAll() {
        return movieJpaRepository.findAll();
    }

    @Override
    public Movie getByTitle(String title) {

        return movieJpaRepository.findByTitle(title);

    }

    @Override
    public void save(Movie movie) {

        movieJpaRepository.save(movie);

    }

    @Override
    public Movie change(Movie movie) {

        return movieJpaRepository.save(movie);

    }

    @Override
    public void delete(Long id) {

        movieJpaRepository.deleteById(id);

    }

}
