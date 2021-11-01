
package com.movienote.service.impl;

import com.movienote.model.Genre;
import com.movienote.repository.GenreJpaRepository;
import com.movienote.service.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Реализация interface GenreService
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@Transactional
@Service
public class GenreServiceImplementation implements GenreService {

    private final GenreJpaRepository genreJpaRepository;

    public GenreServiceImplementation(GenreJpaRepository genreJpaRepository) {
        this.genreJpaRepository = genreJpaRepository;
    }

    @Override
    public List<Genre> getAll() {

        return genreJpaRepository.findAll();

    }

    @Override
    public Genre getByName(String name) {

        return genreJpaRepository.findByName(name);

    }

    @Override
    public void save(Genre genre) {

        genreJpaRepository.save(genre);

    }

    @Override
    public Genre change(Genre genre) {

        return genreJpaRepository.save(genre);

    }

    @Override
    public void delete(Long id) {

        genreJpaRepository.deleteById(id);

    }
}
