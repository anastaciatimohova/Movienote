package com.movienote.service;


import com.movienote.model.UserMovies;

import java.util.List;

/**
 * Сервис для сущности UserMovies
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */


public interface UserMoviesService {


    List<UserMovies> getListByUserId(Long id);

    UserMovies getById(Long id);

    UserMovies save(UserMovies userMovies);

    UserMovies change(UserMovies userMovies);

    void delete(Long id);
}
