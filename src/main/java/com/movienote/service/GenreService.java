package com.movienote.service;


import com.movienote.model.Genre;

import java.util.List;

/**
 * Сервис для сущности Genre
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */


public interface GenreService {


    List<Genre> getAll();

    Genre getByName(String name);

    void save(Genre genre);

    Genre change(Genre genre);

    void delete(Long id);

}
