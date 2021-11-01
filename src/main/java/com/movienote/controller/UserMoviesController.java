package com.movienote.controller;

import com.movienote.model.UserMovies;
import com.movienote.service.UserMoviesService;
import org.springframework.web.bind.annotation.*;

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

    private final UserMoviesService userMoviesService;

    public UserMoviesController(UserMoviesService userMoviesService) {
        this.userMoviesService = userMoviesService;
    }

    @GetMapping("/{user_id}")
    public List<UserMovies> getAllUserMoviesByUsername (@PathVariable ("user_id") Long id){

        return userMoviesService.getListByUserId(id);

    }

    @GetMapping()
    public UserMovies getUserMovies(@RequestParam ("id") Long id){
        return userMoviesService.getById(id);
    }

    @PostMapping()
    public UserMovies saveUserMovies(@RequestBody UserMovies userMovies) {

        return userMoviesService.save(userMovies);

    }

    @PutMapping()
    public UserMovies updateUserMovies(@RequestBody UserMovies userMovies){

        return userMoviesService.change(userMovies);

    }

    @DeleteMapping("{/id}")
    public void deleteUserMovie (@PathVariable("id") Long id){

        userMoviesService.delete(id);

    }
}
