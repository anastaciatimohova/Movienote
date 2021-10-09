
package com.movienote.service;


import com.movienote.model.UserMovies;
import com.movienote.repository.UserMoviesJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Реализация interface UserMoviesService
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */


@Service
public class UserMoviesServiceImplementation implements UserMoviesService {

    private final UserMoviesJpaRepository userMoviesJpaRepository;

    public UserMoviesServiceImplementation(UserMoviesJpaRepository userMoviesJpaRepository) {
        this.userMoviesJpaRepository = userMoviesJpaRepository;
    }

    @Override
    public List<UserMovies> getListByUserId(Long id) {

        return userMoviesJpaRepository.findAllByUserId(id);

    }

    @Override
    public UserMovies getById(Long id) {

        return userMoviesJpaRepository.findById(id).get();

    }

    @Override
    public UserMovies save(UserMovies userMovies) {

        return userMoviesJpaRepository.save(userMovies);

    }

    @Override
    public UserMovies change(UserMovies userMovies) {

        return userMoviesJpaRepository.save(userMovies);

    }

    @Override
    public void delete(Long id) {

        userMoviesJpaRepository.deleteById(id);

    }
}
