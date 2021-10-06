package com.movienote.controller;

import com.movienote.model.UserMovies;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер для сущности UserMovies (которая является записной книжкой пользователя)
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@RestController
@RequestMapping("/notes")
public class UserMoviesController {

    @GetMapping("/{user_id}")
    public List<UserMovies> getAllUserMoviesByUsername (@PathVariable ("user_id") Long id){

        List<UserMovies> userMoviesList = new ArrayList<>();

        return userMoviesList;
    }

    @GetMapping("/{id}")
    public UserMovies getUserMovies(@PathVariable ("id") Long id){

        UserMovies userMovies = new UserMovies();

        return userMovies;
    }

    @PostMapping()
    public UserMovies saveUserMovies(@RequestBody UserMovies userMovies) {

        return userMovies;

    }

    @PutMapping()
    public UserMovies updateUserMovies(@RequestBody UserMovies userMovies){

        return userMovies;
    }

    @DeleteMapping("{/id}")
    public void deleteUserMovie (@PathVariable("id") Long id){

    }
}
