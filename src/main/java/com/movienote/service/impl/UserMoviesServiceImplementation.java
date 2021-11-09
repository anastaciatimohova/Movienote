
package com.movienote.service.impl;


import com.movienote.exception.MovienoteServiceException;
import com.movienote.model.UserMovies;
import com.movienote.repository.UserMoviesJpaRepository;
import com.movienote.service.UserMoviesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Реализация interface UserMoviesService
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */


@Service
@AllArgsConstructor
public class UserMoviesServiceImplementation implements UserMoviesService {

    private final UserMoviesJpaRepository userMoviesJpaRepository;

    @Override
    public List<UserMovies> getListByUserId(Long id) {

        return userMoviesJpaRepository.findAllByUserId(id);
    }

    @Override
    public UserMovies getById(Long id) {

        return userMoviesJpaRepository.findById(id)
                .orElseThrow(() -> new MovienoteServiceException(String.format("No such movie with id: %s", id)));
    }

    @Override
    public UserMovies save(UserMovies userMovies) {

        return userMoviesJpaRepository.save(userMovies);
    }

    @Override
    public UserMovies change(UserMovies model) {

        UserMovies existing = getById(model.getId());
        updateFields(existing, model);
        return userMoviesJpaRepository.save(existing);
    }

    @Override
    public void delete(Long id) {

        userMoviesJpaRepository.deleteById(id);
    }

    private void updateFields(UserMovies existing, UserMovies model) {

        existing.setDescription(model.getDescription());
        existing.setRating(model.getRating());
        existing.setStatus(model.getStatus());
    }
}
