package com.movienote.controller;

import com.movienote.model.User;
import com.movienote.service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для сущности User
 *
 * @version 1.0
 * @autor Ilkevich Anastasiya
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImplementation userService;

    @GetMapping()
    public List<User> getAllUsers() {

        return userService.getAll();

    }

    @GetMapping("/{username}")
    public User getUserByName(@PathVariable("username") String username) {

        return userService.getByName(username);

    }

    @PostMapping()
    public void saveUser(@RequestBody User user) {

        userService.save(user);

    }

    @PutMapping()
    public User updateUser(@RequestBody User user) {

        return userService.change(user);

    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable("username") String username) {

        userService.delete(username);

    }
}
