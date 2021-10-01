package com.movienote.controller;

import com.movienote.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер для сущности User
 *
 * @autor Ilkevich Anastasiya
 * @version 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping()
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        return users;
    }

    @GetMapping()
    public User getUserByName(@RequestParam(value = "username") String username) {

        User user = new User();

        return user;

    }

    @PostMapping()
    public User saveUser(@RequestBody User user) {

        return user;

    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id")Long id) {

        User user = new User();

        return user;
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable("username") String username) {

    }
}
